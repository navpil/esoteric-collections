package io.github.navpil.esoteric.collections;

public class MutableFreezableAllowCheck implements AllowCheck {

    private boolean frozen;

    @Override
    public void checkSizeAllowed() {
    }

    @Override
    public void checkContainsAllowed() {
    }

    @Override
    public void checkIterationAllowed() {
    }

    @Override
    public void checkAddAllowed() {
        if (frozen) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void checkRemoveAllowed() {
        if (frozen) {
            throw new UnsupportedOperationException();
        }
    }

    public void freeze() {
        frozen = true;
    }
}
