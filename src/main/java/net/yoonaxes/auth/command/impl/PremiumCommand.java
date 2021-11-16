package net.yoonaxes.auth.command.impl;

import com.velocitypowered.api.proxy.Player;
import net.yoonaxes.auth.command.PlayerCommand;
import net.yoonaxes.auth.security.encryption.EncryptionSecurity;
import net.yoonaxes.auth.service.impl.AccountService;
import net.yoonaxes.auth.util.chat.ChatUtil;

import java.util.List;

public class PremiumCommand extends PlayerCommand {

    private final AccountService ACCOUNT_SERVICE = SERVICE_MANAGER.getAccountService();
    private final EncryptionSecurity ENCRYPTION_SECURITY = SECURITY_MANAGER.getEncryptionSecurity();

    @Override
    protected void onExecute(Player player, String alias, String[] args) {
        ChatUtil.sendMessage(player, "&8\u00B7 &7Command is in &aTODO &7list.");
    }

    @Override
    protected List<String> onSuggest(Player source, String alias, String[] args) {
        return EMPTY_LIST;
    }
}
