package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static io.github.navpil.esoteric.collections.EsotericCollectionsFactory.ALLOW_ALL;

/**
 * Removes random element on .add() if capacity is exceeded
 * @param <T>
 */
public class MaxSizeList<T> extends ConditionalListWrapper<T> {

    private static final int DEFAULT_MAX_SIZE = 42;
    private final int maxSize;
    private final Random random = new Random();

    public MaxSizeList(List<T> wrapped, int maxSize) {
        super(wrapped, ALLOW_ALL);
        this.maxSize = maxSize;
        maintainInvariant();
    }

    private void maintainInvariant() {
        while (maxSize < size()) {
            remove(random.nextInt(size()));
        }
    }

    public MaxSizeList(int maxSize) {
        this(new ArrayList<>(), maxSize);
    }

    public MaxSizeList() {
        this(new ArrayList<>(), DEFAULT_MAX_SIZE);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean b = super.addAll(c);
        maintainInvariant();
        return b;
    }

    @Override
    public boolean add(T t) {
        boolean add = super.add(t);
        maintainInvariant();
        return add;
    }

    @Override
    public void add(int index, T element) {
        super.add(index, element);
        maintainInvariant();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        boolean b = super.addAll(index, c);
        maintainInvariant();
        return b;
    }
}
