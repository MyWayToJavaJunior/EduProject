package ru.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/13/2017.
 */
public class TrackerTest {
    /**
     * Test add Item to array.
     */
    @Test
    public void whenAddItemThenArrayIsNotEmpty() {
        Item result = new Item("first name", "first desc", 1);
        Tracker t = new Tracker();
        t.add(result);
        Item[] mas = t.findAll();
        assertThat(mas[0], is(result));
    }

     /**
     * Test get all array.
     */
    @Test
    public void whenArrayIsEmptyThenEmpty() {
        Tracker t = new Tracker();
        Item[] mas = {};
        Item[] result = t.findAll();
        assertThat(result, is(mas));
    }

    /**
     * Test update Item.
     */
    @Test
    public void whenItemUpdateThenItemUpdated() {
        Item result = new Item("first name", "first desc", 1);
        Tracker t = new Tracker();
        Item i = t.add(result);
        Item upd = new Item("second name", "second desc", 2);
        upd.setId(i.getId());
        t.update(upd);
        Item[] mas = t.findAll();
        assertThat(mas[0], is(upd));
    }

    /**
     * Test delete Item.
     */
    @Test
    public void whenItemDeleteThenEmptyArray() {
        Item result = new Item("first name", "first desc", 1);
        Item[] mas1 = {};
        Tracker t = new Tracker();
        t.add(result);
        t.delete(result);
        Item[] mas = t.findAll();
        assertThat(mas, is(mas1));
    }

    /**
     * Test Find by name Item.
     */
    @Test
    public void whenItemFindedByNameThenArray() {
        Item i1 = new Item("first name", "first desc", 1);
        Item i2 = new Item("second name", "second desc", 2);
        Item i3 = new Item("second name", "third desc", 3);
        Tracker t = new Tracker();
        t.add(i1);
        t.add(i2);
        t.add(i3);
        Item[] mas = t.findByName("second name");
        assertThat(mas[0], is(i2));
        assertThat(mas[1], is(i3));
    }

    /**
     * Test Find by id Item.
     */
    @Test
    public void whenItemFindedByIdThenArray() {
        Item i1 = new Item("first name", "first desc", 1);
        Item i2 = new Item("second name", "second desc", 2);
        Item i3 = new Item("third name", "third desc", 3);
        Tracker t = new Tracker();
        t.add(i1);
        t.add(i2);
        t.add(i3);
        String id = i2.getId();
        Item item = t.findById(id);
        assertThat(item, is(i2));
    }
}
