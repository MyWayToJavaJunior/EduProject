package ru.convert;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nik on 4/6/2017.
 */
public class UserConvert {
    /**
     * Convert from List to Map.
     * @param list - list to convert.
     * @return - hashmap.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        for (User u : list) {
            map.put(u.getId(), u);
        }
        return map;
    }
}
