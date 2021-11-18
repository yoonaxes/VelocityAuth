package net.yoonaxes.auth.listener.impl;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.proxy.Player;
import net.yoonaxes.auth.AuthPlugin;
import net.yoonaxes.auth.builder.shorts.MB;
import net.yoonaxes.auth.data.Account;
import net.yoonaxes.auth.listener.ListenerHandler;
import net.yoonaxes.auth.service.impl.AccountService;

public class PostLoginListener extends ListenerHandler<PostLoginEvent> {

    private final AccountService ACCOUNT_SERVICE = SERVICE_MANAGER.getAccountService();

    @Override
    @Subscribe
    protected void onEvent(PostLoginEvent event) {
        Player player = event.getPlayer();

        sendJoinMessage(player);

        Account account = ACCOUNT_SERVICE.find(player.getUniqueId());
        if(account == null) {

            if(player.isOnlineMode())
                account = ACCOUNT_SERVICE.create(
                        player.getUsername(),
                        player.getUniqueId(),
                        player.getRemoteAddress().getAddress().getHostAddress()
                );

            else {
                MB.of(LANGUAGE_CONFIGURATION.message.cracked.register).send(player);
            }

        } else if(!player.isOnlineMode()) {

            if(account.getSession().isLogged())
                account.getSession().setLoggedTime(0L);

            MB.of(LANGUAGE_CONFIGURATION.message.cracked.login).send(player);

        }
    }

    private void sendJoinMessage(Player player) {
        MB.of(LANGUAGE_CONFIGURATION.message.join)
                .withVariable("username", player.getUsername())
                .withVariable("online", AuthPlugin.getAuth().getProxy().getPlayerCount())
                .withVariable("account",
                        player.isOnlineMode()
                                ? "premium"
                                : "non-premium"
                )
                .withVariable("server",
                        player.getCurrentServer().isPresent()
                                ? player.getCurrentServer().get().getServerInfo().getName()
                                : "N/A"
                )
                .send(player);
    }
}
