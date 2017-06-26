package ru.tracker;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Edit item class.
 */
class EditItem extends BaseAction {
    /**
     * Construntor.
     * @param name - name of action.
     * @param key - number of action.
     */
    EditItem(String name, int key) {
        super(name, key);
    }
    /**
     * Edit item action.
     * @param input - input obj.
     * @param tracker - tracker obj.
     */
    public void execute(Input input, Tracker tracker) {
        tracker.update(updateItem(input));
    }
    /**
     * Edit item.
     * @param input - input object.
     * @return - new item for update.
     */
    private static Item updateItem(Input input) {
        Item i = new Item(input.ask("Enter new item name "),
                input.ask("Enter new item description "),
                String.valueOf(System.currentTimeMillis()));
        i.setId(input.ask("Enter item id "));
        return i;
    }
}

/**
 * Main class of menu.
 */
public class MenuTracker {
    /**
     * Input obj.
     */
    private Input input;
    /**
     * tracker obj.
     */
    private Tracker tracker;
    /**
     * array of user actions.
     */
    private UserAction[] actions = new UserAction[7];
    /**
     * Constructor.
     * @param input - input obj.
     * @param tracker - tracker obj.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * fill array of actions.
     * @return - array of range.
     */
    public int[] fillActions() {
        this.actions[1] = this.new AddItem("Add new item.", 1);
        this.actions[2] = new EditItem("Edit item.", 2);
        this.actions[3] = this.new DelItem("Delete item.", 3);
        this.actions[4] = new MenuTracker.ShowItems("Show all items.", 4);
        this.actions[5] = this.new FinfByNameItem("Find item by name.", 5);
        this.actions[6] = this.new FinfByIdItem("Find item by ID.", 6);

        int[] range = new int[this.actions.length - 1];
        for (int i = 0; i < this.actions.length - 1; i++) {
            range[i] = i + 1;
        }
        return range;
    }
    /**
     * Select action.
     * @param key - action to select.
     * @throws SQLException - .
     */
    public void select(int key) throws SQLException {
        this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * Show menu.
     */
    public void show() {
        for (UserAction action: this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    /**
     * Class add new item.
     */
    private class AddItem extends BaseAction {
        /**
         * Construntor.
         * @param name - name of action.
         * @param key - number of action.
         */
        AddItem(String name, int key) {
            super(name, key);
        }
        /**
         * Add item action.
         * @param input - input obj.
         * @param tracker - tracker obj.
         */
        public void execute(Input input, Tracker tracker) {
            tracker.add(createItem(input));
        }
        /**
         * Create item.
         * @param input - input object.
         * @return - new item.
         */
        private Item createItem(Input input) {
            return new Item(input.ask("Enter item name "),
                    input.ask("Enter item description "),
                    String.valueOf(System.currentTimeMillis()));
        }
    }
    /**
     * Class delete new item.
     */
    private class DelItem extends BaseAction {
        /**
         * Construntor.
         * @param name - name of action.
         * @param key - number of action.
         */
        DelItem(String name, int key) {
            super(name, key);
        }
        /**
         * Delete item action.
         * @param input - input obj.
         * @param tracker - tracker obj.
         */
        public void execute(Input input, Tracker tracker) {
            tracker.delete(deleteItem(input));
        }
        /**
         * Delete item.
         * @param input - input object.
         * @return - new item for delete.
         */
        private Item deleteItem(Input input) {
            //String delId = input.ask("Enter item id ");
            Item i = new Item("4", "", String.valueOf(System.currentTimeMillis()));
            i.setId(input.ask("Enter item id "));
            return i;
        }
    }
    /**
     * Class find by name item.
     */
    private class FinfByNameItem extends BaseAction {
        /**
         * Construntor.
         * @param name - name of action.
         * @param key - number of action.
         */
        FinfByNameItem(String name, int key) {
            super(name, key);
        }
        /**
         * find by name item action.
         * @param input - input obj.
         * @param tracker - tracker obj.
         */
        public void execute(Input input, Tracker tracker) {
            ArrayList<Item> l = tracker.findByName(input.ask("Enter the name: "));
            for (Item item : l) {
                System.out.println(String.format("%s, %s, %s, %s",  item.getId(), item.getName(), item.getDesc(), item.getCreate()));
            }

        }
    }
    /**
     * Class find by ID item.
     */
    private class FinfByIdItem extends BaseAction {
        /**
         * Construntor.
         * @param name - name of action.
         * @param key - number of action.
         */
        FinfByIdItem(String name, int key) {
            super(name, key);
        }
        /**
         * find by ID item action.
         * @param input - input obj.
         * @param tracker - tracker obj.
         */
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("Enter the id: "));
            System.out.println(String.format("%s, %s, %s, %s",  item.getId(), item.getName(), item.getDesc(), item.getCreate()));
        }
    }
    /**
     * Class show items.
     */
    private static class ShowItems extends BaseAction {
        /**
         * Construntor.
         * @param name - name of action.
         * @param key - number of action.
         */
        ShowItems(String name, int key) {
            super(name, key);
        }
        /**
         * Print all items.
         * @param input - input obj.
         * @param tracker - tracker obj.
         */
        public void execute(Input input, Tracker tracker)  {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s, %s, %s, %s",  item.getId(), item.getName(), item.getDesc(), item.getCreate()));
            }

        }
    }
}
