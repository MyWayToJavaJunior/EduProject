package ru.dao;

import ru.models.Item;

import java.util.List;

/**
 * Created by nikolay on 08/11/17.
 */
public interface IDAO {
    /**
     * Get all items.
     * @return - list of items.
     */
    List<Item> getAll();
    /**
     * Get active items.
     * @return - list of items.
     */
    List<Item> getActive();
    /**
     * Get item by id.
     * @param id - id.
     * @return - item.
     */
    Item getById(int id);
    /**
     * add item.
     * @param item - item.
     */
    void add(Item item);
    /**
     * update item.
     * @param item - item.
     */
    void update(Item item);
}
