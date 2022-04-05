package by.incubator.mixins;

public interface Movable {
    default void move() {
        System.out.println("movement");
    }
}
