package ru.generic;

/**
 * Created by nik on 4/18/2017.
 */
public class Role extends Base {
    /**
     * Constructor.
     * @param id - id of new role.
     */
    public Role(String id) {
        this.setId(id);
    }

    @Override
    public String toString() {
        return this.getId();
    }

    @Override
    public boolean equals(Object obj) {
        Role tmp = (Role) obj;
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
