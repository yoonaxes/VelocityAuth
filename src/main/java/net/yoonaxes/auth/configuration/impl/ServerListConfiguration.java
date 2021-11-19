package net.yoonaxes.auth.configuration.impl;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.NameModifier;
import eu.okaeri.configs.annotation.NameStrategy;
import eu.okaeri.configs.annotation.Names;

import java.util.List;

@Names(
        modifier = NameModifier.TO_LOWER_CASE,
        strategy = NameStrategy.HYPHEN_CASE
)
public class ServerListConfiguration extends OkaeriConfig {

    @Comment("If false all features for server list ping will be disabled.")
    public boolean enabled = true;

    public Description description = new Description();

    public static class Description extends OkaeriConfig {

        public boolean enabled = true;

        @Comment("List of list ping descriptions.")
        public List<String> descriptionList = List.of(
                "&6&lVelocityAuth &8> &7Plugin created by &eyoonaxes&7.\n" +
                        "&6&lVelocityAuth &8> &7Github: &fhttps://github.com/yoonaxes"
        );

    }
}
