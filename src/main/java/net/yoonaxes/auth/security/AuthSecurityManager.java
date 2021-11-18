package net.yoonaxes.auth.security;

import lombok.Getter;
import net.yoonaxes.auth.security.encryption.EncryptionSecurity;

import java.security.Security;

/**
 * This is a manager of security.
 * @author yoonaxes
 */
public class AuthSecurityManager {

    @Getter
    private EncryptionSecurity encryptionSecurity;

    public AuthSecurityManager() {
        //setNetworkAddressCacheTTL(30);
        encryptionSecurity = new EncryptionSecurity();
    }

    private void setNetworkAddressCacheTTL(int networkAddressCacheTTL) {
        String propertyValue = String.valueOf(networkAddressCacheTTL);
        if(!Security.getProperty("networkaddress.cache.ttl").equals(propertyValue))
            Security.setProperty("networkaddress.cache.ttl", propertyValue);
    }
}
