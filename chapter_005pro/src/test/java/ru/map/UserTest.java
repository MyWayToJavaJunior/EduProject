package ru.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

//import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/24/2017.
 */
public class UserTest {
    /**
     * Test map.
     */
    @Test
    public void whenWithOutOverrideHashAndEqualsThen() {
        User u1 = new User("name", 1, new GregorianCalendar(2000, 1, 1));
        User u2 = new User("name", 1, new GregorianCalendar(2000, 1, 1));
        Map<User, Object> map = new HashMap<>();
        map.put(u1, "hello");
        map.put(u2, "world");
        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());
        System.out.println(map);

       // assertThat(result, is(testData));
    }
}
