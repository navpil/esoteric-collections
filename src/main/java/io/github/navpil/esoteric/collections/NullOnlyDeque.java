package io.github.navpil.esoteric.collections;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Memory optimized deque to store nulls only
 * @param <E>
 */
public class NullOnlyDeque<E> extends AbstractQueue<E> implements Deque<E> {

    private int size;

    public NullOnlyDeque() {
    }

    public NullOnlyDeque(Collection<E> collection) {
        this.size = collection.size();
        for (E e : collection) {
            if (e != null) {
                throw new PointerException();
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new NullIterator<>();
    }

    @Override
    public Iterator<E> descendingIterator() {
        return iterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(E e) {
        innerAdd(e);
    }

    @Override
    public void addLast(E e) {
        innerAdd(e);
    }

    @Override
    public boolean offerFirst(E e) {
        return innerAdd(e);
    }

    @Override
    public boolean offerLast(E e) {
        return innerAdd(e);
    }

    private boolean innerAdd(E e) {
        if (e != null) {
            throw new PointerException();
        }
        size++;
        return true;
    }

    @Override
    public E removeFirst() {
        return innerRemove(true);
    }

    @Override
    public E removeLast() {
        return innerRemove(true);
    }

    @Override
    public E pollFirst() {
        return innerRemove(false);
    }

    @Override
    public E pollLast() {
        return innerRemove(false);
    }

    @Override
    public E getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return null;
    }

    @Override
    public E getLast() {
        return getFirst();

    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        if (size > 0 && o == null) {
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return removeFirstOccurrence(o);
    }


    private E innerRemove(boolean shouldThrow) {
        if (size > 0) {
            size--;
            return null;
        }
        if (shouldThrow) {
            throw new NoSuchElementException();
        }
        return null;
    }


    @Override
    public boolean offer(E e) {
        return innerAdd(e);
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return removeFirst();
    }

    private class NullIterator<K> implements Iterator<K> {

        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < size;
        }

        @Override
        public K next() {
            counter++;
            return null;
        }

        @Override
        public void remove() {
            counter--;
            NullOnlyDeque.this.innerRemove(true);
        }
    }
}
