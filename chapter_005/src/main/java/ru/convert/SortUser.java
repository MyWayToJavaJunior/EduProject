package ru.convert;

import java.util.Set;
import java.util.List;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Collections;

/**
 * Created by nik on 4/6/2017.
 */
public class SortUser {
    /**
     * sort users.
     * @param list - list of users.
     * @return set of sorted users.
     */
    public Set<User> sort(List<User> list) {
        TreeSet<User> result = new TreeSet<>();
        for (User u : list) {
            result.add(u);
        }
        return result;
    }

    /**
     * sort users.
     * @param list - list of users.
     * @return list of sorted by hashcode users.
     */
    public List<User> sortHash(List<User> list) {
        Comparator<User> hashComparator = new Comparator<User>() {
            @Override
            public int compare(User e1, User e2) {
                return (e1.hashCode() - e2.hashCode());
            }
        };
        Collections.sort(list, hashComparator);
        return list;
    }

    /**
     * sort users.
     * @param list - list of users.
     * @return list of sorted by name users.
     */
    public List<User> sortLength(List<User> list) {
        Comparator<User> nameComparator = new Comparator<User>() {
            @Override
            public int compare(User e1, User e2) {
                return (e1.getName().length() - e2.getName().length());
            }
        };
        Collections.sort(list, nameComparator);
        return list;
    }
}
