package io.github.navpil.esoteric.collections;

public class AllowCheckImpl implements AllowCheck {

    private final boolean sizeForbidden;
    private final boolean containsForbidden;
    private final boolean iterationForbidden;
    private final boolean addForbidden;
    private final boolean removeForbidden;
    private final boolean getForbidden;
    private final boolean setForbidden;

    private AllowCheckImpl(boolean sizeForbidden, boolean containsForbidden, boolean iterationForbidden, boolean addForbidden, boolean removeForbidden, boolean getForbidden, boolean setForbidden) {
        this.sizeForbidden = sizeForbidden;
        this.containsForbidden = containsForbidden;
        this.iterationForbidden = iterationForbidden;
        this.addForbidden = addForbidden;
        this.removeForbidden = removeForbidden;
        this.getForbidden = getForbidden;
        this.setForbidden = setForbidden;
    }

    @Override
    public void checkSizeAllowed() {
        if (sizeForbidden) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void checkContainsAllowed() {
        if (containsForbidden) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void checkIterationAllowed() {
        if (iterationForbidden) {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public void checkAddAllowed() {
        if (addForbidden) {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public void checkRemoveAllowed() {
        if (removeForbidden) {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public void checkSetAllowed() {
        if (setForbidden) {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public void checkGetAllowed() {
        if (getForbidden) {
            throw new UnsupportedOperationException();
        }
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private boolean sizeForbidden;
        private boolean containsForbidden;
        private boolean iterationForbidden;
        private boolean addForbidden;
        private boolean removeForbidden;
        private Boolean getForbidden;
        private Boolean setForbidden;

        public Builder sizeForbidden() {
            this.sizeForbidden = true;
            return this;
        }

        public Builder containsForbidden() {
            this.containsForbidden = true;
            return this;
        }

        public Builder iterationForbidden() {
            this.iterationForbidden = true;
            return this;
        }

        public Builder addForbidden() {
            this.addForbidden = true;
            return this;
        }

        public Builder removeForbidden() {
            this.removeForbidden = true;
            return this;
        }

        public Builder getForbidden() {
            this.getForbidden = true;
            return this;
        }

        public Builder setForbidden() {
            this.setForbidden = true;
            return this;
        }

        public AllowCheckImpl create() {
            if (setForbidden == null) {
                setForbidden = removeForbidden || addForbidden;
            }
            if (getForbidden == null) {
                getForbidden = containsForbidden;
            }
            return new AllowCheckImpl(sizeForbidden, containsForbidden, iterationForbidden, addForbidden, removeForbidden, getForbidden, setForbidden);
        }
    }
}
