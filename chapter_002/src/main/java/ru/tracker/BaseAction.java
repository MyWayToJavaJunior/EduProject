package ru.tracker;

/**
 * Created by nik on 3/26/2017.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Item info.
     * @return info string.
     */
    public String info() {
        return String.format("%s. %s", this.key(), "Show all items.");
    }
}
