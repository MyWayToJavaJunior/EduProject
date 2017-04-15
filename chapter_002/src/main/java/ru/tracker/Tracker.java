package ru.tracker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by nik on 3/13/2017.
 */
public class Tracker {
    /**
     * Array of Items.
     */
    private ArrayList<Item> items = new ArrayList<>();
    /**
     * random object.
     */
    private static final Random RN = new Random();

    /**
     * Add item to array.
     * @param item - item to add.
     * @return added to array item.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Update item.
     * @param item - item to update.
     */
    public void update(Item item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(item.getId())) {
                this.items.set(i, item);
                break;
            }
        }
    }

    /**
     * Delete item from array.
     * @param item - item to delete.
     */
    void delete(Item item) {
        int count = 0;
        for (Item it : this.items) {
            if (it.getId().equals(item.getId())) {
                break;
            }
            count++;
        }
        this.items.remove(count);
    }

    /**
     * Find all items in array.
     * @return array of all items.
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        for (int i = 0; i != this.items.size(); i++) {
            result.add(this.items.get(i));
        }
        return result;
    }

    /**
     * Find all items in array by name.
     * @param key - key for search.
     * @return all items equals by name.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Find all items in array by id.
     * @param id - id for search.
     * @return item equals by id.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Generate id.
     * @return new id String.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
