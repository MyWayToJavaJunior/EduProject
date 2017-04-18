package ru.generic;

/**
 * Created by nik on 4/18/2017.
 */
public class RoleStore implements Store<Role> {
    /**
     * Array of roles.
     */
    private SimpleArray<Role> roleStore;
    /**
     * Constructor.
     * @param len - length of array.
     */
    public RoleStore(int len) {
        roleStore = new SimpleArray<>(len);
    }

    @Override
    public void add(Role value) {
        roleStore.add(value);
    }

    @Override
    public void delete(Role value) {
        roleStore.delete(value);
    }

    @Override
    public void update(int pos, Role value) {
        roleStore.update(pos, value);
    }

    @Override
    public Role get(int i) {
        return this.roleStore.get(i);
    }
}
