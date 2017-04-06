package ru.convert;

/**
 * Created by nik on 4/6/2017.
 */
public class User {
    /**
     * User id.
     */
    private int id;
    /**
     * User name.
     */
    private String name;
    /**
     * User city.
     */
    private String city;

    /**
     * Constructor.
     * @param id - user id.
     * @param name - user name.
     * @param city - user city.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * User id getter.
     * @return user id;
     */
    public int getId() {
        return this.id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (this.id == ((User) obj).id
                && this.name.equals(((User) obj).name)
                && this.city.equals(((User) obj).city)) {
            return true;
        }
        return false;
    }
}
