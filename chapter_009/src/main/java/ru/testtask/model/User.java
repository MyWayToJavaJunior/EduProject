package ru.testtask.model;

import java.util.List;

/**
 * Created by nikolay on 03/10/17.
 */
public class User {
    /**
     * name.
     */
    private String name;
    /**
     * login.
     */
    private String login;
    /**
     * password.
     */
    private String password;
    /**
     * role.
     */
    private Role role;
    /**
     * address.
     */
    private Address address;
    /**
     * music types.
     */
    private List<MusicType> musicTypes;
    /**
     * Constructor.
     * @param login - login.
     * @param role - rile.
     * @param address - address.
     * @param music - music.
     * @param name - name.
     * @param password - pass.
     */
    public User(String name, String login, String password, Role role, Address address, List<MusicType> music) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.role = role;
        this.address = address;
        this.musicTypes = music;
    }
    /**
     * Constructor.
     * @param login - login.
     */
    public User(String login) {
        this.login = login;
        this.name = "";
        this.password = "";
        this.role = null;
        this.address = null;
        this.musicTypes = null;
    }
    /**
     * Constructor.
     * @param login - login.
     * @param password - pass.
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.name = "";
        this.role = null;
        this.address = null;
        this.musicTypes = null;
    }
    /**
     * getter name.
     * @return - name.
     */
    public String getName() {
        return name;
    }
    /**
     * getter login.
     * @return - login.
     */
    public String getLogin() {
        return login;
    }
    /**
     * getter pass.
     * @return - pass.
     */
    public String getPassword() {
        return password;
    }
    /**
     * getter role.
     * @return - role.
     */
    public Role getRole() {
        return role;
    }
    /**
     * getter address.
     * @return - address.
     */
    public Address getAddress() {
        return address;
    }
    /**
     * getter music.
     * @return - music.
     */
    public List<MusicType> getMusicTypes() {
        return musicTypes;
    }
}
