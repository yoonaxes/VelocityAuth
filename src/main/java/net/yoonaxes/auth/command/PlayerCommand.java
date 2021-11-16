package net.yoonaxes.auth.command;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.proxy.Player;

import java.util.List;

public abstract class PlayerCommand extends Command {

    protected abstract void onExecute(Player player, String alias, String[] args);

    protected abstract List<String> onSuggest(Player player, String alias, String[] args);

    @Override
    protected void onExecute(CommandSource source, String alias, String[] args) {

        when(!(source instanceof Player), "This command is not available for console.");

        onExecute((Player) source, alias, args);

    }

    @Override
    protected List<String> onSuggest(CommandSource source, String alias, String[] args) {
        if(!(source instanceof Player))
            return EMPTY_LIST;

        return onSuggest(
                (Player) source,
                alias,
                args
        );
    }
}
