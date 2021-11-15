package net.yoonaxes.auth.listener.impl;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PreLoginEvent;
import net.kyori.adventure.text.Component;
import net.yoonaxes.auth.api.MojangAPI;
import net.yoonaxes.auth.data.Account;
import net.yoonaxes.auth.listener.ListenerHandler;
import net.yoonaxes.auth.service.impl.AccountService;
import net.yoonaxes.auth.util.TranslateUtil;

public class PreLoginListener extends ListenerHandler<PreLoginEvent> {

    private final AccountService accountService = AUTH.getServiceManager().getAccountService();

    private final MojangAPI mojangAPI = AUTH.getMojangAPI();

    @Override
    @Subscribe
    protected void onEvent(PreLoginEvent event) {
        String username = event.getUsername();
        PreLoginEvent.PreLoginComponentResult result =
                PreLoginEvent.PreLoginComponentResult.allowed();

        Account account = accountService.find(username);

        if(result.isAllowed())
            result = findResult(username, account);

        event.setResult(result);
    }

    private PreLoginEvent.PreLoginComponentResult findResult(String username, Account account) {
        if(account == null) {
            try {

                return mojangAPI.isPremiumAccount(username)
                        ? PreLoginEvent.PreLoginComponentResult.forceOnlineMode()
                        : PreLoginEvent.PreLoginComponentResult.forceOfflineMode();

            } catch(Exception ex) {
                ex.printStackTrace();
                return PreLoginEvent.PreLoginComponentResult.denied(
                        Component.text(
                                TranslateUtil.translateString(LANGUAGE_CONFIGURATION.kick.mojangFailed)
                        )
                );
            }
        } else {
            return account.getType().isPremium()
                    ? PreLoginEvent.PreLoginComponentResult.forceOnlineMode()
                    : PreLoginEvent.PreLoginComponentResult.forceOfflineMode();
        }
    }
}
