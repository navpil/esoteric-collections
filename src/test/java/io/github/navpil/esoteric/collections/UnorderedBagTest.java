package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UnorderedBagTest {

    @Test
    void addAllSanityCheck() {

        UnorderedBag<String> ts = new UnorderedBag<>();
        ts.add("1");
        ts.add("1");
        ts.add("1");

        ts.addAll(2, Arrays.asList("2", "3", "4" , "5"));

        assert ts.get(0).equals("1");
        assert ts.get(1).equals("1");
        assert ts.get(6).equals("1");

    }
}