package io.github.navpil.esoteric.collections;

public interface AllowCheck {
     void checkSizeAllowed();

     void checkContainsAllowed();

     void checkIterationAllowed();

     void checkAddAllowed();
     default void checkSetAllowed() {
          //For lists only
          checkAddAllowed();
          checkRemoveAllowed();
     }
     default void checkGetAllowed() {
          //For lists only
          checkContainsAllowed();
     }

     void checkRemoveAllowed();
}
