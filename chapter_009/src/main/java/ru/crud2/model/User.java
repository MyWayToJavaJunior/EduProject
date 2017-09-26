package ru.crud2.model;

import java.util.Date;

/**
 * Created by nikolay on 30/08/17.
 */
public class User {
    /**
     * user name.
     */
    private String name;
    /**
     * user login.
     */
    private String login;
    /**
     * user email.
     */
    private String email;
    /**
     * user date of creation.
     */
    private Date createDate;
    /**
     * user password.
     */
    private String password;
    /**
     * user role.
     */
    private Role role;
    /**
     * user country.
     */
    private String country;
    /**
     * user city.
     */
    private String city;
    /**
     * Constructor.
     * @param name - name.
     * @param login - login.
     * @param email - email.
     * @param createDate - date of create.
     * @param password - password.
     * @param role - role.
     * @param country - country.
     * @param city - city.
     */
    public User(String name, String login, String email, Date createDate, String password, Role role, String country, String city) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
        this.role = role;
        this.country = country;
        this.city = city;
    }
    /**
     * getter for name.
     * @return - name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * getter for login.
     * @return - login.
     */
    public String getLogin() {
        return this.login;
    }
    /**
     * getter for email.
     * @return - email.
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * getter for create date.
     * @return - create date.
     */
    public Date getCreateDate() {
        return this.createDate;
    }
    /**
     * getter for password.
     * @return - password.
     */
    public String getPassword() {
        return this.password;
    }
    /**
     * getter for role.
     * @return - role.
     */
    public Role getRole() {
        return this.role;
    }
    /**
     * getter for country.
     * @return - country.
     */
    public String getCountry() {
        return country;
    }
    /**
     * getter for city.
     * @return - city.
     */
    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.email + ", " + this.createDate;
    }
}
