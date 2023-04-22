package io.github.navpil.esoteric.collections;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EsotericCollectionsFactoryTest {

    @Test
    void createForbidAllOperationsList() {

        List<String> list = EsotericCollectionsFactory.createForbidAllOperationsList("One", "Two");

        try {
            System.out.println(list.size());
            assert false;
        } catch (Exception e) {
            assert true;
        }
    }
}