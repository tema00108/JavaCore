package by.incubator.exceptions;

public class StackOverFlowByObj {
    StackOverFlowByObj goodbye = new StackOverFlowByObj();

    static class Main {
        public static void main(String[] args) {
            StackOverFlowByObj obj = new StackOverFlowByObj();
        }
    }
}
