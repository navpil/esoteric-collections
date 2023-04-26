package io.github.navpil.esoteric.collections.models;

public class ImmutableUser {

    private final ImmutableCar car;

    public ImmutableUser(ImmutableCar car) {
        this.car = car;
    }
}
