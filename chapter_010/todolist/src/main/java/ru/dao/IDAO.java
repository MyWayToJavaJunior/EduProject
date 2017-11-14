package ru.dao;

import java.util.List;

/**
 * Created by nikolay on 08/11/17.
 */
public interface IDAO<T> {
    /**
     * Get all items.
     * @return - list of items.
     */
    List<T> getAll();
    /**
     * Get active items.
     * @return - list of items.
     */
    List<T> getActive();
    /**
     * Get item by id.
     * @param id - id.
     * @return - item.
     */
    T getById(int id);
    /**
     * add item.
     * @param item - item.
     */
    void add(T item);
    /**
     * update item.
     * @param item - item.
     */
    void update(T item);
}
