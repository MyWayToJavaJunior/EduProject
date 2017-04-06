package ru.convert;

/**
 * Created by nik on 4/6/2017.
 */
public class User implements Comparable {
    /**
     * User id.
     */
    private int id;
    /**
     * User name.
     */
    private String name;
    /**
     * User age.
     */
    private int age;
    /**
     * User city.
     */
    private String city;

    /**
     * Constructor.
     * @param id - user id.
     * @param name - user name.
     * @param age - userage.
     * @param city - user city.
     */
    public User(int id, String name, int age, String city) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.city = city;
    }

    /**
     * User id getter.
     * @return user id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * User name getter.
     * @return user name.
     */
    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.age + this.id;
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

    @Override
    public int compareTo(Object obj) {
        User u = (User) obj;
        return this.age - u.age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }
}
