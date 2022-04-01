package by.incubator.exceptions;

public class StackOverFlowRecursive {
    public static void main(String[] args) {
        overflowStack();
    }

    public static void overflowStack() {
        overflowStack();
    }
}
