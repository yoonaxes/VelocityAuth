package net.yoonaxes.auth.configuration;

import lombok.AccessLevel;
import lombok.Getter;
import net.yoonaxes.auth.AuthPlugin;
import net.yoonaxes.auth.configuration.impl.*;

import java.io.File;

/**
 * This is a manager of configurations.
 * @author yoonaxes
 */
public class ConfigurationManager {

    @Getter (value = AccessLevel.PRIVATE)
    private final File dataFolder = AuthPlugin.getAuth().getDataFolder();

    @Getter
    private final CommandConfiguration commandConfiguration =
            new ConfigurationFactory<CommandConfiguration>(CommandConfiguration.class)
                    .initialize(new File(getDataFolder(), "commands.yml"));

    @Getter
    private final LanguageConfiguration languageConfiguration =
            new ConfigurationFactory<LanguageConfiguration>(LanguageConfiguration.class)
                    .initialize(new File(getDataFolder(), "language.yml"));

    @Getter
    private final PluginConfiguration pluginConfiguration =
            new ConfigurationFactory<PluginConfiguration>(PluginConfiguration.class)
                    .initialize(new File(getDataFolder(), "config.yml"));

    @Getter
    private final ServerListConfiguration serverListConfiguration =
            new ConfigurationFactory<ServerListConfiguration>(ServerListConfiguration.class)
                    .initialize(new File(getDataFolder(), "server-list.yml"));

}
