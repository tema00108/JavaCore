package by.incubator.task14.hashs;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V> implements Map<K, V> {
    private final int DEFAULT_SIZE = 16;
    private int tableSize;
    private int size;
    private Object[] table;

    public MyHashMap() {
        table = new Object[DEFAULT_SIZE];
        tableSize = DEFAULT_SIZE;
    }

    public MyHashMap(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size: " + size);
        }

        table = new Object[size];
        tableSize = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        Node<K,V> node;
        return (node = getNode(hash(key), key)) == null ? null : node.value;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        Node<K,V> node;
        return (node = getNode(hash(key), key)) == null ? defaultValue : node.value;
    }

    @Override
    public V put(K key, V value) {
        int hash = key.hashCode();
        int index = hash % tableSize;

         if (table[index] == null) {
             table[index] = new Node<>(key, value, hash);
             size++;
             return null;
         }

        return putInNode(key, value, hash, (Node<K,V>) table[index]);
    }

    private V putInNode(K key, V value, int hash, Node<K, V> elem) {
        while (elem != null) {
            if (checkKey(elem, hash, key)) {
                return elem.setValue(value);
            }

            elem = elem.next;
        }

        elem = new Node<>(key, value, hash);
        size++;

        return null;
    }

    @Override
    public V remove(Object key) {
        return removeNode(hash(key), key);
    }

    @Override
    public void putAll(Map m) { }

    @Override
    public void clear() {
        size = 0;
        table = new Object[DEFAULT_SIZE];
    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private boolean checkKey(Node<K,V> elem, int hash, Object key) {
        return hash == elem.hash && key.equals(elem.key);
    }

    private int hash(Object key) {
        return (key == null) ? 0 : key.hashCode();
    }

    private Node<K,V> getNode(int hash, Object key) {
        for (Object elem : table) {
            Node<K,V> node = (Node<K,V>) elem;
            while (node != null) {
                if (checkKey(node, hash, key)) {
                    return node;
                }

                node = node.next;
            }
        }

        return null;
    }

    private V removeNode(int hash, Object key) {

        for (int i = 0; i < tableSize; i++) {
            Node<K,V> node = (Node<K,V>) table[i];

            if (node == null) {
                continue;
            }

            if (checkKey(node, hash, key)) {
                V value = node.getValue();
                table[i] = node.next;

                return value;
            }

            while (node.next != null) {
                if (checkKey(node.next, hash, key)) {
                    V value = node.next.getValue();
                    node.next = node.next.next;

                    return value;
                }

                node = node.next;
            }
        }

        return null;
    }

    public static class Node<K, V> implements Map.Entry<K, V> {
        final K key;
        final int hash;
        V value;
        Node<K, V> next;

        public Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }
}
