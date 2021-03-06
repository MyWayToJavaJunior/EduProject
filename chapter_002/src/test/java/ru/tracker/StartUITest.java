package ru.tracker;

import org.junit.Test;
import java.util.ArrayList;
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
        ArrayList<Item> items = null;
        items = tracker.findByName("name");
        assertThat(items.get(0).getName(), is("name"));

    }
    /**
     * Test update item.
     */
    @Test
    public void whenUpdateItemThenUpdate() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name", "desc", "0"));
        ArrayList<Item> items = null;
        items = tracker.findByName("name");
        String id = items.get(0).getId();
        Input input = new StubInput(new String[] {"2", "name2", "desc2", id, "0"});
        StartUI ui = new StartUI(input, tracker);
        ui.init();
        Item item = tracker.findById(id);
        assertThat(item.getName(), is("name2"));
    }
    /**
     * Test delete item.
     */
    @Test
    public void whenDeleteItemThenDelete() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name", "desc", "0"));
        ArrayList<Item> items = null;
        items = tracker.findByName("name");
        String id = items.get(0).getId();

        Input input = new StubInput(new String[] {"3", id, "0"});
        StartUI ui = new StartUI(input, tracker);
        ui.init();
        Item item = tracker.findById(id);
        Item result = null;
        assertThat(item, is(result));
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
        ArrayList<Item> items = null;
        items = tracker.findAll();
        ArrayList<Item> result = new ArrayList<>();
        result = tracker.findAll();
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
        ArrayList<Item> items = tracker.findByName("name");
        assertThat(items.get(0).getName(), is("name"));
    }
    /**
     * Test find by id items.
     */
    @Test
    public void whenFindByIdItemThenArray() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("name2", "desc2", "0"));
        tracker.add(new Item("name", "desc", "0"));
        ArrayList<Item> items = null;
        items = tracker.findAll();
        String id = items.get(1).getId();
        Input input = new StubInput(new String[] {"6", id, "0"});
        StartUI ui = new StartUI(input, tracker);
        ui.init();
        Item item = tracker.findById(id);
        assertThat(items.get(1).getName(), is(item.getName()));
    }
    /**
     * Test unresolved value.
     */
    @Test (expected = NumberFormatException.class)
    public void whenUnresolvedValueThenOk() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"1", "name", "desc", "-10", "a"});
        new StartUI(input, tracker).init();
    }
}