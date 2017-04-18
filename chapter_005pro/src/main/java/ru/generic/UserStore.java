package ru.generic;

/**
 * Created by nik on 4/18/2017.
 */
public class UserStore implements Store<User> {
    /**
     * Array of users.
     */
    private SimpleArray<User> userStore;

    /**
     * Constructor.
     * @param len - length of array.
     */
    public UserStore(int len) {
        userStore = new SimpleArray<>(len);
    }

    @Override
    public void add(User user) {
        userStore.add(user);
    }

    @Override
    public void update(int position, User user) {
        userStore.update(position, user);
    }

    @Override
    public void delete(User user) {
        userStore.delete(user);
    }

    @Override
    public User get(int i) {
        return this.userStore.get(i);
    }
}
