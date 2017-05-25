package ru.synchronize;

/**
 * Created by nik on 5/25/2017.
 */
public class User {
    /**
     * User name.
     */
    private String name;
    /**
     * User's ammout.
     */
    private int amount;
    /**
     * User's constructor.
     * @param name - user name.
     * @param amount - user's amount.
     */
    public User(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
    /**
     * Name getter.
     * @return name.
     */
    public String getName() {
        return name;
    }
    /**
     * Amount getter.
     * @return amount.
     */
    public int getAmount() {
        return amount;
    }
    /**
     * Amount setter.
     * @param amount - amount.
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "name = " + name + ", amount = " + amount;
    }
}
