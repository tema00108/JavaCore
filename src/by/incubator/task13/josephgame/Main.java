package by.incubator.task13.josephgame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String survivor;
        int amount = readConsole();

        List<String> linkedList = initList(new LinkedList<>(), amount);
        List<String> list = initList(new ArrayList<>(), amount);

        survivor = killWarriors(list, 2);
        System.out.println(survivor);

        survivor = killWarriors(linkedList, 2);
        System.out.println(survivor);
    }

    public static List<String> initList(List<String> list, int amount) {
        for (int i = 1; i <= amount; i++) {
            list.add(Integer.toString(i));
        }

        return list;
    }

    public static int readConsole() {
        int input;
        Scanner in = new Scanner(System.in);

        System.out.println("Input amount of warriors: ");
        input = Integer.parseInt(in.nextLine());
        checkInput(input);

        return input;
    }

    private static void checkInput(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("input: " + input);
        }
    }

    public static String killWarriors(List<String> list, int coef) {
        int nextToKill = coef - 1;

        while (list.size() != 1) {
            list.remove(nextToKill);
            nextToKill = calculateNext(nextToKill, list.size(), coef - 1);
        }
        return list.get(0);
    }

    public static int calculateNext(int previous, int size, int difference) {
        int next = previous + difference;

        while (next >= size) {
            next -= size;
        }

        return next;
    }
}
