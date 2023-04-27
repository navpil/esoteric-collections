package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Very greedy collection which wants only to receive new elements and tell you how much elements
 * it has, but it won't tell you what are these elements excactly.
 * Removal is also not possible.
 * @param <T>
 */
public class GreedyList<T> extends ConditionalListWrapper<T> {
    public GreedyList(List<T> wrapped) {
        super(wrapped, EsotericCollectionsFactory.GREEDY_CHECK);
    }

    public GreedyList() {
        super(new ArrayList<>(), EsotericCollectionsFactory.GREEDY_CHECK);
    }
}
