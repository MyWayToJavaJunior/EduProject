package ru.storage.models;

/**
 * Created by nikolay on 10/11/17.
 */
public class Wheel {
    private Integer id;
    private String name;

    public Wheel() {
    }

    public Wheel(String name) {
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
        return "Wheel{" +
                "name='" + name + '\'' +
                '}';
    }
}
