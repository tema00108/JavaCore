package by.incubator.task20.multithreadingSingleton;

import java.util.Objects;

public class SingletonClass {
    private static volatile SingletonClass INSTANCE;
    private final int num1;
    private final int num2;
    private final int num3;

    private SingletonClass() {
        num1 = 1;
        num2 = 2;
        num3 = 3;
    }

    public static SingletonClass instance() {
        if (INSTANCE == null) {
            synchronized (SingletonClass.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonClass();
                }
            }
        }
        return INSTANCE;
    }

    public String toString() {
        return "num1: " + num1 +
             "\nnum2: " + num2 +
             "\nnum3: " + num3 +
             "\nhash: " + Objects.hash(this);
    }
}
