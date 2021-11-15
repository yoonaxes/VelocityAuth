package net.yoonaxes.auth.command.impl;

import com.velocitypowered.api.command.CommandSource;
import net.yoonaxes.auth.builder.shorts.MB;
import net.yoonaxes.auth.command.Command;

import java.util.List;

public class AuthCommand extends Command {

    @Override
    protected void onExecute(CommandSource source, String alias, String[] args) {
        MB.of(String.format("{$} &7Plugin &e%s &7created by &e&n%s&r&7.", "VelocityAuth", "yoonaxes"))
                .send(source);
    }

    @Override
    protected List<String> onSuggest(CommandSource source, String alias, String[] args) {
        return EMPTY_LIST;
    }
}
