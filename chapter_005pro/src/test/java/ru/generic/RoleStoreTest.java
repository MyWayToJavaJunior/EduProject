package ru.generic;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 4/18/2017.
 */
public class RoleStoreTest {
    /**
     * Test Role store.
     */
    @Test
    public void whenAddToRoleStoreThenGetResult() {
        Store rs = new RoleStore(3);
        rs.add(new Role("first"));
        rs.add(new Role("second"));
        Role testData = new Role("first");
        Role result = (Role) rs.get(0);

        assertThat(result, is(testData));
    }

    /**
     * Test Role store.
     */
    @Test
    public void whenDeleteFromRoleStoreThenGetResult() {
        Store us = new RoleStore(3);
        us.add(new Role("first"));
        us.add(new Role("second"));
        us.delete(new Role("first"));
        Role testData = new Role("second");
        Role result = (Role) us.get(0);
        assertThat(result, is(testData));
    }

    /**
     * Test Role store.
     */
    @Test
    public void whenUpdateToRoleStoreThenGetResult() {
        Store us = new RoleStore(3);

        us.add(new Role("first"));
        us.add(new Role("second"));

        us.update(0, new Role("updated"));
        Role testData = new Role("updated");
        Role result = (Role) us.get(0);

        assertThat(result, is(testData));
    }
}
