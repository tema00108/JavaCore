package by.incubator.mixins;

public interface Voiceable {
    default void voice() {
        System.out.println("voice");
    }
}
