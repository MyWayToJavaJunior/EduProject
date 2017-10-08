package ru.testtask.repository;

import ru.testtask.model.Role;

/**
 * Created by nikolay on 08/10/17.
 */
public class UserSearchByRole implements ISpecification {
    /**
     * role.
     */
    private Role role;
    /**
     * Constructor.
     * @param role - role.
     */
    public UserSearchByRole(Role role) {
        this.role = role;
    }

    @Override
    public String toSqlClauses() {
        return String.format(" where user_role = '%s';", role.getRole());
    }
}
