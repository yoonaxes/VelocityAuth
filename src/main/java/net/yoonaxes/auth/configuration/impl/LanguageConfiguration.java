package net.yoonaxes.auth.configuration.impl;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.*;

import java.util.List;

@Names(
        modifier = NameModifier.TO_LOWER_CASE,
        strategy = NameStrategy.HYPHEN_CASE
)
public class LanguageConfiguration extends OkaeriConfig {

    @CustomKey("prefix-variable")
    @Comment("Use {$} in messages configuration to use prefix short.")
    public String prefix = "&6&lVelocityAuth &8\u00BB";

    @CustomKey("kick-messages")
    @Comment("A kick messages configuration.")
    public KickConfiguration kick = new KickConfiguration();

    @CustomKey("chat-messages")
    @Comment("A messages configuration.")
    public MessageConfiguration message = new MessageConfiguration();

    public static class KickConfiguration extends OkaeriConfig {

        @Comment("A kick message when player logging and Mojang Authentication has an error.")
        public String mojangFailed = "&cSomethink goes wrong with Mojang Authentication.";

    }

    public static class MessageConfiguration extends OkaeriConfig {

        @Comment("A message displays when player joins to the server.")
        public List<String> join = List.of("{$} &7You joined with &e${ACCOUNT} &7account.");

        @Comment("A messages for non-premiun players.")
        public Cracked cracked = new Cracked();

        public static class Cracked extends OkaeriConfig {

            public List<String> login = List.of("{$} &7Login using &e/login (password)");

            public List<String> register = List.of("{$} &7Register using &e/register (password) (password)");

        }
    }
}
