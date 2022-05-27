package by.incubator.task20.multithreadingSingleton;

import java.util.Objects;

public class SingletonClass2 {
    private static final SingletonClass2 INSTANCE = new SingletonClass2();

    private final int num1;
    private final int num2;
    private final int num3;

    private SingletonClass2() {
        num1 = 1;
        num2 = 2;
        num3 = 3;
    }

    public static SingletonClass2 instance() {
        return INSTANCE;
    }

    public String toString() {
        return "num1: " + num1 +
                "\nnum2: " + num2 +
                "\nnum3: " + num3 +
                "\nhash: " + Objects.hash(this);
    }
}
