package by.incubator.task7.exceptions;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryList {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            list.add(new Object());
        }
    }

}
