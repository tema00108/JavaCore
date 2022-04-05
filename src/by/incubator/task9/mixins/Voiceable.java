package by.incubator.task9.mixins;

public interface Voiceable {
    default void voice() {
        System.out.println("voice");
    }
}