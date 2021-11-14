package net.yoonaxes.auth.listener;

import net.yoonaxes.auth.AuthPlugin;

/**
 * A listener handler is used to create a listeners.
 * @param <E> Velocity Event
 */
public abstract class ListenerHandler<E> {

    public void register() {
        AuthPlugin.getAuth().getProxy().getEventManager().register(
                AuthPlugin.getInstance(),
                this
        );
    }

    protected abstract void onEvent(E event);
}
