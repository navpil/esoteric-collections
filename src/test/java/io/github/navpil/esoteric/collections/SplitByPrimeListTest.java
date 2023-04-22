package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.util.List;

class SplitByPrimeListTest {

    @Test
    void splitTest() {
        SplitByPrimeList<String> strings = new SplitByPrimeList<>();
        for (int i = 0; i < 9; i++) {
            strings.add("Str-" + i);
        }

        List<SplitByPrimeList<String>> split = strings.split();
        assert split.size() == 3;
        assert split.get(0).size() == 3;

        try {
            split.get(0).split();
            assert false;
        } catch (SplitByPrimeList.IAmPrimeNumberCollection e) {
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

}