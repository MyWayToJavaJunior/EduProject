package ru.storage.models;

import java.util.List;

/**
 * Created by nikolay on 10/11/17.
 */
public class Car {
    private Integer id;
    private CarBody body;
    private Engine engine;
    private Transmission transmission;
    private List<Wheel> wheels;

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarBody getBody() {
        return body;
    }

    public void setBody(CarBody body) {
        this.body = body;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", body=" + body +
                ", engine=" + engine +
                ", transmission=" + transmission +
                ", wheels=" + wheels +
                '}';
    }
}
