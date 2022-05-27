package by.incubator.task20.multithreadingSingleton;

import java.util.Objects;

public class SingletonClass3 {
    private final int num1;
    private final int num2;
    private final int num3;

    private SingletonClass3() {
        num1 = 1;
        num2 = 2;
        num3 = 3;
    }

    public static SingletonClass3 instance() {
        return Holder.INSTANCE;
    }

    public String toString() {
        return "num1: " + num1 +
                "\nnum2: " + num2 +
                "\nnum3: " + num3 +
                "\nhash: " + Objects.hash(Holder.INSTANCE);
    }

    private static class Holder {
        private static final SingletonClass3 INSTANCE = new SingletonClass3();
    }
}
