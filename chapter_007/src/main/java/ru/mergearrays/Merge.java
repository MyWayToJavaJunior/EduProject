package ru.mergearrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nik on 6/10/2017.
 */
public class Merge {
    /**
     * Merge 2 lists.
     * @param mas1 first list.
     * @param mas2 second list.
     * @return merge list.
     */
    public List<Integer> merge(List<Integer> mas1, List<Integer> mas2) {
        List<Integer> result = new ArrayList<>();
        int j = 0;
        int k = 0;
        int size = mas1.size() + mas2.size();
        Collections.sort(mas1);
        Collections.sort(mas2);
        for (int i = 0; i < size; i++) {

            if (j == mas1.size()) {
                result.add(mas2.get(k));
                k++;
                continue;
            }
            if (k == mas2.size()) {
                result.add(mas1.get(j));
                j++;
                continue;
            }

            if (mas1.get(j) < mas2.get(k)) {
                result.add(mas1.get(j));
                j++;
            } else if (mas1.get(j) >= mas2.get(k)) {
                result.add(mas2.get(k));
                k++;
            }
        }
        return result;
    }
}
