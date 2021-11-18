package net.yoonaxes.auth.configuration.impl;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.*;
import net.yoonaxes.auth.security.SecurityConfiguration;

@Names(
        modifier = NameModifier.TO_LOWER_CASE,
        strategy = NameStrategy.HYPHEN_CASE
)
public class PluginConfiguration extends OkaeriConfig {

    @Comment("Mojang Authentication")
    @Comment("If value is false, all players will be connected to server in offline mode and premium accounts will not be logged automatically.")
    public boolean mojangAuthentication = true;

    @Comment("Repeat Password")
    @Comment("If value is true the player need to repeat password when creating a new account or changing old password.")
    @Comment("You must remember to need change usage of commands in language.yml!")
    public boolean mustRepeatPassword = true;

    @Comment("Suggest repeat password")
    @Comment("If value is true a tab completion suggest a password to repeat.")
    public boolean suggestRepeatPassword = true;

    @Comment("Security Configuration")
    @Comment("A security configuration.")
    public SecurityConfiguration security = new SecurityConfiguration();

}
