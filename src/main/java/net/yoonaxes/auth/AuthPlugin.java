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

/**
 * An open source professional Velocity plugin used for authenticate premium and non-premium players.
 * @author yoonaxes
 */

@Plugin(
        id="velocity-auth",
        name="VelocityAuth",
        version = "0.1",
        authors = "yoonaxes",
        description = "An open source professional Velocity plugin used for authenticate premium and non-premium players.",
        url = "https://github.com/yoonaxes/VelocityAuth"
)
public class AuthPlugin {

    @Getter
    @Setter (value = AccessLevel.PRIVATE)
    private static AuthPlugin instance;

    @Getter (value = AccessLevel.PROTECTED)
    private final ProxyServer proxy;

    @Getter (value = AccessLevel.PROTECTED)
    private final Logger logger;

    @Getter (value = AccessLevel.PROTECTED)
    private final Path dataDirectory;

    @Inject
    public AuthPlugin(ProxyServer proxy, Logger logger, @DataDirectory Path dataDirectory) {
        this.proxy = proxy;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        logger.info("Successfully initialized {} plugin.", getClass().getSimpleName());
    }

    @Subscribe
    public void onProxyReload(ProxyReloadEvent event) {
        logger.info("Successfully reloaded {} plugin.", getClass().getSimpleName());
    }

    @Subscribe
    public void onProxyShutdown(ProxyShutdownEvent event) {
        logger.info("Successfully disabled {} plugin.", getClass().getSimpleName());
    }
}
