package ru.testcollections;

import java.util.Date;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by nik on 3/13/2017.
 */
public class TestCollections {

    /**
     * Add record to collection.
     * @param collection - collection.
     * @param amount - number of records.
     * @return - speed.
     */
    public long add(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(Integer.toString(i));
        }

        return System.currentTimeMillis() - start;
    }

    /**
     * Delete record from collection.
     * @param collection - collection.
     * @param amount - number of records.
     * @return - speed.
     */
    public long delete(Collection<String> collection, int amount) {
        Date start = new Date();

        Iterator<String> iter = collection.iterator();
        int cout = 0;
        while (iter.hasNext()) {
            iter.next();
            iter.remove();

            cout++;
            if (cout == amount) {
                break;
            }
        }
        Date finish = new Date();
        long resultTime = finish.getTime() - start.getTime();

        return resultTime;
    }
}