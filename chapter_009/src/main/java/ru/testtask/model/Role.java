package ru.testtask.model;

/**
 * Created by nikolay on 03/10/17.
 */
public class Role {
    /**
     * role.
     */
    private String role;
    /**
     * descriotion.
     */
    private String description;
    /**
     * Constructor.
     * @param role - role.
     * @param description - desc.
     */
    public Role(String role, String description) {
        this.role = role;
        this.description = description;
    }
    /**
     * Constructor.
     * @param role - role.
     */
    public Role(String role) {
        this.role = role;
        this.description = "";
    }
    /**
     * Getter role.
     * @return - role.
     */
    public String getRole() {
        return role;
    }
    /**
     * Getter desc.
     * @return - desc.
     */
    public String getDescription() {
        return description;
    }
}
