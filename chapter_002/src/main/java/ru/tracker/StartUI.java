package ru.tracker;

/**
 * Created by nik on 3/15/2017.
 */
public class StartUI {
    /**
     * object for input.
     */
    private Input input;
    private Tracker tracker;
    /**
     * constructor.
     * @param input - input object.
     * @param tracker - tracker object.
     */
    public StartUI(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * initialization.
     */
    public void init() {
        ConsoleOutput output = new ConsoleOutput();

        Item[] mas;
        Item item;
        boolean flag = true;
        while (flag) {
            int i = Integer.parseInt(input.ask("1. - Add\n"
                    + "2. - Update\n"
                    + "3. - Delete\n"
                    + "4. - Find All\n"
                    + "5. - Find by name\n"
                    + "6. - Find by id\n"
                    + "0. - Exit\n"
                    + "Please, input your choise: "));
            switch (i) {
                case 1:
                    tracker.add(createItem(input));
                    break;
                case 2:
                    tracker.update(updateItem(input));
                    break;
                case 3:
                    tracker.delete(deleteItem(input));
                    break;
                case 4: mas = tracker.findAll();
                    output.print(mas);
                    break;
                case 5: mas = tracker.findByName(input.ask("Enter the name: "));
                    output.print(mas);
                    break;
                case 6: item = tracker.findById(input.ask("Enter the id: "));
                    output.print(item);
                    break;
                case 0:
                    flag = false;
                    break;
                default: System.out.println("Wrong input!");
            }
        }
    }

    /**
     * main method.
     * @param args - arguments.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }

    /**
     * Create item.
     * @param input - input object.
     * @return - new item.
     */
    private static Item createItem(Input input) {
        return new Item(input.ask("Enter item name "),
                   input.ask("Enter item description "),
                   System.currentTimeMillis());
    }
    /**
     * Create item.
     * @param input - input object.
     * @return - new item for update.
     */
    private static Item updateItem(Input input) {
        Item i = new Item(input.ask("Enter item name "),
                 input.ask("Enter item description "),
                 System.currentTimeMillis());
        i.setId(input.ask("Enter item id "));
        return i;
    }
    /**
     * Create item.
     * @param input - input object.
     * @return - new item for delete.
     */
    private static Item deleteItem(Input input) {
        Item i = new Item("", "", System.currentTimeMillis());
        i.setId(input.ask("Enter item id "));
        return i;
    }
}
