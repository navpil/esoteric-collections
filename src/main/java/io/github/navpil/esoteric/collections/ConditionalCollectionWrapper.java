package io.github.navpil.esoteric.collections;

import java.util.Collection;
import java.util.Iterator;

public class ConditionalCollectionWrapper<T> implements Collection<T> {

    private final Collection<T> wrapped;
    protected final AllowCheck allowCheck;

    public ConditionalCollectionWrapper(Collection<T> wrapped, AllowCheck allowCheck) {
        this.wrapped = wrapped;
        this.allowCheck = allowCheck == null ? EsotericCollectionsFactory.ALLOW_ALL : allowCheck;
    }

    @Override
    public int size() {
        checkSizeAllowed();
        return wrapped.size();
    }

    @Override
    public boolean isEmpty() {
        checkSizeAllowed();
        return wrapped.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        checkContainsAllowed();
        return wrapped.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        checkIterationAllowed();
        return wrapped.iterator();
    }


    @Override
    public Object[] toArray() {
        checkIterationAllowed();
        return wrapped.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        checkIterationAllowed();
        return wrapped.toArray(a);
    }

    @Override
    public boolean add(T t) {
        checkAddAllowed();

        return wrapped.add(t);
    }

    @Override
    public boolean remove(Object o) {
        checkRemoveAllowed();
        return wrapped.remove(o);
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        checkContainsAllowed();
        return wrapped.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        checkAddAllowed();
        return wrapped.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        checkRemoveAllowed();
        return wrapped.removeAll(c);
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        checkRemoveAllowed();
        return wrapped.retainAll(c);
    }

    @Override
    public void clear() {
        checkRemoveAllowed();
        wrapped.clear();
    }

    protected void checkSizeAllowed(){
        allowCheck.checkSizeAllowed();
    }

    protected void checkContainsAllowed(){
        allowCheck.checkContainsAllowed();
    }

    protected void checkIterationAllowed(){
        allowCheck.checkIterationAllowed();
    }

    protected void checkAddAllowed(){
        allowCheck.checkAddAllowed();
    }

    protected void checkRemoveAllowed(){
        allowCheck.checkRemoveAllowed();
    }

}
