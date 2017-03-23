package ru.tracker;

/**
 * Created by nik on 3/15/2017.
 */
public class StartUI {
    /**
     * object for input.
     */
    private Input input;
    /**
     * object for tracker.
     */
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
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select:"));
            menu.select(key);
        } while (!"0".equals(this.input.ask("Exit? Press 0 for exit.")));
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
}
