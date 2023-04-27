package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Size and isEmpty are forbidden. Why do you need those anyway?
 * @param <T>
 */
public class NeverKnowTheSizeList<T> extends ConditionalListWrapper<T> {
    public NeverKnowTheSizeList(List<T> wrapped) {
        super(wrapped, EsotericCollectionsFactory.SIZE_FORBIDDEN);
    }

    public NeverKnowTheSizeList() {
        super(new ArrayList<>(), EsotericCollectionsFactory.SIZE_FORBIDDEN);
    }
}
