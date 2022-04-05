package by.incubator.task9.mixins;

public interface Starveble {
    default void isHungry() {
        System.out.println("not hungry");
    }
}