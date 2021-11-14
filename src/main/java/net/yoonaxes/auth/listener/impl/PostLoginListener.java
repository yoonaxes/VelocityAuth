package net.yoonaxes.auth.listener.impl;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.proxy.Player;
import net.yoonaxes.auth.listener.ListenerHandler;
import net.yoonaxes.auth.util.ChatUtil;

public class PostLoginListener extends ListenerHandler<PostLoginEvent> {

    @Override
    @Subscribe
    public void onEvent(PostLoginEvent event) {
        Player player = event.getPlayer();

        ChatUtil.sendMessage(player, "&8\u00B7 &7You joined with &" + (player.isOnlineMode() ? "apremium" : "cnon-premium") + " &7account.");
    }
}
