package ru.convert;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/6/2017.
 */
public class SortUserTest {
    /**
     * Test sort users.
     */
    @Test
    public void whenListThenSortedSet() {
        SortUser sort = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User(1, "qqqq", 10, "qqqq"));
        list.add(new User(2, "wwww", 30, "wwww"));
        list.add(new User(3, "eeee", 20, "eeee"));
        list.add(new User(4, "rrrr", 40, "rrrr"));
        Set<User> result = sort.sort(list);

        TreeSet<User> testData = new TreeSet<>();
        testData.add(new User(1, "qqqq", 10, "qqqq"));
        testData.add(new User(2, "wwww", 30, "wwww"));
        testData.add(new User(3, "eeee", 20, "eeee"));
        testData.add(new User(4, "rrrr", 40, "rrrr"));
        assertThat(testData, is(result));
    }

    /**
     * Test sort by HashCode users.
     */
    @Test
    public void whenListThenSortedByHash() {
        SortUser sort = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User(1, "qqqq", 10, "qqqq"));
        list.add(new User(3, "wwww", 30, "wwww"));
        list.add(new User(2, "eeee", 20, "eeee"));
        list.add(new User(4, "rrrr", 40, "rrrr"));
        List<User> result = sort.sortHash(list);

        List<User> testData = new ArrayList<>();
        testData.add(new User(1, "qqqq", 10, "qqqq"));
        testData.add(new User(2, "eeee", 20, "eeee"));
        testData.add(new User(3, "wwww", 30, "wwww"));
        testData.add(new User(4, "rrrr", 40, "rrrr"));

        assertThat(testData, is(result));
    }

    /**
     * Test sort by name users.
     */
    @Test
    public void whenListThenSortedByLenght() {
        SortUser sort = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User(4, "rrrr", 40, "rrrr"));
        list.add(new User(1, "q", 10, "qqqq"));
        list.add(new User(3, "www", 30, "wwww"));
        list.add(new User(2, "ee", 20, "eeee"));
        List<User> result = sort.sortLength(list);

        List<User> testData = new ArrayList<>();
        testData.add(new User(1, "q", 10, "qqqq"));
        testData.add(new User(2, "ee", 20, "eeee"));
        testData.add(new User(3, "www", 30, "wwww"));
        testData.add(new User(4, "rrrr", 40, "rrrr"));

        assertThat(testData, is(result));
    }
}
