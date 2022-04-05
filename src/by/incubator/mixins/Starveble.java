package by.incubator.mixins;

public interface Starveble {
    default void isHungry() {
        System.out.println("not hungry");
    }
}
