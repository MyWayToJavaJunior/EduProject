package ru.models;

import java.time.LocalDateTime;

/**
 * Created by nikolay on 08/11/17.
 */
public class Item {
    private Integer id;
    private String desc;
    private LocalDateTime created;
    private Boolean done;

    public Item(Integer id, String desc, LocalDateTime created, Boolean done) {
        this.id = id;
        this.desc = desc;
        this.created = created;
        this.done = done;
    }

    public Item(String desc, LocalDateTime created, Boolean done) {
        this.desc = desc;
        this.created = created;
        this.done = done;
    }

    public Item() {
        this.desc = "";
        this.created = LocalDateTime.now();
        this.done = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
