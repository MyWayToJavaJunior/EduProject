package ru.testtask.model;

/**
 * Created by nikolay on 03/10/17.
 */
public class MusicType {
    /**
     * music type.
     */
    private String type;
    /**
     * description.
     */
    private String description;
    /**
     * Constructor.
     * @param type - type.
     * @param description - desc.
     */
    public MusicType(String type, String description) {
        this.type = type;
        this.description = description;
    }
    /**
     * Constructor.
     * @param type - type.
     */
    public MusicType(String type) {
        this.type = type;
        this.description = "";
    }
    /**
     * getter type.
     * @return - type.
     */
    public String getType() {
        return type;
    }
    /**
     * getter desc.
     * @return - desc.
     */
    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MusicType musicType = (MusicType) o;

        return type.equals(musicType.type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }
}
