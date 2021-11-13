package net.yoonaxes.auth.command;

import com.google.common.collect.ImmutableList;
import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;

import java.util.List;

public abstract class Command implements SimpleCommand {

    protected abstract void onExecute(CommandSource source, String alias, String[] args);

    protected abstract List<String> onSuggest(CommandSource source, String alias, String[] args);

    protected final static ImmutableList<String> EMPTY_LIST = ImmutableList.of();

    @Override
    public void execute(Invocation invocation) {
        onExecute(invocation.source(), invocation.alias(), invocation.arguments());
    }

    @Override
    public List<String> suggest(Invocation invocation) {
        List<String> stringList = onSuggest(invocation.source(), invocation.alias(), invocation.arguments());

        if(stringList == null || stringList.isEmpty())
            return EMPTY_LIST;

        return stringList;
    }
}
