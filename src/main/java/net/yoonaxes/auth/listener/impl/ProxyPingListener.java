package net.yoonaxes.auth.listener.impl;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.proxy.server.ServerPing;
import net.kyori.adventure.text.Component;
import net.yoonaxes.auth.configuration.impl.ServerListConfiguration;
import net.yoonaxes.auth.listener.ListenerHandler;
import net.yoonaxes.auth.util.RandomUtil;
import net.yoonaxes.auth.util.TranslateUtil;

import java.util.List;

public class ProxyPingListener extends ListenerHandler<ProxyPingEvent> {

    private final static ServerListConfiguration CONFIGURATION = CONFIGURATION_MANAGER.getServerListConfiguration();
    private final static List<String> DESCRIPTION_LIST = CONFIGURATION.description.descriptionList;

    @Override
    @Subscribe
    protected void onEvent(ProxyPingEvent event) {
        if(!CONFIGURATION.enabled)
            return;

        ServerPing.Builder builder = event.getPing().asBuilder();
        if(CONFIGURATION.description.enabled) {
            String description = TranslateUtil.translateString(
                    DESCRIPTION_LIST.get(
                            DESCRIPTION_LIST.size() <= 1 ? 0 :
                            RandomUtil.randomInteger(0, DESCRIPTION_LIST.size())
                    )
            );
            builder.description(Component.text(description));
        }

        event.setPing(builder.build());
    }
}
