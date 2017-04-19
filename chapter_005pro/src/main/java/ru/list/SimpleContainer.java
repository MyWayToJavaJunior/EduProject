package ru.list;

/**
 * Created by nik on 4/19/2017.
 */
public interface SimpleContainer<T> extends Iterable<T> {
    void add(T value);
    T get(int index);
}
