package by.incubator.task15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        initList(strings);

        applyFilter(strings, (o) -> {
            o.clear();
            return true;
        });

        initList(strings);
        testPredicate(strings, o -> {
            o.clear();
            return true;
        });
    }

    private static void fill(Integer[] ints, Function<Integer, Integer> function) {

    }

    private static void applyFilter( List<String> strings, Filter<List> filter) {
        filter.apply(strings);
        print(strings);
    }

    private static void testPredicate(List<String> strings, Predicate<List> predicate) {
        predicate.test(strings);
        print(strings);
    }

    private static void initList(List<String> list) {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
    }

    private static void print(List<String> list) {
        System.out.println(list);
    }
}
