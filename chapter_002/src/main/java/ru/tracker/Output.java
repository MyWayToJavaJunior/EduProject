package ru.tracker;

/**
 * Created by nik on 3/16/2017.
 */
public interface Output {
    /**
     * print array of  items.
     * @param mas - array of item.
     */
    void print(Item[] mas);
    /**
     * print 1 item.
     * @param item - item.
     */
    void print(Item item);
}
