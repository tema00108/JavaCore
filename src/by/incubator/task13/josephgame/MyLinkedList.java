package by.incubator.task13.josephgame;

import java.util.AbstractList;
import java.util.List;

public class MyLinkedList<T> extends AbstractList<T> implements List<T> {
    private final Node<T> node = new Node<>();
    private int size;

    public MyLinkedList() { }

    @Override
    public T get(int index) {
        checkIndex(index);
        return node.getElement(index, size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T obj) {
        node.addLast(obj);
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        return node.removeElement(index, size--);
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index: " + index);
        }

        return true;
    }

    private static class Node<E> {
        private static Node header = new Node();
        private Node<E> next;
        private Node<E> prev;
        private E element;

        static {
            header.next = header;
            header.prev = header;
            header.element = null;
        }

        public Node() { }

        public Node(Node<E> next, Node<E> prev, E element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }

        Node<E> getNode(int index, int size) {
            if (index <= size / 2) {
                return getFromBeginning(index);
            }

            return getFromEnd(index, size);
        }

        E getElement(int index, int size) {
            return getNode(index, size).element;
        }

        void addLast(E obj) {
            Node<E> last = new Node<E>(header, header.prev, obj);
            header.prev.next = last;
            header.prev = last;
        }

        private Node<E> getFromBeginning(int index) {
            Node<E> curr = header;
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }

            return curr;
        }

        private Node<E> getFromEnd(int index, int size) {
            Node<E> curr = header;
            for (int i = size - 1; i >= index; i--) {
                curr = curr.prev;
            }

            return curr;
        }

        public E removeElement(int index, int size) {
            Node<E> curr = getNode(index, size);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;

            return curr.element;
        }
    }
}
