package ru.bank;

/**
 * Created by nik on 4/7/2017.
 */
public class User {
    /**
     * Name of user.
     */
    private String name;
    /**
     * User`s passport.
     */
    private String passport;

    /**
     * Constructor.
     * @param name - name.
     * @param passport - passport.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }
}
