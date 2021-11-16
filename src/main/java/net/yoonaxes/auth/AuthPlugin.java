package net.yoonaxes.auth;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyReloadEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import lombok.*;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(
        id="velocity-auth",
        name="Auth",
        version = "0.1",
        authors = "yoonaxes",
        description = "An powerful open source professional Velocity plugin which contains authenticate " +
                "and logging system and has security features that protect your proxy against attacks.",
        url = "https://github.com/yoonaxes/VelocityAuth"
)
public class AuthPlugin {

    @Getter
    private static AuthPlugin instance;

    @Getter
    private static VelocityAuth auth;

    @Inject
    public AuthPlugin(ProxyServer proxy, Logger logger, @DataDirectory Path dataDirectory) {

        instance = this;

        auth = new Auth(proxy, logger, dataDirectory.toFile());

    }

    @Subscribe
    public void onProxyInitialize(ProxyInitializeEvent event) {
        if(auth == null) return;
        auth.onInitialize();
        auth.getLogger().info("Successfully initialized {} plugin.", VelocityAuth.class.getSimpleName());
    }

    @Subscribe
    public void onProxyReload(ProxyReloadEvent event) {
        if(auth == null) return;
        auth.onReload();
        auth.getLogger().info("Successfully reloaded {} plugin.", VelocityAuth.class.getSimpleName());
    }

    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        if(auth == null) return;
        auth.onShutdown();
        auth.getLogger().info("Successfully disabled {} plugin.", VelocityAuth.class.getSimpleName());
    }
}
