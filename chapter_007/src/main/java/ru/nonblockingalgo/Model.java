package ru.nonblockingalgo;

/**
 * Created by nik on 6/7/2017.
 */
public class Model {
    /**
     * Name of model.
     */
    private String name;
    /**
     * Version of model.
     */
    private int version = 0;
    /**
     * Constructor.
     * @param name - name of model.
     */
    public Model(String name) {
        this.name = name;
    }
    /**
     * GEtter for version.
     * @return - version of model.
     */
    public int getVersion() {
        return version;
    }
    /**
     * Model version increment.
     * @return - model with inc version.
     */
    public Model incMod() {
        Model m = new Model(this.name);
        m.version = ++this.version;
        return m;
    }
}
