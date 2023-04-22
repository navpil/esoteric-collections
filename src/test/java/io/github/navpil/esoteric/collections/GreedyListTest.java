package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.util.List;

class GreedyListTest {

    @Test
    void sanityCheck() {
        List<String> list = new GreedyList<>();

        list.add("Hello");
        list.add("World");

        assert list.size() == 2;

        try {
            System.out.println(list.get(1));
            assert false;
        } catch (UnsupportedOperationException e) {
            assert true;
        }


    }

}