package io.github.navpil.esoteric.collections;

import java.util.HashSet;
import java.util.List;

import static io.github.navpil.esoteric.collections.MutableClassHelper.isMutableClass;

/**
 * Will throw if passed a mutable class as a member
 * @param <T>
 */
public class HardcoreImmutableSet<T> extends ConditionalSetWrapper<T> {
    public HardcoreImmutableSet(List<T> wrapped) {
        super(new HashSet<>(throwIfHasMutableElements(wrapped)), BooleanBasedSimpleAllowCheck.getBuilder()
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
