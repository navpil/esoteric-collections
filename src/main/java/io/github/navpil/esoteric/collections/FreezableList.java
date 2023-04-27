package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * List with an ability to `freeze` collection, so it can never be ever modified again.
 * @param <T>
 */
public class FreezableList<T> extends ConditionalListWrapper<T> {
    public FreezableList(List<T> wrapped) {
        super(wrapped, new MutableFreezableAllowCheck());
    }

    public FreezableList() {
        super(new ArrayList<>(), new MutableFreezableAllowCheck());
    }

    public void freeze() {
        ((MutableFreezableAllowCheck)this.allowCheck).freeze();
    }


}
