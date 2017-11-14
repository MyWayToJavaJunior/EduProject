package ru.storage.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by nikolay on 10/11/17.
 */
@Entity
@Table(name = "wheel")
@ToString(exclude = "id")
@NoArgsConstructor
public class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter
    @Getter
    private Integer id;

    @Column(name = "name")
    @Setter
    @Getter
    private String name;

}
