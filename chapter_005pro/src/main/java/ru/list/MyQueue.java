package ru.list;

/**
 * Created by nik on 4/21/2017.
 * @param <T> - type of items.
 */
public class MyQueue<T> {
    /**
     * Container of items.
     */
    private LinkList<T> container = new LinkList<T>();
    /**
     * index of current item.
     */
    private int tail = 0;
    /**
     * add item to list.
     * @param value - item.
     */
    public void add(T value) {
        container.add(value);
        tail++;
    }
    /**
     * poll item from list.
     * @return - item.
     */
    public T poll() {
        T result = null;
        if (this.tail > 0) {
            result = container.get(0);
            container.remove(0);
        }
        return result;
    }
}
