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

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.passport.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        User tmp = (User) obj;
        if (this.name.equals(tmp.name) && this.passport.equals(tmp.passport)) {
            return true;
        }
        return false;
    }
}
