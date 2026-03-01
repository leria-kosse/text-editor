package edu.grinnell.csc207.generics;

/**
 * A generic list interface.
 *
 * @param <T> the type of elements in the list
 */
public interface List<T> {

    /**
     * Adds a value to the end of the list.
     *
     * @param value the value to add
     */
    void add(T value);

    /**
     * Returns the value at the specified index.
     *
     * @param index the index of the element to retrieve
     * @return the value at the specified index
     */
    T get(int index);

    /**
     * Removes the value at the specified index.
     *
     * @param index the index of the element to remove
     * @return the element that was removed
     */
    T remove(int index);

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    int size();
}