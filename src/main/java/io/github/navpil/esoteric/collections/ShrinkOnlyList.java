package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Collection with elements is created and no additional `add` are possible
 * @param <T>
 */
public class ShrinkOnlyList<T> extends ConditionalListWrapper<T> {
    public ShrinkOnlyList(List<T> wrapped) {
        super(new ArrayList<>(wrapped), EsotericCollectionsFactory.ONLY_SHRINKING);
    }

}
