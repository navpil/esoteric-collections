package io.github.navpil.esoteric.collections;

import io.github.navpil.esoteric.collections.models.ImmutableCar;
import io.github.navpil.esoteric.collections.models.ImmutableUser;
import io.github.navpil.esoteric.collections.models.MutableCar;
import io.github.navpil.esoteric.collections.models.MutableUser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static io.github.navpil.esoteric.collections.MutableClassHelper.isMutableClass;

class MutableClassHelperTest {

    @ParameterizedTest
    @ValueSource(classes = {
            String.class,
            Integer.class
    })
    void testPrimitives(Class<?> clazz) {
        assert !isMutableClass(clazz);
    }

    @ParameterizedTest
    @ValueSource(classes = {
            ImmutableCar.class,
            ImmutableUser.class
    })
    void testImmutableClasess() {
        assert !isMutableClass(ImmutableCar.class);
        assert !isMutableClass(ImmutableUser.class);
    }

    @ParameterizedTest
    @ValueSource(classes = {
            MutableCar.class,
            MutableUser.class
    })
    void testMutableClasses(Class<?> clazz) {
        assert isMutableClass(clazz);
    }

}