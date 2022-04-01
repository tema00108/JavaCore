package by.incubator.exceptions;

public class OutOfMemoryArray {
    public static void main(String[] args) {
        long[] array = new long[Integer.MAX_VALUE];
    }
}
