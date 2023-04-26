package io.github.navpil.esoteric.collections.models;


public class MutableUser {
    private final MutableCar car;
    private final String name;

    public MutableUser(MutableCar car, String name) {
        this.car = car;
        this.name = name;
    }

}
