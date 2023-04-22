package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreezableListTest {

    @Test
    void sanityCheck() {
        FreezableList<String> strings = new FreezableList<>();
        strings.add("One");
        strings.add("Two");
        strings.add("Three");

        strings.remove("Two");

        assert strings.size() == 2;

        strings.freeze();

        try {
            strings.add("Four");
            assert false;
        } catch (Exception e) {
        }
        try {
            strings.remove("One");
            assert false;
        } catch (Exception e) {
        }
    }

}