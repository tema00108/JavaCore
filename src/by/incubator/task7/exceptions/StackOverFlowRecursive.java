package by.incubator.task7.exceptions;

public class StackOverFlowRecursive {
    static int i = 0;
    public static void main(String[] args) {

        try {
            overflowStack1();
        } catch(StackOverflowError ignore) {}
        System.out.println(i);

        i = 0;

        try {
            overflowStack1();
        } catch(StackOverflowError ignore) {}
        System.out.println(i);

    }

    public static void overflowStack1() {
        i++;
        double d = 0.0d;
        overflowStack1();
    }

    public static void overflowStack2() {
        i++;
        overflowStack2();
    }
}
