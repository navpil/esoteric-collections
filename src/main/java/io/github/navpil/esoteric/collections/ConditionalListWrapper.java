package io.github.navpil.esoteric.collections;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ConditionalListWrapper<T> extends ConditionalCollectionWrapper<T> implements List<T> {

    private final List<T> wrapped;

    public ConditionalListWrapper(List<T> wrapped, AllowCheck allowCheck) {
        super(wrapped, allowCheck);
        this.wrapped = wrapped;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        checkAddAllowed();
        return wrapped.addAll(index, c);
    }

    @Override
    public T get(int index) {
        checkGetAllowed();
        return wrapped.get(index);
    }

    @Override
    public T set(int index, T element) {
        checkSetAllowed();
        return wrapped.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        checkAddAllowed();
        wrapped.add(index, element);
    }

    @Override
    public T remove(int index) {
        checkRemoveAllowed();
        return wrapped.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        checkContainsAllowed();
        return wrapped.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        checkContainsAllowed();
        return wrapped.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        checkIterationAllowed();
        return wrapped.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        checkIterationAllowed();
        return wrapped.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        //No checks on purpose, the sublist will have same checks
        return new ConditionalListWrapper<>(wrapped.subList(fromIndex, toIndex), this.allowCheck);
    }

    protected void checkGetAllowed() {
        allowCheck.checkGetAllowed();
    }
    protected void checkSetAllowed(){
        allowCheck.checkSetAllowed();
    }

    @Override
    public int hashCode() {
        return wrapped.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return wrapped.equals(obj);
    }

    @Override
    public String toString() {
        return wrapped.toString();
    }
}
