package ru.testtask.model;

/**
 * Created by nikolay on 03/10/17.
 */
public class Address {
    /**
     * id.
     */
    private Integer id;
    /**
     * city.
     */
    private String city;
    /**
     * street.
     */
    private String street;
    /**
     * number.
     */
    private Integer number;
    /**
     * Constructor.
     * @param id - id.
     * @param city - city.
     * @param street - street.
     * @param number - number.
     */
    public Address(Integer id, String city, String street, Integer number) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.number = number;
    }
    /**
     * Constructor.
     * @param city - city.
     * @param street - street.
     * @param number - number.
     */
    public Address(String city, String street, Integer number) {
        this.city = city;
        this.street = street;
        this.number = number;
        this.id = 0;
    }
    /**
     * getter id.
     * @return - id.
     */
    public Integer getId() {
        return id;
    }
    /**
     * getter city.
     * @return - city.
     */
    public String getCity() {
        return city;
    }
    /**
     * getter street.
     * @return - street.
     */
    public String getStreet() {
        return street;
    }
    /**
     * getter number.
     * @return - number.
     */
    public Integer getNumber() {
        return number;
    }
}
