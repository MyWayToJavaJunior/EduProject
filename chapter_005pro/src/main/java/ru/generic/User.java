package ru.generic;

/**
 * Created by nik on 4/18/2017.
 */
public class User extends Base {
    /**
     * Constructor.
     * @param id - id of new user.
     */
    public User(String id) {
        this.setId(id);
    }

    @Override
    public String toString() {
        return this.getId();
    }

    @Override
    public boolean equals(Object obj) {
        User tmp = (User) obj;
        if (tmp.getId().equals(this.getId())) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
