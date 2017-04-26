package ru.map;

import java.util.Calendar;

/**
 * Created by nik on 4/24/2017.
 */
public class User {

    /**
     * Name of user.
     */
    private String name;
    /**
     * Number of childrens.
     */
    private int children;
    /**
     * Date of bith.
     */
    private Calendar birthday;

    /**
     * Constructor.
     * @param name - name;
     * @param children - child.
     * @param birthday - bith.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (children != user.children) {
            return false;
        }
        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return birthday != null ? birthday.equals(user.birthday) : user.birthday == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
