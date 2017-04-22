package ru.set;

import ru.list.LinkList;
import java.util.Iterator;

/**
 * Created by nik on 4/22/2017.
 * @param <T> - type of objects.
 */
public class SimpleSetWithLinkedList<T> implements ISimpleSet<T> {
    /**
     * list for objects.
     */
    private LinkList<T> list = new LinkList<>();
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
    private boolean checkDubl(T value) {
        for (int i = 0; i < count; i++) {
            if (this.list.get(i).equals(value)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(T value) {
        boolean dubl = checkDubl(value);
        if (dubl) {
            this.list.add(value);
            count++;
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
