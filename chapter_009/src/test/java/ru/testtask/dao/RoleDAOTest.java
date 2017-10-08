package ru.testtask.dao;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.testtask.model.Role;

/**
 * Created by nikolay on 03/10/17.
 */
public class RoleDAOTest {
    /**
     * role dao.
     */
    private RoleDAO roleDAO;
    /**
     * role 1.
     */
    private Role testRole1;
    /**
     * role 2.
     */
    private Role testRole2;
    /**
     * before.
     */
    @Before
    public void before() {
        roleDAO = new RoleDAO();
        testRole1 = new Role("Uzzer", "Desc");
        roleDAO.add(testRole1);
    }
    /**
     * test.
     */
    @Test
    public void addAndGetByNameTest() {
        testRole2 = new Role("Test", "Description");
        roleDAO.add(testRole2);
        Role role = roleDAO.getOne(testRole2);
        Assert.assertThat(role.getRole(), Is.is(testRole2.getRole()));

        roleDAO.delete(testRole1);
        roleDAO.delete(testRole2);
    }
    /**
     * test.
     */
    @Test
    public void editTest() {
        Role edited = new Role("Uzzer", "New description");
        roleDAO.edit(edited);
        Role role = roleDAO.getOne(edited);
        Assert.assertThat(role.getDescription(), Is.is("New description"));

        roleDAO.delete(edited);
    }
    /**
     * test.
     */
    @Test
    public void deleteTest() {
        roleDAO.delete(testRole1);
        Role role = roleDAO.getOne(testRole1);
        Assert.assertNull(role);
    }
}
