package net.yoonaxes.auth.listener.impl;

import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import net.kyori.adventure.text.Component;
import net.yoonaxes.auth.listener.ListenerHandler;

public class ProxyPingListener extends ListenerHandler<ProxyPingEvent> {

    @Override
    protected void onEvent(ProxyPingEvent event) {
        event.setPing(
                event.getPing().asBuilder()
                        .description(
                                Component.text("&6VelocityAuth &7simple motd")
                        )
                        .build()
        );
    }
}
