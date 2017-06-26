package ru.tracker;

import java.util.Random;

/**
 * Created by nik on 3/13/2017.
 */
public class Item {
    /**
     * id of Item.
     */
    private String id;
    /**
     * name of Item.
     */
    private String name;
    /**
     * description of Item.
     */
    private String desc;
    /**
     * date of create of item.
     */
    private String create;
    /**
     * comments of item.
     */
    private String[] comments = new String[3];

    /**
     * constructor.
     * @param name - name of item.
     * @param desc - description of item.
     * @param create - date of create.
     */
    public Item(String name, String desc, String create) {
        this.id = generateId();
        this.name = name;
        this.desc = desc;
        this.create = create;
    }

    /**
     * Getter.
     * @return id.
     */
    public String getId() {
        return this.id;
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
     * @return description.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Getter.
     * @return date of create.
     */
    public String getCreate() {
        return this.create;
    }

    /**
     * Getter.
     * @return comments.
     */
    public String[] getComments() {
        return this.comments;
    }

    /**
     * Setter.
     * @param id - set id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * random object.
     */
    private static final Random RN = new Random();
    /**
     * Item ID generator.
     * @return - item id.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (!id.equals(item.id)) {
            return false;
        }
        return name != null ? name.equals(item.name) : item.name == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
