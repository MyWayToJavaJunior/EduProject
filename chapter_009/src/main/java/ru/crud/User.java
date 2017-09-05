package ru.crud;

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
     * Constructor.
     * @param name - name.
     * @param login - login.
     * @param email - email.
     * @param createDate - date of create.
     */
    public User(String name, String login, String email, Date createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
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

    @Override
    public String toString() {
        return this.name + ", " + this.email + ", " + this.createDate;
    }
}
