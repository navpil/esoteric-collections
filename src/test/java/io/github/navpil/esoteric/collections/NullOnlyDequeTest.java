package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("AssertWithSideEffects")
class NullOnlyDequeTest {

    @Test
    void sanityCheck() {
        NullOnlyDeque<String> nulls = new NullOnlyDeque<>();

        for (int i = 0; i < 5; i++) {
            nulls.add(null);
        }

        assert nulls.size() == 5;
        assertThrows(PointerException.class, () -> nulls.add("Hello"));

        assert nulls.peekFirst() == null;
        assert nulls.removeFirst() == null;
        assert nulls.removeFirstOccurrence(null);
        assert !nulls.removeFirstOccurrence("Hello");

        assert nulls.size() == 3;

        for (String aNull : nulls) {
            assert aNull == null;
        }

        Iterator<String> iterator = nulls.iterator();
        assert iterator.hasNext();
        assert iterator.next() == null;
        iterator.remove();

        assert nulls.size() == 2;
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }

        assert nulls.isEmpty();

        assertThrows(NoSuchElementException.class, nulls::removeLast);

    }

    @Test
    void constructorCheck() {
        new NullOnlyDeque<>(Arrays.asList(null, null));

        assertThrows(PointerException.class, () -> new NullOnlyDeque<>(Arrays.asList(null, "World")));
    }

}