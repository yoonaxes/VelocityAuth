package net.yoonaxes.auth.command.impl;

import com.velocitypowered.api.command.CommandSource;
import net.yoonaxes.auth.command.Command;
import net.yoonaxes.auth.util.chat.ChatUtil;

import java.util.List;

public class AuthCommand extends Command {

    @Override
    protected void onExecute(CommandSource source, String alias, String[] args) {
        ChatUtil.sendMessage(source, "&e&lVelocityAuth&r &8> &7Plugin created by &6yoonaxes&7.");
    }

    @Override
    protected List<String> onSuggest(CommandSource source, String alias, String[] args) {
        return EMPTY_LIST;
    }
}
