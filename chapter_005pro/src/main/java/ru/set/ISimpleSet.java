package ru.set;

/**
 * Created by nik on 4/22/2017.
 * @param <T> - type.
 */
public interface ISimpleSet<T> extends Iterable<T> {
    /**
     * Add new item to container.
     * @param value - new value.
     */
    void add(T value);
}
