package ru.convert;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/6/2017.
 */
public class UserConvertTest {
    /**
     * Test convert List to HashMap.
     */
    @Test
    public void whenListThenHashMap() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "firstName", 10, "firstCity"));
        list.add(new User(2, "secondName", 20, "secondCity"));
        HashMap<Integer, User> testData = new HashMap<>();
        testData.put(1, new User(1, "firstName", 10, "firstCity"));
        testData.put(2, new User(2, "secondName", 20, "secondCity"));
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> result = uc.process(list);
        assertThat(testData, is(result));
    }
}
