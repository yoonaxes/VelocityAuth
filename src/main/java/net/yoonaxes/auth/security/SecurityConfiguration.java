package net.yoonaxes.auth.security;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;

public class SecurityConfiguration extends OkaeriConfig {

    @CustomKey("networkAddressCacheTTL")
    @Comment("This is a value of networkaddress.cache.ttl security property.")
    @Comment("Default value is 30.")
    public int networkAddressCacheTTL = 30;

}
