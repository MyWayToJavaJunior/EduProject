package ru.mergearrays;

import java.util.List;

/**
 * Created by nik on 6/10/2017.
 */
public class Merge {
    /**
     * Sorted list for add.
     */
    private List<Integer> list;
    /**
     * Constructor.
     * @param list - list for add.
     */
    public Merge(List<Integer> list) {
        this.list = list;
    }
    /**
     * Search index to add.
     * @param elem - element to add.
     * @return - index for add.
     */
    private int searchIndex(int elem) {
        int begin = 0;
        int end = list.size() - 1;
        int middle;

        if (list.get(begin) > elem) {
            return begin;
        } else if (list.get(end) < elem) {
            return end + 1;
        }

        while (true) {
            middle = (begin + end) / 2;

            if (list.get(middle) == elem) {
                return middle;

            } else if (list.get(middle) > elem && list.get(middle - 1) < elem) {
                return middle;
            } else {
                if (list.get(middle) < elem && list.get(middle - 1) < elem) {
                    begin = middle + 1;
                } else if (list.get(middle) > elem && list.get(middle - 1) > elem) {
                    end = middle - 1;
                }
            }
        }
    }
    /**
     * Merge 2 lists.
     * @param unsortedList - list with elements for add.
     */
    public void merge(List<Integer> unsortedList) {
        for (Integer i : unsortedList) {
            int index = searchIndex(i);
            this.list.add(index, i);
        }
    }
    /**
     * Get result list.
     * @return - result list.
     */
    public List<Integer> getResult() {
        return list;
    }
}
