package ru.generic;

/**
 * Created by nik on 4/18/2017.
 */
public abstract class Base {
    /**
     * id of item.
     */
    private String id;
    /**
     * id getter.
     * @return - id.
     */
    public String getId() {
        return this.id;
    }
    /**
     * id setter.
     * @param id - id of item.
     */
    public void setId(String id) {
        this.id = id;
    }
}
