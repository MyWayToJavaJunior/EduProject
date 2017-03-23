package ru.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by nik on 3/16/2017.
 */
public class StartUITest {
    /**
     * Test add item.
     */
    @Test
    public void whenAddItemThenAdd() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"1", "name", "desc", "0"});
        new StartUI(input, tracker).init();
        Item[] items = tracker.findAll();
        assertThat(items[0].getName(), is("name"));
    }
    /**
     * Test update item.
     */
    @Test
    public void whenUpdateItemThenUpdate() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name", "desc", 0));
        Item[] items = tracker.findAll();
        String id = items[0].getId();
        Input input = new StubInput(new String[] {"2", "name2", "desc2", id, "0"});
        StartUI ui = new StartUI(input, tracker);
        ui.init();
        items = tracker.findAll();
        assertThat(items[0].getName(), is("name2"));
    }
    /**
     * Test delete item.
     */
    @Test
    public void whenDeleteItemThenDelete() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name", "desc", 0));
        Item[] items = tracker.findAll();
        String id = items[0].getId();
        Input input = new StubInput(new String[] {"3", id, "0"});
        StartUI ui = new StartUI(input, tracker);
        ui.init();
        items = tracker.findAll();
        Item[] result = {};
        assertThat(items, is(result));
    }
    /**
     * Test find all items.
     */
    @Test
    public void whenFindAllItemThenArray() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"4", "0"});
        StartUI ui = new StartUI(input, tracker);
        ui.init();
        Item[] items = tracker.findAll();
        Item[] result = {};
        assertThat(items, is(result));
    }
    /**
     * Test find by name items.
     */
    @Test
    public void whenFindByNameItemThenArray() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"1", "name2", "desc2", "n", "1", "name", "desc", "n", "5", "name", "0"});
        StartUI ui = new StartUI(input, tracker);
        ui.init();
        Item[] items = tracker.findByName("name");
        assertThat(items[0].getName(), is("name"));
    }
    /**
     * Test find by id items.
     */
    @Test
    public void whenFindByIdItemThenArray() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name2", "desc2", 0));
        tracker.add(new Item("name", "desc", 0));
        Item[] items = tracker.findAll();
        String id = items[1].getId();
        Input input = new StubInput(new String[] {"6", id, "0"});
        StartUI ui = new StartUI(input, tracker);
        ui.init();
        Item item = tracker.findById(id);
        assertThat(items[1].getName(), is(item.getName()));
    }
}
