package by.incubator.task17.codeAnalysis;

public class Printer {

    public static final String[] TABS = {"", "\t", "\t\t", "\t\t\t"};

    public static void print(String message) {
        System.out.println(message);
    }

    public static void print(String message, int numOfTabs) {
        checkNumOfTabs(numOfTabs);
        System.out.println(TABS[numOfTabs] + message);
    }

    public static void print(String message, String info, boolean withDashes) {
        System.out.println(message);
        System.out.println(info);

        if (withDashes) {
            printDashes();
        }
    }

    public static void printDashes() {
        System.out.println("------------------------------------------------------");
    }

    private static void checkNumOfTabs(int numOfTabs) {
        if (numOfTabs < 0 || numOfTabs > 3) {
            throw new IllegalArgumentException("number of tabs: " + numOfTabs + " (but must be [0..3])");
        }
    }


}
