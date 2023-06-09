package io.github.navpil.esoteric.collections;

import java.util.AbstractList;

/**
 * List which allows only nulls.
 * It's very space efficient if the only elements you want to store are nulls
 * @param <T>
 */
public class NullOnlyList<T> extends AbstractList<T> {

    private int size;

    @Override
    public void add(int index, T t) {
        if (t == null) {
            size++;
        } else {
            throw new PointerException();
        }
    }

    @Override
    public T get(int index) {
        if (index < size) {
            return null;
        } else {
            throw new IndexOutOfBoundsException("Bad index: " + index);
        }
    }

    @Override
    public boolean remove(Object o) {
        if (o == null && size > 0) {
            size--;
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index < size) {
            size--;
            return null;
        } else {
            throw new IndexOutOfBoundsException("Bad index: " + index);
        }
    }

    @Override
    public int size() {
        return size;
    }

}
