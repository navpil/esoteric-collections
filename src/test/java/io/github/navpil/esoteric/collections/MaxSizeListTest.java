package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

class MaxSizeListTest {

    @Test
    void sanityCheck() {
        MaxSizeList<String> strings = new MaxSizeList<>(2);
        strings.add("One");
        for (int i = 0; i < 5; i++) {
            strings.add("s-" + i);
            assert strings.size() == 2;
        }
    }

}