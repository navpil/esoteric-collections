package io.github.navpil.esoteric.collections.models;

public class ImmutableCar {
    private final String name;
    private final int numberOfWheels;

    public ImmutableCar(String name, int numberOfWheels) {
        this.name = name;
        this.numberOfWheels = numberOfWheels;
    }
}
