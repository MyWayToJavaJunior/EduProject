package ru.tracker;

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
    private long create;
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
    public Item(String name, String desc, long create) {
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
    public long getCreate() {
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
}
