package by.incubator.task14.hashs;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<E> extends AbstractSet<E> implements Set<E> {
    private final static Object PRESENT = new Object();
    private MyHashMap<E, Object> map = new MyHashMap<>();

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) != PRESENT;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public boolean contains(Object o) {
        return map.get(o) == PRESENT;
    }
}
