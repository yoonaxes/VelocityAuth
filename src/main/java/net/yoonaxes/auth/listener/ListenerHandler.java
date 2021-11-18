package net.yoonaxes.auth.listener;

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

    protected abstract void onEvent(E event);
}
