package net.yoonaxes.auth.service;

import com.google.common.collect.Maps;
import lombok.AccessLevel;
import lombok.Getter;
import org.apache.commons.lang3.Validate;

import java.util.HashMap;

/**
 * Service system helps in managing the facilities.
 * @param <K> Map Key Object Type
 * @param <V> Map Value Object Type
 * @author yoonaxes
 */
public abstract class Service<K, V> {

    @Getter (value = AccessLevel.PROTECTED)
    private final HashMap<K, V> map = Maps.newHashMap();

    /**
     * Create a instance of Service.
     */
    public Service() {
        this.onRegister();
    }

    /**
     * Default method to find a service value using key.
     * @param key A key to find value
     * @return Found value or null
     */
    public V find(K key) {
        Validate.notNull(key, "A key value can't be null.");

        return map.getOrDefault(key, null);
    }

    /**
     * Abstract void performed after create an instance.
     */
    protected abstract void onRegister();
}
