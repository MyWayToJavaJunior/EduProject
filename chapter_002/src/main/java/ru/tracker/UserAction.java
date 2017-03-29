package ru.tracker;

/**
 * Created by nik on 3/22/2017.
 */
public interface UserAction {
    /**
     * number of action.
     * @return - number of key.
     */
   // int key();
    /**
     * Action.
     * @param input - input stream.
     * @param tracker - object of tracker.
     */
    void execute(Input input, Tracker tracker);
    /**
     * Information about action.
     * @return - infostring.
     */
    String info();
}
