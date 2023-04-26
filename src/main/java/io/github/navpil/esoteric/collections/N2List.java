package io.github.navpil.esoteric.collections;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;

public class N2List<E> extends AbstractList<E> {

    private E[][] elements;

    public N2List() {
        elements = createBackingArray(0);
    }

    public N2List(Collection<E> collection) {
        elements = createBackingArray(collection.size());
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index-1);
        E[][] backingArray = createBackingArray(size() + 1);
        for (int i = 0; i < index; i++) {
            backingArray[i][i] = elements[i][i];
        }
        backingArray[index][index] = element;
        for (int i = index; i < size(); i++) {
            backingArray[i+1][i+1] = elements[i][i];
        }
        elements = backingArray;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (i == index && j == index) {
                    return elements[i][j];
                }
            }
        }
        return null;
    }

    private void checkIndex(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E[][] backingArray = createBackingArray(size() - 1);
        for (int i = 0; i < index; i++) {
            backingArray[i][i] = elements[i][i];
        }
        for (int i = index+1; i < size(); i++) {
            backingArray[i-1][i-1] = elements[i][i];
        }
        E returnValue = elements[index][index];
        elements = backingArray;
        return returnValue;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public Iterator<E> iterator() {
        return super.iterator();
    }

    private static <E> E[][] createBackingArray(int size) {
        Object[][] objects = new Object[size][];

        for (int i = 0; i < size; i++) {
            objects[i] = new Object[size];
        }
        
        return (E[][])objects;
    }
}
