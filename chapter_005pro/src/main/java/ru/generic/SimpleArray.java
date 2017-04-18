package ru.generic;

/**
 * Created by nik on 4/18/2017.
 * @param <T> - type of array.
 */
public class SimpleArray<T> {

    /**
     * Array of objects.
     */
    private Object[] objects;
    /**
     * Current position in array.
     */
    private int position = 0;
    /**
     * Construnctor.
     * @param length - lenth of array.
     */
    public SimpleArray(int length) {
        objects = new Object[length];
    }
    /**
     * Add item to array.
     * @param value - value to add.
     */
    public void add(T value) {
        objects[position] = value;
        position++;
    }
    /**
     * Update item in array.
     * @param position - position of item to update.
     * @param value - value to update.
     */
    public void update(int position, T value) {
        if (position < this.position && position >= 0) {
            objects[position] = value;
        }
    }
    /**
     * Delete item from array.
     * @param value - value to delete.
     */
    public void delete(T value) {
        for (int i = 0; i < this.position; i++) {
            if (objects[i].equals(value)) {
                System.arraycopy(objects, i + 1, objects, i, objects.length - (i + 1));
                position--;
            }
        }
    }
    /**
     * Get item from array.
     * @param index - index of item.
     * @return - item.
     */
    public T get(int index) {
        return (T) objects[index];
    }
}
