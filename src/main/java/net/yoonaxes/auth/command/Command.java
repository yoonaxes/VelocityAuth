package net.yoonaxes.auth.command;

import com.google.common.collect.ImmutableList;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import eu.okaeri.configs.OkaeriConfig;
import lombok.*;
import net.yoonaxes.auth.AuthResources;
import net.yoonaxes.auth.builder.shorts.MB;
import org.apache.commons.lang3.Validate;

import java.util.List;

public abstract class Command implements AuthResources, SimpleCommand {

    protected abstract void onExecute(CommandSource source, String alias, String[] args);

    protected abstract List<String> onSuggest(CommandSource source, String alias, String[] args);

    protected final static ImmutableList<String> EMPTY_LIST = ImmutableList.of();

    public void register(String name, String... aliases) {
        Validate.notNull(name, "A name value can't be null.");
        Validate.notNull(aliases, "A aliases value can't be null.");

        AUTH.getProxy().getCommandManager().register(name, this, aliases);
    }

    public void register(Command.Configuration configuration) {
        Validate.notNull(configuration, "A configuration value can't be null");

        register(configuration.name, configuration.aliases.toArray(String[]::new));
    }

    @Override
    public void execute(Invocation invocation) {
        try {

            onExecute(invocation.source(), invocation.alias(), invocation.arguments());

        } catch (ValidateException ex) {

            MB.of(ex.getMessage())
                    .send(invocation.source());

        } catch (Exception ex) {

            ex.printStackTrace();

            MB.of(String.format("{$} &cSomething goes wrong while executing this command. &7(%s)", ex.getClass().getSimpleName()))
                    .send(invocation.source());

        }
    }

    @Override
    public List<String> suggest(Invocation invocation) {
        return onSuggest(
                invocation.source(),
                invocation.alias(),
                invocation.arguments()
        );
    }

    public static void when(boolean expression, String message) {
        if(expression)
            throw new ValidateException(message);
    }

    public static void whenNull(Object object, String message) {
        if(object == null)
            throw new ValidateException(message);
    }

    public static void whenNotNull(Object object, String message) {
        if(object != null)
            throw new ValidateException(message);
    }

    @AllArgsConstructor
    public static class Configuration extends OkaeriConfig {

        public String name;

        public List<String> aliases;

    }
}

