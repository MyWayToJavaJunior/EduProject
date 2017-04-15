package ru.directory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by nik on 4/9/2017.
 */
public class Directory {
    /**
     * Array to sort.
     */
    private List<String> list;

    /**
     * Constructor.
     * @param list - array.
     */
    public Directory(List<String> list) {
        this.list = list;
        makeFull();
    }

    /**
     * Make array full off records.
     */
    private void makeFull() {
        String tmp;
        int indx;
        for (int i = 0; i < list.size(); i++) {
            indx = list.get(i).lastIndexOf('\\');
            while (indx != -1) {
                tmp = list.get(i).substring(0, indx);
                if (!list.contains(tmp)) {
                    list.add(tmp);
                }
                indx = tmp.lastIndexOf('\\');
            }
        }
    }

    /**
     * List getter.
     * @return - array.
     */
    public List<String> getList() {
        return this.list;
    }

    /**
     * Asc sort.
     */
    public void sortAsc() {
        Comparator<String> sortAscComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int ind1 = s1.indexOf('\\');
                int ind2 = s2.indexOf('\\');
                String tmp1;
                String tmp2;
                if (ind1 == -1) {
                    tmp1 = s1;
                } else {
                    tmp1 = s1.substring(0, ind1);
                }

                if (ind2 == -1) {
                    tmp2 = s2;
                } else {
                    tmp2 = s2.substring(0, ind2);
                }

                if (tmp1.equals(tmp2)) {
                    tmp1 = s1.substring(ind1 + 1);
                    tmp2 = s2.substring(ind2 + 1);
                    compare(tmp1, tmp2);
                }

                return tmp1.compareTo(tmp2);
            }
        };
        Collections.sort(list, sortAscComparator);
    }

    /**
     * Desc sort.
     */
    public void sortDesc() {
        Comparator<String> sortDescComparator = new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                int ind1 = s1.indexOf('\\');
                int ind2 = s2.indexOf('\\');

                String tmp1;
                String tmp2;

                if (ind1 == -1) {
                    tmp1 = s1;
                } else {
                    tmp1 = s1.substring(0, ind1);
                }

                if (ind2 == -1) {
                    tmp2 = s2;
                } else {
                    tmp2 = s2.substring(0, ind2);
                }

                if (tmp1.equals(tmp2) && (ind1 == -1 || ind2 == -1) && (s1.length() < s2.length())) {
                    return -1;
                } else if (!tmp1.equals(tmp2)) {
                    return tmp2.compareTo(tmp1);
                } else if (tmp1.equals(tmp2) && ind1 != -1 && ind2 != -1) {
                    tmp1 = s1.substring(ind1 + 1);
                    tmp2 = s2.substring(ind2 + 1);
                    return compare(tmp1, tmp2);
                }
                return tmp1.compareTo(tmp2);
            }
        };
        Collections.sort(list, sortDescComparator);
    }
}