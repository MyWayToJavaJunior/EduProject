package ru.storage.models;

/**
 * Created by nikolay on 10/11/17.
 */
public class Transmission {
    private Integer id;
    private String name;

    public Transmission() {
    }

    public Transmission(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "name='" + name + '\'' +
                '}';
    }
}
