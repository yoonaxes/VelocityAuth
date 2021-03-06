package net.yoonaxes.auth.configuration.impl;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.*;
import net.yoonaxes.auth.command.Command;

import java.util.List;

@Names(
        strategy = NameStrategy.IDENTITY,
        modifier = NameModifier.NONE
)
public class CommandConfiguration extends OkaeriConfig {

    @CustomKey("commands")
    @Comment("A configuration of all commands.")
    public CommandsConfiguration CMD = new CommandsConfiguration();

    public static class CommandsConfiguration extends OkaeriConfig {

        public Command.Configuration AUTH = new Command.Configuration(
                "auth",
                List.of("velocityauth")
        );

        public Command.Configuration LOGIN = new Command.Configuration(
                "login",
                List.of("l", "log")
        );

        public Command.Configuration REGISTER = new Command.Configuration(
                "register",
                List.of("reg")
        );

        public Command.Configuration CHANGEPASSWORD = new Command.Configuration(
                "changepassword",
                List.of("changepass")
        );

        @Exclude
        public Command.Configuration PREMIUM = new Command.Configuration(
                "premium",
                List.of()
        );
    }
}
