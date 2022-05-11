package by.incubator.task18.objectFactory;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Apple apple = ObjectFactory.create(Apple.class);

        Initializer.initialize(apple, "color", "red");
        Initializer.initialize(apple, "weight", 300);

        System.out.println("After Initializer:");
        System.out.println(apple);

        BadInitializer.initialize(apple, "color", "green");
        BadInitializer.initialize(apple, "weight", 400);

        System.out.println("After BadInitializer:");
        System.out.println(apple);
    }
}
