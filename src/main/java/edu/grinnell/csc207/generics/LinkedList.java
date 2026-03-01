package edu.grinnell.csc207.generics;

/**
 * A linked-list implementation of a list.
 *
 * @param <T> the type of elements in the list
 */
public class LinkedList<T> implements List<T> {

    private static class Node<T> {
        public T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> first;

    /**
     * Constructs a new, empty linked list.
     */
    public LinkedList() {
        first = null;
    }

    /**
     * Adds <code>value</code> to the end of the list.
     *
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (first == null) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        int sz = 0;
        Node<T> cur = first;
        while (cur != null) {
            sz += 1;
            cur = cur.next;
        }
        return sz;
    }

    /**
     * Returns the value at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        int origIndex = index;
        Node<T> cur = first;
        while (index > 0 && cur != null) {
            index -= 1;
            cur = cur.next;
        }
        if (cur == null) {
            throw new IndexOutOfBoundsException(origIndex);
        } else {
            return cur.value;
        }
    }

    /**
     * Removes the value at <code>index</code> from the list.
     *
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || (index == 0 && first == null)) {
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            T ret = first.value;
            first = first.next;
            return ret;
        } else {
            int origIndex = index;
            Node<T> cur = first;
            while (index > 1 && cur.next != null) {
                index -= 1;
                cur = cur.next;
            }
            if (cur.next == null) {
                throw new IndexOutOfBoundsException(origIndex);
            } else {
                T ret = cur.next.value;
                cur.next = cur.next.next;
                return ret;
            }
        }
    }
}