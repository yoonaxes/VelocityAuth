package net.yoonaxes.auth.command.impl;

import com.velocitypowered.api.proxy.Player;
import net.yoonaxes.auth.builder.shorts.MB;
import net.yoonaxes.auth.command.PlayerCommand;
import net.yoonaxes.auth.data.Account;
import net.yoonaxes.auth.security.encryption.EncryptionSecurity;
import net.yoonaxes.auth.service.impl.AccountService;

import java.util.List;

public class LoginCommand extends PlayerCommand {

    private final AccountService ACCOUNT_SERVICE = SERVICE_MANAGER.getAccountService();
    private final EncryptionSecurity ENCRYPTION_SECURITY = SECURITY_MANAGER.getEncryptionSecurity();

    @Override
    protected void onExecute(Player player, String alias, String[] args) {

        when(player.isOnlineMode(),
                LANGUAGE_CONFIGURATION.message.onlyForCracked);

        Account account = ACCOUNT_SERVICE.find(
                player.getUniqueId()
        );

        whenNull(account,
                LANGUAGE_CONFIGURATION.message.cracked.register);

        when(account.getSession().isLogged(),
                LANGUAGE_CONFIGURATION.message.alreadyLogged);

        when(args.length < 1,
                LANGUAGE_CONFIGURATION.message.cracked.login);

        when(!ENCRYPTION_SECURITY.check(args[0], account.getPassword().getEncrypted()),
                LANGUAGE_CONFIGURATION.message.incorrectPassword);

        MB.of(LANGUAGE_CONFIGURATION.message.successfullyLogged).send(player);

    }

    @Override
    protected List<String> onSuggest(Player source, String alias, String[] args) {
        return EMPTY_LIST;
    }
}
