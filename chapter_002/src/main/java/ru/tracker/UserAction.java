package ru.tracker;

import java.sql.SQLException;

/**
 * Created by nik on 3/22/2017.
 */
public interface UserAction {
    /**
     * Action.
     * @param input - input stream.
     * @param tracker - object of tracker.
     * @throws SQLException - .
     */
    void execute(Input input, Tracker tracker) throws SQLException;
    /**
     * Information about action.
     * @return - infostring.
     */
    String info();
}
