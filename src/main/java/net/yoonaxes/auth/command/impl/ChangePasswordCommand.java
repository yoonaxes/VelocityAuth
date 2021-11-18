package net.yoonaxes.auth.command.impl;

import com.velocitypowered.api.proxy.Player;
import net.yoonaxes.auth.builder.shorts.MB;
import net.yoonaxes.auth.command.PlayerCommand;
import net.yoonaxes.auth.command.ValidateException;
import net.yoonaxes.auth.data.Account;
import net.yoonaxes.auth.security.encryption.EncryptionSecurity;
import net.yoonaxes.auth.service.impl.AccountService;
import java.util.List;

public class ChangePasswordCommand extends PlayerCommand {

    private final static AccountService ACCOUNT_SERVICE = SERVICE_MANAGER.getAccountService();
    private final static EncryptionSecurity ENCRYPTION_SECURITY = SECURITY_MANAGER.getEncryptionSecurity();

    @Override
    protected void onExecute(Player player, String alias, String[] args) {

        when(player.isOnlineMode(),
                LANGUAGE_CONFIGURATION.message.onlyForCracked);

        Account account = ACCOUNT_SERVICE.find(
                player.getUniqueId()
        );

        whenNull(account,
                LANGUAGE_CONFIGURATION.message.cracked.register);

        when(args.length < (PLUGIN_CONFIGURATION.mustRepeatPassword ? 3 : 2),
                LANGUAGE_CONFIGURATION.message.cracked.register);

        String password = args[1];

        when(password.length() < 4 || password.length() > 16,
                LANGUAGE_CONFIGURATION.message.passwordLength);

        when(PLUGIN_CONFIGURATION.mustRepeatPassword && !password.equalsIgnoreCase(args[2]),
                LANGUAGE_CONFIGURATION.message.passwordIncorrectRepeatedPassword);

        String accountEncryptedPassword = account.getPassword().getEncrypted();

        when(!ENCRYPTION_SECURITY.check(args[0], accountEncryptedPassword),
                LANGUAGE_CONFIGURATION.message.passwordIncorrect);

        when(!ENCRYPTION_SECURITY.check(args[1], accountEncryptedPassword),
                LANGUAGE_CONFIGURATION.message.passwordUsed);

        try {

            account.getPassword().setEncrypted(
                    ENCRYPTION_SECURITY.encrypt(password)
            );

        } catch (Exception ex) {

            throw new ValidateException(LANGUAGE_CONFIGURATION.message.changepasswordError, true);

        }

        MB.of(LANGUAGE_CONFIGURATION.message.successfullyChangedPassword).send(player);
    }

    @Override
    protected List<String> onSuggest(Player source, String alias, String[] args) {
        if(PLUGIN_CONFIGURATION.mustRepeatPassword
                && PLUGIN_CONFIGURATION.suggestRepeatPassword
                && args.length == 3
                && args[1].startsWith(args[2]))
            return List.of(args[1]);

        return EMPTY_LIST;
    }
}
