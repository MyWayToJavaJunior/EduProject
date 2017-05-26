package ru.synchronize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 5/25/2017.
 */
public class UserStorage {
    /**
     * List of users.
     */
    private List<User> users = new ArrayList<>();
    /**
     * add user to list.
     * @param user - user.
     */
    public void addUser(User user) {
        synchronized (this.users) {
            users.add(user);
        }
    }
    /**
     * get user from list.
     * @param user - user.
     * @return - user.
     */
    public User getUser(User user) {
        synchronized (this.users) {
            if (users.contains(user)) {
                int index = users.indexOf(user);
                return users.get(index);
            }
        }
        return null;
    }
    /**
     * Remove user from list.
     * @param user - user.
     */
    public void removeUser(User user) {
        synchronized (this.users) {
            users.remove(user);
        }
    }
    /**
     * Edit user.
     * @param user - old user.
     * @param newUser - new user.
     */
    public void editUser(User user, User newUser) {
        synchronized (this.users) {
            if (users.contains(user)) {
                int index = users.indexOf(user);
                users.set(index, newUser);
            }
        }
    }
    /**
     * Show info about all users.
     */
    public void showAll() {
        synchronized (this.users) {
            for (User u : users) {
                System.out.println(u);
            }
        }
    }
    /**
     * Transfer money between users.
     * @param src - user from.
     * @param dect - user to.
     * @param sum - sum of money to transfer.
     */
    public void transfMoney(User src, User dect, int sum) {
        synchronized (this.users) {
            if (src.getAmount() >= sum) {
                src.setAmount(src.getAmount() - sum);
                dect.setAmount(dect.getAmount() + sum);
            }
        }
    }
    /**
     * Main met.
     * @param args - .
     */
    public static void main(String[] args) {
        UserStorage us = new UserStorage();

        User u1 = new User("Nik", 100);
        User u2 = new User("John", 200);
        User u3 = new User("Sam", 150);
        us.addUser(u1);
        us.addUser(u2);
        us.addUser(u3);

        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                us.transfMoney(u1, u2, 50);
                us.transfMoney(u2, u1, 50);
                us.addUser(new User(new Integer(i).toString(), 100));
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        us.showAll();
        System.out.println(us.users.size());
    }
}
