package ru.tracker;

/**
 * Edit item class.
 */
class EditItem extends BaseAction {
    /**
     * Construntor.
     * @param name - name of action.
     */
    EditItem(String name) {
        super(name);
    }
    /**
     * NUmber of action.
     * @return - 2.
     */
    public int key() {
        return 2;
    }
    /**
     * Edit item action.
     * @param input - input obj.
     * @param tracker - tracker obj.
     */
    public void execute(Input input, Tracker tracker)  {
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
                System.currentTimeMillis());
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
        this.actions[1] = this.new AddItem("Add new item.");
        this.actions[2] = new EditItem("Edit item.");
        this.actions[3] = this.new DelItem("Delete item.");
        this.actions[4] = new MenuTracker.ShowItems("Show all items.");
        this.actions[5] = this.new FinfByNameItem("Find item by name.");
        this.actions[6] = this.new FinfByIdItem("Find item by ID.");

        int[] range = new int[this.actions.length - 1];
        for (int i = 0; i < this.actions.length - 1; i++) {
            range[i] = i + 1;
        }
        return range;
    }
    /**
     * Select action.
     * @param key - action to select.
     */
    public void select(int key) {
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
         */
        AddItem(String name) {
            super(name);
        }
        /**
         * NUmber of action.
         * @return - 1.
         */
        public int key() {
            return 1;
        }
        /**
         * Add item action.
         * @param input - input obj.
         * @param tracker - tracker obj.
         */
        public void execute(Input input, Tracker tracker)  {
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
                    System.currentTimeMillis());
        }
    }
    /**
     * Class delete new item.
     */
    private class DelItem extends BaseAction {
        /**
         * Construntor.
         * @param name - name of action.
         */
        DelItem(String name) {
            super(name);
        }
        /**
         * NUmber of action.
         * @return - 3.
         */
        public int key() {
            return 3;
        }
        /**
         * Delete item action.
         * @param input - input obj.
         * @param tracker - tracker obj.
         */
        public void execute(Input input, Tracker tracker)  {
            tracker.delete(deleteItem(input));
        }
        /**
         * Delete item.
         * @param input - input object.
         * @return - new item for delete.
         */
        private Item deleteItem(Input input) {
            Item i = new Item("", "", System.currentTimeMillis());
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
         */
        FinfByNameItem(String name) {
            super(name);
        }
        /**
         * NUmber of action.
         * @return - 5.
         */
        public int key() {
            return 5;
        }
        /**
         * find by name item action.
         * @param input - input obj.
         * @param tracker - tracker obj.
         */
        public void execute(Input input, Tracker tracker)  {
            tracker.findByName(input.ask("Enter the name: "));
        }
    }
    /**
     * Class find by ID item.
     */
    private class FinfByIdItem extends BaseAction {
        /**
         * Construntor.
         * @param name - name of action.
         */
        FinfByIdItem(String name) {
            super(name);
        }
        /**
         * NUmber of action.
         * @return - 6.
         */
        public int key() {
            return 6;
        }
        /**
         * find by ID item action.
         * @param input - input obj.
         * @param tracker - tracker obj.
         */
        public void execute(Input input, Tracker tracker)  {
            tracker.findById(input.ask("Enter the id: "));
        }
    }
    /**
     * Class show items.
     */
    private static class ShowItems extends BaseAction {
        /**
         * Construntor.
         * @param name - name of action.
         */
        ShowItems(String name) {
            super(name);
        }
        /**
         * NUmber of action.
         * @return - 4.
         */
        public int key() {
            return 4;
        }
        /**
         * Print all items.
         * @param input - input obj.
         * @param tracker - tracker obj.
         */
        public void execute(Input input, Tracker tracker)  {
            for (Item item : tracker.findAll()) {
                System.out.println(String.format("%s. %s", item.getName(), item.getId()));
            }
        }
    }
}
