package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;

public class ShrinkOnlyList<T> extends ConditionalListWrapper<T> {
    public ShrinkOnlyList(List<T> wrapped) {
        super(new ArrayList<>(wrapped), EsotericCollectionsFactory.ONLY_SHRINKING);
    }

}
