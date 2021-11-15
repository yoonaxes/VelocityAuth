package net.yoonaxes.auth.listener;

import net.yoonaxes.auth.AuthPlugin;
import net.yoonaxes.auth.VelocityAuth;
import net.yoonaxes.auth.configuration.impl.LanguageConfiguration;
import net.yoonaxes.auth.configuration.impl.PluginConfiguration;

/**
 * A listener handler is used to create a listeners.
 * @param <E> Velocity Event
 */
public abstract class ListenerHandler<E> {

    public final static VelocityAuth AUTH = AuthPlugin.getAuth();

    public final static PluginConfiguration PLUGIN_CONFIGURATION = AUTH.getConfigurationManager().getPluginConfiguration();
    public final static LanguageConfiguration LANGUAGE_CONFIGURATION = AUTH.getConfigurationManager().getLanguageConfiguration();

    public void register() {
        AUTH.getProxy().getEventManager().register(
                AuthPlugin.getInstance(),
                this
        );
    }

    protected abstract void onEvent(E event);
}
