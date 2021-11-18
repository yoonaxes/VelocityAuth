package net.yoonaxes.auth;

import com.velocitypowered.api.proxy.ProxyServer;
import lombok.*;
import net.yoonaxes.auth.api.MojangAPI;
import net.yoonaxes.auth.command.impl.*;
import net.yoonaxes.auth.configuration.ConfigurationManager;
import net.yoonaxes.auth.configuration.impl.CommandConfiguration;
import net.yoonaxes.auth.feature.FeatureManager;
import net.yoonaxes.auth.listener.impl.DisconnectListener;
import net.yoonaxes.auth.listener.impl.PostLoginListener;
import net.yoonaxes.auth.listener.impl.PreLoginListener;
import net.yoonaxes.auth.listener.impl.ProxyPingListener;
import net.yoonaxes.auth.security.AuthSecurityManager;
import net.yoonaxes.auth.service.ServiceManager;
import org.slf4j.Logger;

import java.io.File;

@RequiredArgsConstructor
public class Auth implements VelocityAuth {

    @NonNull
    @Getter
    private final ProxyServer proxy;

    @NonNull
    @Getter
    private final Logger logger;

    @NonNull
    @Getter
    private File dataFolder;

    @Getter
    private ConfigurationManager configurationManager;

    @Getter
    private ServiceManager serviceManager;

    @Getter
    private FeatureManager featureManager;

    @Getter
    private AuthSecurityManager securityManager;

    @Getter
    private MojangAPI mojangAPI = new MojangAPI();

    @Override
    public void onInitialize() {

        if(!dataFolder.exists())
            dataFolder.mkdir();

        mojangAPI = new MojangAPI();

        registerManagers();

        registerCommands();

        registerListeners();

    }

    @Override
    public void onReload() {
        configurationManager = new ConfigurationManager();
    }

    @Override
    public void onShutdown() {

    }

    private void registerManagers() {

        configurationManager = new ConfigurationManager();

        serviceManager = new ServiceManager();

        featureManager = new FeatureManager();

        securityManager = new AuthSecurityManager();

    }

    private void registerCommands() {
        CommandConfiguration configuration = getConfigurationManager().getCommandConfiguration();

        new AuthCommand()
                .register(configuration.CMD.AUTH);

        new LoginCommand()
                .register(configuration.CMD.LOGIN);

        new RegisterCommand()
                .register(configuration.CMD.REGISTER);

        new ChangePasswordCommand()
                .register(configuration.CMD.CHANGEPASSWORD);

    }

    private void registerListeners() {

        new PreLoginListener()
                .register();

        new PostLoginListener()
                .register();

        new DisconnectListener()
                .register();

        if(getConfigurationManager().getServerListConfiguration().enabled)
            new ProxyPingListener()
                    .register();
    }
}