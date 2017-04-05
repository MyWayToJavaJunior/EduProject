package ru.convert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nik on 4/5/2017.
 */
public class Convert {
    /**
     * Convert Array to ArrayList.
     * @param array - array to convert.
     * @return new ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        int n = array.length;
        int m = array[n - 1].length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.add(array[i][j]);
            }
        }
        return result;
    }

    /**
     * Convert ArrayList to Array.
     * @param list - arrayList to convert.
     * @param rows - num of rows of new array.
     * @return new Array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] result;
        int cols;
        if (list.size() % rows == 0) {
            cols = list.size() / rows;
        } else {
            cols = (list.size() / rows) + 1;
        }
        result = new int[rows][cols];
        Iterator<Integer> iter = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (iter.hasNext()) {
                    result[i][j] = iter.next();
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }
}
