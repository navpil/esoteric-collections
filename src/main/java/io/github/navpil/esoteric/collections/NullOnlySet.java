package io.github.navpil.esoteric.collections;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * Set which allows only nulls
 * It's very space efficient if the only elements you want to store are nulls
 * @param <T>
 */
public class NullOnlySet<T> extends AbstractSet<T> {

    private boolean containsElement;

    @Override
    public Iterator<T> iterator() {
        return new NullIterator<>(containsElement);
    }

    @Override
    public boolean add(T t) {
        if (t != null) {
            throw new PointerException();
        }
        if (containsElement) {
            return false;
        } else {
            containsElement = true;
            return true;
        }
    }

    @Override
    public int size() {
        return containsElement ? 1 : 0;
    }

    @Override
    public boolean remove(Object o) {
        if (containsElement) {
            containsElement = false;
            return true;
        } else {
            return false;
        }
    }

    private class NullIterator<E> implements Iterator<E> {

        private boolean containsElement;

        public NullIterator(boolean containsElement) {
            this.containsElement = containsElement;
        }

        @Override
        public boolean hasNext() {
            return containsElement;
        }

        @Override
        public E next() {
            containsElement = false;
            return null;
        }

        @Override
        public void remove() {
            NullOnlySet.this.remove(null);
        }
    }
}
