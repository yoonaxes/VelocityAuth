package net.yoonaxes.auth;

import com.velocitypowered.api.proxy.ProxyServer;
import net.yoonaxes.auth.api.MojangAPI;
import net.yoonaxes.auth.configuration.ConfigurationManager;
import net.yoonaxes.auth.feature.FeatureManager;
import net.yoonaxes.auth.service.ServiceManager;
import org.slf4j.Logger;

import java.io.File;

/**
 * An powerful open source professional Velocity plugin which contains authenticate
 * and logging system and has security features that protect your proxy against attacks.
 * @author yoonaxes
 */
public interface VelocityAuth {

    /**
     * Method invokes on initialize a proxy.
     */
    void onInitialize();

    /**
     * Method invokes on reload a proxy.
     */
    void onReload();

    /**
     * Method invokes on shutdown a proxy.
     */
    void onShutdown();

    /**
     * Get a ProxyServer.
     * @return A com.velocitypowered.api.proxy.ProxyServer
     */
    ProxyServer getProxy();

    /**
     * Get a Logger.
     * @return A org.slf4j.Logger
     */
    Logger getLogger();

    /**
     * Get a data folder File.
     * @return A java.io.File
     */
    File getDataFolder();

    /**
     * Get a ConfigurationManager
     * @return net.yoonaxes.auth.configuration.ConfigurationManager
     */
    ConfigurationManager getConfigurationManager();

    /**
     * Get a ServiceManager
     * @return net.yoonaxes.auth.service.ServiceManager
     */
    ServiceManager getServiceManager();

    /**
     * Get a FeatureManager
     * @return net.yoonaxes.auth.feature.FeatureManager
     */
    FeatureManager getFeatureManager();

    /**
     * Get a MojangAPI
     * @return A net.yoonaxes.auth.api.MojangAPI
     */
    MojangAPI getMojangAPI();

}
