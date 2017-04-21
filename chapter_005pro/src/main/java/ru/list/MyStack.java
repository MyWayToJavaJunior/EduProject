package ru.list;

/**
 * Created by nik on 4/21/2017.
 * @param <T> - type of items.
 */
public class MyStack<T> {
    /**
     * Container of items.
     */
    private LinkList<T> container = new LinkList<T>();
    /**
     * index of current item.
     */
    private int index = 0;
    /**
     * Push item to list.
     * @param value - item.
     */
    public void push(T value) {
        container.add(value);
        index++;
    }
    /**
     * Pop item from list.
     * @return - item.
     */
    public T pop() {
        T result = null;
        if (index > 0) {
            result = container.get(--index);
            container.remove(index);
        }
            return result;
    }
}
