package io.github.navpil.esoteric.collections;

import java.util.HashMap;

/**
 * Adds a `hide` method for uniterable keys.
 * Having uniterable keys adds an extra layer of security.
 * Use UniterableMap for even higher security.
 * @param <K>
 * @param <V>
 */
public class HideMap<K,V> extends HashMap<K,V> {

    private HashMap<K,V> hideMap = new HashMap<>();

    @Override
    public V get(Object key) {
        V v = super.get(key);
        if (v == null) {
            v = hideMap.get(key);
        }
        return v;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        V v = get(key);
        if (v == null) {
            v = defaultValue;
        }
        return v;
    }

    public V hide(K key, V value) {
        return hideMap.put(key, value);
    }
}
