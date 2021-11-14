package net.yoonaxes.auth.command.impl;

import com.velocitypowered.api.proxy.Player;
import net.yoonaxes.auth.command.PlayerCommand;
import net.yoonaxes.auth.util.ChatUtil;

import java.util.List;

public class RegisterCommand extends PlayerCommand {

    @Override
    protected void onExecute(Player player, String alias, String[] args) {
        ChatUtil.sendMessage(player, "&8\u00B7 &7Command is in &eTODO &7list.");
    }

    @Override
    protected List<String> onSuggest(Player source, String alias, String[] args) {
        return EMPTY_LIST;
    }
}