package net.yoonaxes.auth.command.impl;

import com.velocitypowered.api.proxy.Player;
import net.yoonaxes.auth.builder.shorts.MB;
import net.yoonaxes.auth.command.PlayerCommand;
import net.yoonaxes.auth.command.ValidateException;
import net.yoonaxes.auth.data.Account;
import net.yoonaxes.auth.security.encryption.EncryptionSecurity;
import net.yoonaxes.auth.service.impl.AccountService;

import java.util.List;

public class RegisterCommand extends PlayerCommand {

    private final AccountService ACCOUNT_SERVICE = SERVICE_MANAGER.getAccountService();
    private final EncryptionSecurity ENCRYPTION_SECURITY = SECURITY_MANAGER.getEncryptionSecurity();

    @Override
    protected void onExecute(Player player, String alias, String[] args) {
        when(player.isOnlineMode(),
                LANGUAGE_CONFIGURATION.message.onlyForCracked);

        Account account = ACCOUNT_SERVICE.find(
                player.getUniqueId()
        );

        when(account != null && account.getSession().isLogged(),
                LANGUAGE_CONFIGURATION.message.alreadyLogged);

        whenNotNull(account,
                LANGUAGE_CONFIGURATION.message.cracked.login);

        when(args.length < (PLUGIN_CONFIGURATION.mustRepeatPassword ? 2 : 1),
                LANGUAGE_CONFIGURATION.message.cracked.register);

        String password = args[0];

        when(password.length() < 4 || password.length() > 16,
                LANGUAGE_CONFIGURATION.message.passwordLength);

        when(PLUGIN_CONFIGURATION.mustRepeatPassword && !password.equals(args[1]),
                LANGUAGE_CONFIGURATION.message.passwordIncorrectRepeatedPassword);

        try {

            ACCOUNT_SERVICE.create(
                    player.getUsername(),
                    player.getUniqueId(),
                    player.getRemoteAddress()
                            .getAddress().getHostAddress(),
                    ENCRYPTION_SECURITY.encrypt(password),
                    true
            );

            MB.of(LANGUAGE_CONFIGURATION.message.successfullyRegistred).send(player);

        } catch (Exception ex) {

            throw new ValidateException(LANGUAGE_CONFIGURATION.message.registerError, true);

        }
    }

    @Override
    protected List<String> onSuggest(Player source, String alias, String[] args) {
        if(PLUGIN_CONFIGURATION.mustRepeatPassword
                && PLUGIN_CONFIGURATION.suggestRepeatPassword
                && args.length == 2
                && args[0].startsWith(args[1]))
            return List.of(args[0]);

        return EMPTY_LIST;
    }
}
