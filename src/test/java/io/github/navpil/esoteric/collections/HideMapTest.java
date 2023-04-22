package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HideMapTest {

    @Test
    void sanityCheck() {
        HideMap<String, String> map = new HideMap<>();

        map.put("One", "One-value");
        map.hide("Two", "Secret-value");

        assert map.size() == 1;
        assert map.get("One").equals("One-value");
        assert map.get("Two").equals("Secret-value");
    }

}