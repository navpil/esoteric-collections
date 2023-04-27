package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Allows to split the list exactly by lowest prime
 * @param <T>
 */
public class SplitByPrimeList<T> extends ConditionalListWrapper<T> {

    public SplitByPrimeList() {
        this(new ArrayList<>());
    }
    public SplitByPrimeList(List<T> wrapped) {
        super(wrapped, EsotericCollectionsFactory.ALLOW_ALL);
    }

    public List<SplitByPrimeList<T>> split() {
        int splitBy = lowestPrime(size());
        Random random = new Random();
        ArrayList<SplitByPrimeList<T>> emptySplits = new ArrayList<>();
        for (int i = 0; i < splitBy; i++) {
            emptySplits.add(new SplitByPrimeList<>());
        }

        ArrayList<SplitByPrimeList<T>> fullSplits = new ArrayList<>();

        int size = size();
        int newSize = size / splitBy;

        for (int i = 0; i < size; i++) {
            SplitByPrimeList<T> partialList = emptySplits.get(random.nextInt(emptySplits.size()));
            partialList.add(get(i));
            if (partialList.size() == newSize) {
                emptySplits.remove(partialList);
                fullSplits.add(partialList);
            }
        }
        return fullSplits;
    }

    private static int lowestPrime(int size) {
        if (size % 2 == 0) {
            return 2;
        }
        long sqrt = Math.round(Math.sqrt(size));
        int div = 3;
        while (div <= sqrt) {
            if (size % div == 0) {
                return div;
            }
            div += 2;
        }
        throw new IAmPrimeNumberCollection();
    }

    public static class IAmPrimeNumberCollection extends RuntimeException {
    }
}
