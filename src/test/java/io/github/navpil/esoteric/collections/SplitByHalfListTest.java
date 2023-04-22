package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.util.List;

class SplitByHalfListTest {

    @Test
    void sanityCheck() {

        SplitByHalfList<String> list = new SplitByHalfList<>();
        for (int i = 0; i < 10; i++) {
            list.add("Element-" + i);
        }

        List<SplitByHalfList<String>> split = list.split();
        assert split.size() == 2;
        assert split.get(0).size() == 5;
        assert split.get(1).size() == 5;

        System.out.println(split);

    }

}