package net.yoonaxes.auth.configuration;

import com.google.common.collect.Lists;
import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.postprocessor.SectionSeparator;
import eu.okaeri.configs.serdes.OkaeriSerdesPack;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Validate;

import java.io.File;
import java.util.List;

/**
 * This is a factory for configuration.
 * @param <T> Configuration Class
 * @author yoonaxes
 */
@RequiredArgsConstructor
public class ConfigurationFactory<T extends OkaeriConfig> {


    @NonNull @Getter (value = AccessLevel.PRIVATE)
    private final Class<? extends OkaeriConfig> configurationClass;

    @Getter (value = AccessLevel.PRIVATE)
    private final List<OkaeriSerdesPack> serdesPackList = Lists.newArrayList();

    /**
     * Add your serdes pack to initializer.
     * @param serdesPack OkaeriSerdesPack object
     */
    public ConfigurationFactory<T> withSerdesPack(OkaeriSerdesPack serdesPack) {
        Validate.notNull(serdesPack, "A serdes pack value can't be null.");

        this.serdesPackList.add(serdesPack);
        return this;
    }

    /**
     * Initialize your configuration.
     * @param file Configuration YAML file.
     * @param sectionSeparator Section Separator String.
     * @return Initialized Configuration Class.
     */
    public T initialize(File file, String sectionSeparator) {
        Validate.notNull(file, "A file value can't be null.");
        Validate.notNull(sectionSeparator, "A section separator value can't be null.");

        return (T) ConfigManager.create(getConfigurationClass(), (initializer) -> {

            initializer.withConfigurer(new YamlSnakeYamlConfigurer("#", sectionSeparator));

            getSerdesPackList().forEach(initializer::withSerdesPack);

            initializer.withBindFile(file);
            initializer.saveDefaults();
            initializer.load(true);

        });
    }

    /**
     * Initialize your configuration.
     * @param file Configuration YAML file.
     * @return Initialized Configuration Class.
     */
    public T initialize(File file) {
        return initialize(file, SectionSeparator.NEW_LINE + SectionSeparator.NEW_LINE);
    }
}