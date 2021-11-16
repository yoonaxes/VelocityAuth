package net.yoonaxes.auth.listener;

import com.velocitypowered.api.event.Subscribe;
import net.yoonaxes.auth.AuthResources;

/**
 * A listener handler is used to create a listeners.
 * @param <E> Velocity Event
 */
public abstract class ListenerHandler<E> implements AuthResources {

    public void register() {
        AUTH.getProxy().getEventManager().register(
                PLUGIN,
                this
        );
    }

    @Subscribe
    public void callEvent(E event) {
        this.onEvent(event);
    }

    protected abstract void onEvent(E event);
}
