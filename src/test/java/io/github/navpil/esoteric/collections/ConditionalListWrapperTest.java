package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ConditionalListWrapperTest {

    @Test
    void get() {
        ConditionalListWrapper<String> strings = new ConditionalListWrapper<>(new ArrayList<String>(), null);
        strings.addAll(1, Collections.singleton("Hello"));

    }
}