package net.yoonaxes.auth.listener.impl;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import net.yoonaxes.auth.data.Account;
import net.yoonaxes.auth.listener.ListenerHandler;
import net.yoonaxes.auth.service.impl.AccountService;

public class DisconnectListener extends ListenerHandler<DisconnectEvent> {

    private final static AccountService ACCOUNT_SERVICE = SERVICE_MANAGER.getAccountService();

    @Override
    @Subscribe
    protected void onEvent(DisconnectEvent event) {
        Account account = ACCOUNT_SERVICE.find(event.getPlayer().getUsername());

        if(account == null)
            return;

        if(account.getSession().isLogged())
            account.getSession().setLoggedTime(0L);
    }
}
