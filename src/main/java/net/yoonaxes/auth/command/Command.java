package net.yoonaxes.auth.command;

import com.google.common.collect.ImmutableList;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import eu.okaeri.configs.OkaeriConfig;
import lombok.*;
import net.yoonaxes.auth.AuthPlugin;
import org.apache.commons.lang3.Validate;

import java.util.List;

public abstract class Command implements SimpleCommand {

    protected abstract void onExecute(CommandSource source, String alias, String[] args);

    protected abstract List<String> onSuggest(CommandSource source, String alias, String[] args);

    protected final static ImmutableList<String> EMPTY_LIST = ImmutableList.of();

    public void register(String name, String... aliases) {
        Validate.notNull(name, "A name value can't be null.");
        Validate.notNull("A aliases value can't be null.");

        AuthPlugin.getAuth().getProxy().getCommandManager().register(
                name,
                this,
                aliases
        );
    }

    public void register(Command.Configuration configuration) {
        Validate.notNull(configuration, "A configuration value can't be null");

        this.register(
                configuration.getName(),
                configuration.getAliases()
                        .toArray(new String[0])
        );
    }

    @Override
    public void execute(Invocation invocation) {
        onExecute(invocation.source(), invocation.alias(), invocation.arguments());
    }

    @Override
    public List<String> suggest(Invocation invocation) {
        return onSuggest(
                invocation.source(),
                invocation.alias(),
                invocation.arguments()
        );
    }

    @AllArgsConstructor
    public static class Configuration extends OkaeriConfig {

        @Getter
        private String name;

        @Getter
        private List<String> aliases;

    }
}
