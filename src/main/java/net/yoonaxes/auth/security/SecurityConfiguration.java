package net.yoonaxes.auth.security;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.CustomKey;

public class SecurityConfiguration extends OkaeriConfig {

    @CustomKey("networkAddressCacheTTL")
    @Comment("This is a value of networkaddress.cache.ttl security property.")
    @Comment("Default value is 30. (Recommended)")
    public int networkAddressCacheTTL = 30;

    @CustomKey("encryption-cost")
    @Comment("This is a value of encryption costs. (BCrypt method)")
    @Comment("The higher value the more CPU is used for password encryption.")
    @Comment("Minimum = 10, Maximum = 30")
    @Comment("Default value is 12. (Recommended)")
    public int encryptionCost = 12;

}
