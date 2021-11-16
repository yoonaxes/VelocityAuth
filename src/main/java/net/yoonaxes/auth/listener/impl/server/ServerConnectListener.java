package net.yoonaxes.auth.listener.impl.server;

import com.velocitypowered.api.event.player.ServerConnectedEvent;
import com.velocitypowered.api.proxy.Player;
import net.yoonaxes.auth.listener.ListenerHandler;

public class ServerConnectListener extends ListenerHandler<ServerConnectedEvent> {

    @Override
    protected void onEvent(ServerConnectedEvent event) {
        Player player = event.getPlayer();
    }
}
