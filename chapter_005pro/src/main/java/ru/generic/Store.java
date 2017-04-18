package ru.generic;

/**
 * Created by nik on 4/18/2017.
 * @param <T> - type of array.
 */
public interface Store<T extends Base> {
    /**
     * Add item to store.
     * @param value - value to add.
     */
    void add(T value);
    /**
     * Delete item from store.
     * @param value - value to delete.
     */
    void delete(T value);
    /**
     * Update item in store.
     * @param pos - position to update.
     * @param value - value to update.
     */
    void update(int pos, T value);
    /**
     * Get item from array.
     * @param i - index to get.
     * @return - item.
     */
    T get(int i);
}
