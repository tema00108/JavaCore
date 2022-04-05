package by.incubator.exceptions;

public class OutOfMemoryInfiniteCycle {
    static Object[] objs = new Object[100000000];
    public static void main(String[] args) {
        int i = 0;

        while (true) {

            Object o = new Object();
            System.out.println(i++);

            objs[i] = o;
            if (i % 2 == 0) {
                objs[i] = new Object();
            }
        }
    }
}

