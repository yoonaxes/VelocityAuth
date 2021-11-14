package net.yoonaxes.auth.configuration;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import net.yoonaxes.auth.configuration.impl.CommandConfiguration;

/**
 * This is a manager of configurations.
 * @author yoonaxes
 */
@RequiredArgsConstructor
public class ConfigurationManager {

    @NonNull
    @Getter
    private CommandConfiguration commandConfiguration;

}
