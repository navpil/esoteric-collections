package io.github.navpil.esoteric.collections.models;

public class MutableCar {
    private String name;
    private final int numberOfWheels;

    public MutableCar(String name, int numberOfWheels) {
        this.name = name;
        this.numberOfWheels = numberOfWheels;
    }
}
