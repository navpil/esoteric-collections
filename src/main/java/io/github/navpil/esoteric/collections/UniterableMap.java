package io.github.navpil.esoteric.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * keySet() and entrySet() unavailable, only get() is possible
 * Also you won't find out what is the size of this collection.
 * You should know the key to get the value, full stop.
 * @param <K>
 * @param <V>
 */
public class UniterableMap<K, V> implements Map<K, V> {

    private final Map<K,V> wrapped;

    public UniterableMap() {
        this(new HashMap<>());
    }

    public UniterableMap(Map<K, V> wrapped) {
        this.wrapped = wrapped;
    }


    @Override
    public int size() {
        //Let this map always appear empty. I don't want you to know how many elements I have
        return 0;
    }

    @Override
    public boolean isEmpty() {
        //Let this map always appear empty. I don't want you to know how many elements I have
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        return wrapped.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return wrapped.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return wrapped.get(key);
    }

    @Override
    public V put(K key, V value) {
        return wrapped.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return wrapped.remove(key);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        wrapped.putAll(m);
    }

    @Override
    public void clear() {
        wrapped.clear();
    }

    /**
     * I don't want to tell you that I don't support this operation,
     * so you don't try using reflection.
     * Same approach as returning 404 instead of 403 in web development
     */
    @Override
    public Set<K> keySet() {
        return Collections.emptySet();
    }

    /**
     * I don't want to tell you that I don't support this operation,
     * so you don't try using reflection.
     * Same approach as returning 404 instead of 403 in web development
     */
    @Override
    public Collection<V> values() {
        return Collections.emptySet();
    }

    /**
     * I don't want to tell you that I don't support this operation,
     * so you don't try using reflection.
     * Same approach as returning 404 instead of 403 in web development
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        return Collections.emptySet();
    }



}
