package ru.tracker;

/**
 * Created by nik on 3/26/2017.
 */
public abstract class BaseAction implements UserAction {
    /**
     * Name of action.
     */
    private String description;
    /**
     * Number of action.
     */
    private int key;
    /**
     * Construntor.
     * @param name - name of action.
     * @param key - key of action.
     */
    public BaseAction(String name, int key) {
        this.key = key;
        this.description = name;
    }
    /**
     * Item info.
     * @return info string.
     */
    public String info() {
        return String.format("%s. %s", this.key, description);
    }
}
