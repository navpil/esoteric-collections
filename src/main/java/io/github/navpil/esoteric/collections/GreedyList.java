package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;

public class GreedyList<T> extends ConditionalListWrapper<T> {
    public GreedyList(List<T> wrapped) {
        super(wrapped, EsotericCollectionsFactory.GREEDY_CHECK);
    }

    public GreedyList() {
        super(new ArrayList<>(), EsotericCollectionsFactory.GREEDY_CHECK);
    }
}
