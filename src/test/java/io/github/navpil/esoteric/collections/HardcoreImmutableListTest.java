package io.github.navpil.esoteric.collections;

import io.github.navpil.esoteric.collections.models.ImmutableCar;
import io.github.navpil.esoteric.collections.models.ImmutableUser;
import io.github.navpil.esoteric.collections.models.MutableCar;
import io.github.navpil.esoteric.collections.models.MutableUser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HardcoreImmutableListTest {

    @Test
    void fineWithImmutableObjects() {
        ImmutableCar car = new ImmutableCar("Volvo", 4);
        ImmutableUser user = new ImmutableUser(car);
        new HardcoreImmutableList<>(Arrays.asList(user));
    }

    @Test
    void throwsOnMutableObjects() {
        MutableUser mutableUser = new MutableUser(new MutableCar("Ford Mutang", 4), "Mutant");
        HardcoreImmutableList.NoSneakyMutableObjectsHereException exception =
                assertThrows(HardcoreImmutableList.NoSneakyMutableObjectsHereException.class, () ->
                        new HardcoreImmutableList<>(Arrays.asList(mutableUser)));

        assert exception != null;
    }


}