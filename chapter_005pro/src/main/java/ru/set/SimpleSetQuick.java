package ru.set;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by nik on 4/22/2017.
 * @param <T> - type of objects.
 */
public class SimpleSetQuick<T> implements ISimpleSet<T> {

    /**
     * list for objects.
     */
    private LinkedList<T> list = new LinkedList<>();
    /**
     * count of objects in list.
     */
    private int count = 0;

    /**
     * Getter for count.
     * @return - count.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Check dublicate.
     * @param value - value to check.
     * @return - boolean check result.
     */
    private int checkPosition(T value) {
        for (int i = 0; i < count; i++) {
            if (value.hashCode() == this.list.get(i).hashCode()) {
                return -1;
            }

            if (value.hashCode() < this.list.get(i).hashCode()) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public void add(T value) {

        if (count == 0) {
            this.list.add(value);
            count++;
        } else {
            int index = checkPosition(value);
            if (index != -1) {
                this.list.add(index, value);
                count++;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;
            @Override
            public boolean hasNext() {
                return this.position < count;
            }

            @Override
            public T next() {
                return list.get(position++);
            }
        };
    }
}
