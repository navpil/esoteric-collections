package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class UnorderedBag<T> extends ArrayList<T> {

    private Random random = new Random();

    @Override
    public boolean add(T t) {
        super.add(random.nextInt(size() + 1), t);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            this.add(t);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        rangeCheckForAdd(index);
        int i = 1;
        for (T t : c) {
            int insertionIndex = random.nextInt(i++);
            add(index + insertionIndex, t);
        }
        return true;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size();
    }

}
