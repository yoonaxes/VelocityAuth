package net.yoonaxes.auth.listener.impl.server;

import com.velocitypowered.api.event.player.ServerPreConnectEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import net.yoonaxes.auth.listener.ListenerHandler;
import net.yoonaxes.auth.service.impl.AccountService;

public class ServerPreConnectListener extends ListenerHandler<ServerPreConnectEvent> {

    private final AccountService accountService = AUTH.getServiceManager().getAccountService();

    @Override
    protected void onEvent(ServerPreConnectEvent event) {
        Player player = event.getPlayer();
        RegisteredServer server = event.getOriginalServer();
        ServerPreConnectEvent.ServerResult result = event.getResult();
    }
}
