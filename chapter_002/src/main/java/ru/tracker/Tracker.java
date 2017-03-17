package ru.tracker;

import java.util.Random;

/**
 * Created by nik on 3/13/2017.
 */
public class Tracker {
    /**
     * Array of Items.
     */
    private Item[] items = new Item[10];
    /**
     * current position to add && length of array.
     */
    private int position = 0;
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
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Update item.
     * @param item - item to update.
     */
    public void update(Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
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
        System.arraycopy(this.items, ++count, this.items, --count, this.position - count);
        this.items[this.position] = null;
        this.position--;
    }

    /**
     * Find all items in array.
     * @return array of all items.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    /**
     * Find all items in array by name.
     * @param key - key for search.
     * @return all items equals by name.
     */
    public Item[] findByName(String key) {
        int count = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                count++;
            }
        }
        Item[] result = new Item[count];
        count = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(key)) {
                result[count++] = item;
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
