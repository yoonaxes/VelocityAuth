package net.yoonaxes.auth.listener.impl;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PreLoginEvent;
import net.yoonaxes.auth.AuthPlugin;
import net.yoonaxes.auth.api.MojangAPI;
import net.yoonaxes.auth.listener.ListenerHandler;

public class PreLoginListener extends ListenerHandler<PreLoginEvent> {

    private final MojangAPI mojangAPI = AuthPlugin.getAuth().getMojangAPI();

    @Override
    @Subscribe
    public void onEvent(PreLoginEvent event) {
        PreLoginEvent.PreLoginComponentResult result =
                PreLoginEvent.PreLoginComponentResult.allowed();

        if(result.isAllowed()) {

            try {

                result = mojangAPI.isPremiumAccount(event.getUsername())
                        ? PreLoginEvent.PreLoginComponentResult.forceOnlineMode()
                        : PreLoginEvent.PreLoginComponentResult.forceOfflineMode();

            } catch(Exception ex) {

                ex.printStackTrace();

            }
        }

        event.setResult(result);
    }
}
