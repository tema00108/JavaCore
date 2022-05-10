package by.incubator.task17.codeAnalysis;

public class Printer {

    public static void printWithDashes(String info, String message) {
        System.out.println(message);
        System.out.println(info);
        printDashes();
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printWithIndent(String message, String indent) {
        System.out.println(indent + message);
    }

    private static void printDashes() {
        System.out.println("------------------------------------------------------");
    }
}
