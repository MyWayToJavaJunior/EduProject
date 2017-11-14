package ru.storage.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nikolay on 10/11/17.
 */
@Entity
@Table(name = "car")
@ToString
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter
    @Getter
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "body")
    @Setter
    @Getter
    private CarBody body;

    @ManyToOne
    @JoinColumn(name = "engine")
    @Setter
    @Getter
    private Engine engine;

    @ManyToOne
    @JoinColumn(name = "transmission")
    @Setter
    @Getter
    private Transmission transmission;

    @OneToMany
    @Setter
    @Getter
    private List<Wheel> wheels;
}
