package edu.grinnell.csc207.generics;

import java.util.Arrays;

/**
 * An array-based implementation of a list, specialized to ints.
 */
public class ArrayList<T> implements List<T> {

    private static final int INITIAL_SIZE = 8;
    private T[] data;
    private int sz;

    /**
     * Constructs a new, empty array list.
     */
    public ArrayList() {
        this.data = (T[]) new Object[INITIAL_SIZE];
        this.sz = 0;
    }

    private void ensureCapacity() {
        if (sz == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    /**
     * Adds <code>value</code> to the end of the list.
     *
     * @param value the value to add to the end of the list
     */
    public void add(T value) {
        ensureCapacity();
        data[sz++] = value;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return sz;
    }

    /**
     * Returns the value at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the value at the specified <code>index</code>
     */
    public T get(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        }
        return data[index];
    }

    /**
     * Removes the value at <code>index</code> from the list.
     *
     * @param index the index of the element to remove
     * @return the element at <code>index</code>
     */
    public T remove(int index) {
        if (index < 0 || index >= sz) {
            throw new IndexOutOfBoundsException(index);
        } else {
            T ret = data[index];
            for (int i = index; i < data.length - 1; i++) {
                data[i] = data[i + 1];
            }
            sz -= 1;
            return ret;
        }
    }

    /**
     * Inserts sep in between each element of the list.
     *
     * @param sep the separator to intersperse
     */
    public void intersperse(T sep) {
        for (int i = 0; i < sz; i += 2) {
            ensureCapacity();
            for (int j = sz; j > i; j--) {
                data[j] = data[j - 1];
            }
            data[i] = sep;
            sz++;
        }
    }

    /**
     * Cannot be implemented for a generic list because T can be any type, so we
     * cannot have a maximum value chosen.
     *
     * @return never returns
     * @throws UnsupportedOperationException always, because the comparison of the
     *     arbitrary types is not supported.
     */
    public T maximum() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    public String toString() {
        String result = "[";
        for (int i = 0; i < sz; i++) {
            result += data[i];
            if (i < sz - 1) {
                result += ", ";
            }
        }
        return result + "]";
    }

    /**
     * Cannot be implemented for a generic list because T can be any type, so we
     * cannot have a default ordering.
     *
     * @throws UnsupportedOperationException always, because comparison of
     *     generic types is not possible.
     */
    public void insertionSort() {
        throw new UnsupportedOperationException();
    }
}