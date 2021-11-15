package net.yoonaxes.auth.configuration;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.yoonaxes.auth.configuration.impl.*;

import java.io.File;

/**
 * This is a manager of configurations.
 * @author yoonaxes
 */
@RequiredArgsConstructor
public class ConfigurationManager {

    @NonNull
    @Getter (value = AccessLevel.PRIVATE)
    private File dataFolder;

    @Getter
    private CommandConfiguration commandConfiguration =
            new ConfigurationFactory<CommandConfiguration>(CommandConfiguration.class)
                    .initialize(new File(this.getDataFolder(), "commands.yml"));

}
