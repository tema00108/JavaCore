package by.incubator.task9.mixins;

public interface Movable {
    default void move() {
        System.out.println("movement");
    }
}
