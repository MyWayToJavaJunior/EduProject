package ru.nonblockingalgo;

/**
 * Created by nik on 6/7/2017.
 */
public class Model {
    private String name;
    private int version = 0;

    public Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void incVersion() {
        this.version++;
    }

    public Model incMod() {
        Model m = new Model(this.name);
        m.version = ++this.version;
        return m;
    }
}
