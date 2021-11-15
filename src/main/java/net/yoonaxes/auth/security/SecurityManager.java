package net.yoonaxes.auth.security;

import lombok.Getter;
import net.yoonaxes.auth.AuthPlugin;

import java.security.Security;

/**
 * This is a manager of security.
 * @author yoonaxes
 */
public class SecurityManager {

    @Getter
    private final SecurityConfiguration configuration =
            AuthPlugin.getAuth().getConfigurationManager().getPluginConfiguration().security;

    public SecurityManager() {
        setNetworkAddressCacheTTL();
    }

    private void setNetworkAddressCacheTTL() {
        String propertyValue = String.valueOf(getConfiguration().networkAddressCacheTTL);
        if(!Security.getProperty("networkaddress.cache.ttl").equals(propertyValue))
            Security.setProperty("networkaddress.cache.ttl", propertyValue);
    }
}
