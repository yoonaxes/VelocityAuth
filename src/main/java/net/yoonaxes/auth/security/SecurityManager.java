package net.yoonaxes.auth.security;

import lombok.Getter;
import net.yoonaxes.auth.AuthPlugin;
import net.yoonaxes.auth.security.encryption.EncryptionSecurity;

import java.security.Security;

/**
 * This is a manager of security.
 * @author yoonaxes
 */
public class SecurityManager {

    @Getter
    private final SecurityConfiguration configuration =
            AuthPlugin.getAuth().getConfigurationManager().getPluginConfiguration().security;

    @Getter
    private EncryptionSecurity encryptionSecurity;

    public SecurityManager() {
        setNetworkAddressCacheTTL();
        encryptionSecurity = new EncryptionSecurity(configuration.encryptionCost);
    }

    private void setNetworkAddressCacheTTL() {
        String propertyValue = String.valueOf(getConfiguration().networkAddressCacheTTL);
        if(!Security.getProperty("networkaddress.cache.ttl").equals(propertyValue))
            Security.setProperty("networkaddress.cache.ttl", propertyValue);
    }
}
