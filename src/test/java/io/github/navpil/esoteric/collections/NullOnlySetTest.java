package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertThrows;

class NullOnlySetTest {

    @Test
    void sanityCheck() {
        Collection<String> set = new NullOnlySet<>();

        for (int i = 0; i < 5; i++) {
            set.add(null);
        }

        assertThrows(PointerException.class, () -> set.add("Hello world"));

        assert set.size() == 1;

        for (int i = 0; i < 1; i++) {
            boolean removed = set.remove(null);
            assert removed;
        }
        for (int i = 0; i < 5; i++) {
            boolean removed = set.remove(null);
            assert !removed;
        }

        assert set.size() == 0;

        for (int i = 0; i < 5; i++) {
            set.add(null);
        }

        for (String s : set) {
            assert s == null;
        }

        Iterator<String> iterator = set.iterator();
        assert iterator.hasNext();
        assert iterator.next() == null;

        iterator.remove();

        assert set.isEmpty();
    }

}