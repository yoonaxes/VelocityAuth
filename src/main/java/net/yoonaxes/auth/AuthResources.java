package net.yoonaxes.auth;

import net.yoonaxes.auth.configuration.ConfigurationManager;
import net.yoonaxes.auth.configuration.impl.LanguageConfiguration;
import net.yoonaxes.auth.configuration.impl.PluginConfiguration;
import net.yoonaxes.auth.feature.FeatureManager;
import net.yoonaxes.auth.security.SecurityManager;
import net.yoonaxes.auth.service.ServiceManager;

public interface AuthResources {

    VelocityAuth AUTH = AuthPlugin.getAuth();

    AuthPlugin PLUGIN = AuthPlugin.getInstance();

    ConfigurationManager CONFIGURATION_MANAGER = AUTH.getConfigurationManager();

    ServiceManager SERVICE_MANAGER = AUTH.getServiceManager();

    FeatureManager FEATURE_MANAGER = AUTH.getFeatureManager();

    SecurityManager SECURITY_MANAGER = AUTH.getSecurityManager();

    PluginConfiguration PLUGIN_CONFIGURATION = AUTH.getConfigurationManager().getPluginConfiguration();

    LanguageConfiguration LANGUAGE_CONFIGURATION = AUTH.getConfigurationManager().getLanguageConfiguration();

}
