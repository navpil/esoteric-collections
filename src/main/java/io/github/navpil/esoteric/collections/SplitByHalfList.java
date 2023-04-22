package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SplitByHalfList<T> extends ConditionalListWrapper<T> {

    public SplitByHalfList() {
        this(new ArrayList<>());
    }
    public SplitByHalfList(List<T> wrapped) {
        super(wrapped, EsotericCollectionsFactory.ALLOW_ALL);
    }

    public List<SplitByHalfList<T>> split() {
        if (size() % 2 != 0) {
            throw new IAmNotEvenSizedCollection();
        }
        Random random = new Random();
        ArrayList<SplitByHalfList<T>> emptySplitByHalfLists = new ArrayList<>();
        ArrayList<SplitByHalfList<T>> fullSplitByHalfLists = new ArrayList<>();
        emptySplitByHalfLists.add(new SplitByHalfList<>());
        emptySplitByHalfLists.add(new SplitByHalfList<>());

        int size = size();
        int newSize = size / 2;
        for (int i = 0; i < size; i++) {
            SplitByHalfList<T> partialList = emptySplitByHalfLists.get(random.nextInt(emptySplitByHalfLists.size()));
            partialList.add(get(i));
            if (partialList.size() == newSize) {
                emptySplitByHalfLists.remove(partialList);
                fullSplitByHalfLists.add(partialList);
            }
        }
        return fullSplitByHalfLists;
    }

    public static class IAmNotEvenSizedCollection extends RuntimeException {
    }
}
