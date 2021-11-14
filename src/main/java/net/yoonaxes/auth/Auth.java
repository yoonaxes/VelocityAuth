package net.yoonaxes.auth;

import com.velocitypowered.api.proxy.ProxyServer;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.yoonaxes.auth.api.MojangAPI;
import net.yoonaxes.auth.command.impl.*;
import net.yoonaxes.auth.configuration.ConfigurationFactory;
import net.yoonaxes.auth.configuration.ConfigurationManager;
import net.yoonaxes.auth.configuration.impl.CommandConfiguration;
import net.yoonaxes.auth.listener.impl.PostLoginListener;
import net.yoonaxes.auth.listener.impl.PreLoginListener;
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
    private MojangAPI mojangAPI;

    @Override
    public void onLoad() {

    }

    @Override
    public void onInitialize() {

        if(!dataFolder.exists())
            dataFolder.mkdir();

        configurationManager = new ConfigurationManager(
                new ConfigurationFactory<CommandConfiguration>(CommandConfiguration.class)
                        .initialize(new File(dataFolder, "commands.yml"))
        );

        serviceManager = new ServiceManager();

        mojangAPI = new MojangAPI();

        registerCommands(
                configurationManager.getCommandConfiguration()
        );

        registerListeners();

    }

    @Override
    public void onReload() {

    }

    @Override
    public void onShutdown() {

    }

    private void registerCommands(CommandConfiguration configuration) {

        new AuthCommand()
                .register(configuration.CMD.AUTH);

        new LoginCommand()
                .register(configuration.CMD.LOGIN);

        new RegisterCommand()
                .register(configuration.CMD.REGISTER);

        new ChangePasswordCommand()
                .register(configuration.CMD.CHANGEPASSWORD);

        new PremiumCommand()
                .register(configuration.CMD.PREMIUM);

    }

    private void registerListeners() {

        new PreLoginListener()
                .register();

        new PostLoginListener()
                .register();

    }
}
