package ru.generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/18/2017.
 */
public class UserStoreTest {
    /**
     * Test User store.
     */
    @Test
    public void whenAddToUserStoreThenGetResult() {
        Store us = new UserStore(3);
        us.add(new User("first"));
        us.add(new User("second"));
        User testData = new User("first");
        User result = (User) us.get(0);

        assertThat(result, is(testData));
    }

    /**
     * Test User store.
     */
    @Test
    public void whenDeleteFromUserStoreThenGetResult() {
        Store us = new UserStore(3);
        us.add(new User("first"));
        us.add(new User("second"));
        us.delete(new User("first"));
        User testData = new User("second");
        User result = (User) us.get(0);
        assertThat(result, is(testData));
    }

    /**
     * Test User store.
     */
    @Test
    public void whenUpdateToUserStoreThenGetResult() {
        Store us = new UserStore(3);

        us.add(new User("first"));
        us.add(new User("second"));

        us.update(0, new User("updated"));
        User testData = new User("updated");
        User result = (User) us.get(0);

        assertThat(result, is(testData));
    }
}
