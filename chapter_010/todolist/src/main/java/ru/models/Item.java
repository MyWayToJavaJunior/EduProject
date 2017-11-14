package ru.models;

import lombok.*;

import java.time.LocalDateTime;


/**
 * Created by nikolay on 08/11/17.
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class Item {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String desc;

    @Getter
    @Setter
    private LocalDateTime created;

    @Getter
    @Setter
    private Boolean done;

    public Item(String desc, LocalDateTime created, Boolean done) {
        this.desc = desc;
        this.created = created;
        this.done = done;
    }
}
