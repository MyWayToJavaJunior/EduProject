package ru.tracker;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by nik on 3/13/2017.
 */
public class TrackerTest {
    /**
     * Test add Item to array.
     */
    @Test
    public void whenAddItemThenArrayIsNotEmpty() {
        Item result = new Item("first name2", "first desc", "1");
        Tracker t = new Tracker();
        t.add(result);
        ArrayList<Item> mas = null;
        mas = t.findByName("first name2");
        assertTrue(mas.contains(result));
    }

    /**
     * Test update Item.
     */
    @Test
    public void whenItemUpdateThenItemUpdated() {
        Item result = new Item("first name", "first desc", "1");
        Tracker t = new Tracker();
        Item i = t.add(result);
        Item upd = new Item("second name", "second desc", "2");
        upd.setId(i.getId());
        t.update(upd);
        Item item = t.findById(i.getId());
        assertThat(item, is(upd));
    }

    /**
     * Test Find by name Item.
     */
    @Test
    public void whenItemFindedByNameThenArray() {
        Item i1 = new Item("first name", "first desc", "1");
        Item i2 = new Item("second name", "second desc", "2");
        Item i3 = new Item("second name", "third desc", "3");
        Tracker t = new Tracker();
        t.add(i1);
        t.add(i2);
        t.add(i3);
        ArrayList<Item> mas = t.findByName("second name");
        assertTrue(mas.contains(i2));
        assertTrue(mas.contains(i3));
    }

    /**
     * Test Find by id Item.
     */
    @Test
    public void whenItemFindedByIdThenArray() {
        Item i1 = new Item("first name", "first desc", "1");
        Item i2 = new Item("second name", "second desc", "2");
        Item i3 = new Item("third name", "third desc", "3");
        Tracker t = new Tracker();
        t.add(i1);
        t.add(i2);
        t.add(i3);
        String id = i2.getId();
        Item item = t.findById(id);
        assertThat(item, is(i2));
    }
}
