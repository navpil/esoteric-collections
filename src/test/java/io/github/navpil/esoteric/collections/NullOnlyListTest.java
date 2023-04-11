package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

class NullOnlyListTest {

    @Test
    void sanityCheck() {
        List<String> list = new NullOnlyList<>();

        for (int i = 0; i < 5; i++) {
            list.add(null);
        }

        list.add("Hello world");

        assert list.size() == 5;

        for (int i = 0; i < 3; i++) {
            boolean removed = list.remove(null);
            assert removed;
        }

        assert list.size() == 2;

        list.remove(0);

        assert list.size() == 1;

        for (String s : list) {
            assert s == null;
        }

        Iterator<String> iterator = list.iterator();
        assert iterator.hasNext();
        assert iterator.next() == null;

        iterator.remove();

        assert list.isEmpty();


    }

}