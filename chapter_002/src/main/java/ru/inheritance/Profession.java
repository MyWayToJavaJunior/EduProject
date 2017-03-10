package ru.inheritance;

/**
 * Created by nik on 3/10/2017.
 */
public class Profession {
    /**
     * name of prof.
     */
    private String name;
    /**
     * diploma of prof.
     */
    private String diploma;
    /**
     * experience of prof.
     */
    private int experience;

    /**
     * constructor.
     * @param name - name of prof.
     * @param diploma - diploma of prof.
     * @param exp - experience of prof.
     */
    public Profession(String name, String diploma, int exp) {
        this.name = name;
        this.diploma = diploma;
        this.experience = exp;
    }

    /**
     * Getter.
     * @return name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Getter.
     * @return diploma.
     */
    public String getDiploma() {
        return this.diploma;
    }
    /**
     * Getter.
     * @return experience.
     */
    public int getExperience() {
        return this.experience;
    }
}
