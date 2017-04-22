package ru.set;

import java.util.Iterator;

/**
 * Created by nik on 4/22/2017.
 * @param <T> - type.
 */
public class SimpleSet<T> implements SimpleSetInt<T> {
    /**
     * Container.
     */
    private Object[] container;

    /**
     * Length of container.
     */
    private int length = 10;

    /**
     * Current position.
     */
    private int count = 0;

    /**
     * Constructor.
     */
    public SimpleSet() {
        container = new Object[this.length];
    }

    /**
     * Constructor.
     * @param length - length of new container.
     */
    public SimpleSet(int length) {
        this.length = length;
        container = new Object[this.length];
    }

    /**
     * Getter for count.
     * @return - count.
     */
    public int getCount() {
        return this.count;
    }

    @Override
    public void add(T value) {
        boolean dubl = checkDubl(value);
        if (this.count < this.length && dubl) {
            this.container[count] = value;
            count++;
        } else if (this.count >= this.length && dubl) {
            makeExpand();
            this.container[count] = value;
            count++;
        }
    }

    /**
     * Make expand if need.
     */
    private void makeExpand() {
        this.length *= 2;
        Object[] tmpArray = new Object[this.length];
        System.arraycopy(this.container, 0, tmpArray, 0, container.length);
        container = tmpArray;
        tmpArray = null;
    }

    /**
     * Check dublicate.
     * @param value - value to check.
     * @return - boolean check result.
     */
    private boolean checkDubl(T value) {
        for (int i = 0; i < count; i++) {
            if (this.container[i].equals(value)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return this.position < length;
            }

            @Override
            public T next() {
                return  (T) container[this.position++];
            }
        };
    }
}
