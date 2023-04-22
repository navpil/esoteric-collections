package io.github.navpil.esoteric.collections;

import java.util.Collection;
import java.util.Set;

//Functionally the same as Collection, but can be used in places where `Set` is expected
public class ConditionalSetWrapper<T> extends ConditionalCollectionWrapper<T> implements Set<T> {
    public ConditionalSetWrapper(Collection<T> wrapped, AllowCheck allowCheck) {
        super(wrapped, allowCheck);
    }
}
