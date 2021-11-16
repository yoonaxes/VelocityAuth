package net.yoonaxes.auth.configuration.impl;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.*;
import net.yoonaxes.auth.security.SecurityConfiguration;

@Names(
        modifier = NameModifier.TO_LOWER_CASE,
        strategy = NameStrategy.HYPHEN_CASE
)
public class PluginConfiguration extends OkaeriConfig {

    @Comment("A premium players is logging automatically.")
    public boolean autoLoginPremium = true;

    @Comment("A security configuration.")
    public SecurityConfiguration security = new SecurityConfiguration();

}
