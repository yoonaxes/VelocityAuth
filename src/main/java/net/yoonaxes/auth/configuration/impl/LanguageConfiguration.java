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

        @Comment("A message displays when some unexpected error occurs while player executing a command.")
        public List<String> expcetion = List.of(
                "{$} &cWhile executing a commands some unexpected error occurs."
        );

        @Comment("A message displays when premium player tries to perform non-premium command.")
        public String onlyForCracked = "{$} &cYou're premium player and can't perform that command.";

        @Comment("A message displays when player tries to log in when already logged.")
        public String alreadyLogged = "{$} &cYou're already logged";

        @Comment("A message displays when player tries to use password with the wrong length.")
        public String passwordLength = "{$} &cPassword must be between 4 and 16 characters.";

        @Comment("A message displays when player entered two different passwords.")
        public String passwordIncorrectRepeatedPassword = "{$} &cThe entered passwords do not match.";

        @Comment("A message displays when player tries to log in with incorrect password.")
        public String passwordIncorrect = "{$} &cThe entered password is incorrect.";

        @Comment("A messagege displays when player tries to use the same password.")
        public String passwordUsed = "{$} &cThe specified password is already used. Choose a different password.";

        @Comment("A message displays when player joins to the server.")
        public List<String> join = List.of("{$} &7You joined with &e${ACCOUNT} &7account.");

        @Comment("A messages displays when something goes wrong while player logging.")
        public String loginError = "{$} &cAn error occurred while logging.";

        @Comment("A messages displays when something goes wrong while player registering a new account.")
        public String registerError = "{$} &cAn error occurred while creating the account.";

        @Comment("A messages displays when something goes wrong while player changing a password.")
        public String changepasswordError = "{$} &cAn error occurred while chaining a password.";

        @Comment("A messages displays when player successfully log in.")
        public List<String> successfullyLogged = List.of("{$} &7Successfully logged in!");

        @Comment("A messages displays when player successfully registered account.")
        public List<String> successfullyRegistred = List.of("{$} &7Successfully registered account!");

        @Comment("A messages displays when player successfully changed a password.")
        public List<String> successfullyChangedPassword = List.of("{$} &7Successfully changed your password!");

        @Comment("A messages for non-premiun players.")
        public Cracked cracked = new Cracked();

        public static class Cracked extends OkaeriConfig {

            public String login = "{$} &7Login using &e/login (password)";

            public String register = "{$} &7Register using &e/register (password) (repeat password)";

            public String changePassword = "{$} &7Change your password using &e/changepassword (your password) (new password) (repeat new password)";

        }
    }
}
