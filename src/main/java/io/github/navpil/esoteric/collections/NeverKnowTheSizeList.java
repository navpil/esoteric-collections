package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;

public class NeverKnowTheSizeList<T> extends ConditionalListWrapper<T> {
    public NeverKnowTheSizeList(List<T> wrapped) {
        super(wrapped, EsotericCollectionsFactory.SIZE_FORBIDDEN);
    }

    public NeverKnowTheSizeList() {
        super(new ArrayList<>(), EsotericCollectionsFactory.SIZE_FORBIDDEN);
    }
}
