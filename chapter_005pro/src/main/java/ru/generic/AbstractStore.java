package ru.generic;

/**
 * Created by nik on 4/20/2017.
 * @param <T> - type.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**
     * Array of users.
     */
    private SimpleArray<T> store;

    /**
     * Constructor.
     * @param len - length of array.
     */
    public AbstractStore(int len) {
        store = new SimpleArray<>(len);
    }

    @Override
    public void add(T user) {
        store.add(user);
    }

    @Override
    public void update(int position, T user) {
        store.update(position, user);
    }

    @Override
    public void delete(T user) {
        store.delete(user);
    }

    @Override
    public T get(int i) {
        return this.store.get(i);
    }
}
