package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

class N2ListTest {

    @Test
    void sanityCheck() {
        List<String> list = new N2List<>();

        for (int i = 0; i < 5; i++) {
            list.add("String" + i);
        }

        assert list.size() == 5;

        for (int i = 3; i >= 1; i--) {
            String removed = list.remove(i);
        }

        assert list.size() == 2;

        list.remove(1);

        assert list.size() == 1;

        for (String s : list) {
            Assertions.assertEquals("String0", s);
        }

        Iterator<String> iterator = list.iterator();
        assert iterator.hasNext();
        assert "String0".equals(iterator.next());

        iterator.remove();

        assert list.isEmpty();
    }

}