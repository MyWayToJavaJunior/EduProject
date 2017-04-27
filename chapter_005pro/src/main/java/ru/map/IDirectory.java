package ru.map;

/**
 * Created by nik on 4/26/2017.
 * @param <T> - type of key.
 * @param <V> - type of value.
 */
public interface IDirectory<T, V> extends Iterable {
    /**
     * Insert item to directory.
     * @param key - key.
     * @param value - value.
     * @return - is success.
     */
    boolean insert(T key, V value);
    /**
     * Get item from directory.
     * @param key - key.
     * @return - value.
     */
    V get(T key);
    /**
     * Delete item from directory.
     * @param key - key.
     * @return - is success.
     */
    boolean delete(T key);
}
