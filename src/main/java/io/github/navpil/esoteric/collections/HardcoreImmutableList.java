package io.github.navpil.esoteric.collections;

import java.util.ArrayList;
import java.util.List;

import static io.github.navpil.esoteric.collections.MutableClassHelper.isMutableClass;

public class HardcoreImmutableList<T> extends ConditionalListWrapper<T> {
    public HardcoreImmutableList(List<T> wrapped) {
        super(new ArrayList<>(throwIfHasMutableElements(wrapped)), BooleanBasedSimpleAllowCheck.getBuilder()
                .addForbidden()
                .removeForbidden()
                .setForbidden()
                .create());
    }

    private static <T> List<T> throwIfHasMutableElements(List<T> wrapped) {
        if (wrapped.isEmpty()) {
            return wrapped;
        }
        for (T t : wrapped) {
            if (isMutableClass(t.getClass())) {
                throw new NoSneakyMutableObjectsHereException();
            }
        }
        return wrapped;
    }


    public static class NoSneakyMutableObjectsHereException extends RuntimeException {
    }
}
