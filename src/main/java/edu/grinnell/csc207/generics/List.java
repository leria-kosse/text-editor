package edu.grinnell.csc207.generics;

public interface List<T> {
    void add(T value);
    T get(int index);
    T remove(int index);
    int size();
}