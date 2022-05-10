package by.incubator.task15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"fg", "sdf"};

        applyFilter(strings, string -> {
            string = null;
            return true;
        });

        testPredicate(strings, string -> {
            string = null;
            return true;
        });
    }

    private static <T> void fill(){}

    private static <T> void filter(T elem, Filter<T> filter) {
        filter.apply(elem);
    }

    private static <T> void test(T elem, Predicate<T> predicate) {
        predicate.test(elem);
    }

    private static void applyFilter( String[] strings, Filter<String> filter) {
        for (int i = 0; i < strings.length; i++) {
            filter(strings[i], filter);
        }
    }

    private static void testPredicate(String[] strings, Predicate<String> predicate) {
        for (int i = 0; i < strings.length; i++) {
            test(strings[i], predicate);
        }
    }
}
