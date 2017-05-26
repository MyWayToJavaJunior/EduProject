package ru.synchronize;

/**
 * Created by nik on 4/19/2017.
 * @param <T> - type of object.
 */
public interface SimpleContainer<T> extends Iterable<T> {
    /**
     * Add item to list.
     * @param value - item to add..
     */
    void add(T value);
    /**
     * get item from list.
     * @param index - index of item to get.
     * @return - item.
     */
    T get(int index);
}
