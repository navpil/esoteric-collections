package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

class ShrinkOnlyListTest {

    @Test
    void sanityCheck() {
        ShrinkOnlyList<String> strings = new ShrinkOnlyList<>(Arrays.asList("One", "Two", "Three"));

        for (Iterator<String> iterator = strings.iterator(); iterator.hasNext(); ) {
            String next = iterator.next();
            if ("Two".equals(next)) {
                iterator.remove();
            }
        }

        assert strings.size() == 2;

        try {
            strings.add("Four");
            assert false;
        } catch (UnsupportedOperationException e) {
            assert true;
        }
    }

}