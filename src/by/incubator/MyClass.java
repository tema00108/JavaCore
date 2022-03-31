package by.incubator;

public class MyClass {
}

class SecondClass {
    public static void main(String[] args) {
        Class<MyClass> myClass = MyClass.class;

        MyClass obj = new MyClass();
        Class<?> myClass1 = obj.getClass();

        System.out.println(myClass.getClassLoader());
        System.out.println(myClass.getClassLoader().getParent());
        System.out.println(myClass.getClassLoader().getParent().getParent());

        System.out.println();
        System.out.println(String.class.getClassLoader());

        Class<SecondClass> secondClass = SecondClass.class;

        System.out.println();
        System.out.println(secondClass.getClassLoader());
        System.out.println(secondClass.getClassLoader().getParent());
        System.out.println(secondClass.getClassLoader().getParent().getParent());

    }
}

