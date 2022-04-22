package by.incubator.task13.josephgame;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<T> extends AbstractList<T> implements List<T>  {

    private final int DEFAULT_SIZE = 10;
    private Object[] list;
    private int size;

    public MyArrayList() {
        list = new Object[DEFAULT_SIZE];
        size = 0;
    }

    public MyArrayList(int size) {
        list = new Object[size];
        this.size = 0;
    }

    public MyArrayList(T[] array) {
        list = Arrays.copyOf(array, array.length);
        size = array.length;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index: " + index);
        }

        return (T) list[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T obj) {
        list = ensureCapacity(list);
        list[size++] = obj;

        return true;
    }

    @Override
    public T remove(int index) {
        T element = get(index);

        deleteElement(index);
        size--;

        return element;
    }

    private void deleteElement(int index) {
        System.arraycopy(list, index + 1, list, index, list.length - 1 - index);
    }

    private Object[] ensureCapacity(Object[] list) {
        if (size == list.length) {
            Object[] newList = new Object[list.length * 3/2];
            System.arraycopy(list, 0, newList, 0, list.length);

            return newList;
        }

        return list;
    }
}
