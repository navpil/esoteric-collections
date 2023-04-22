package io.github.navpil.esoteric.collections;

import java.util.HashMap;

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
