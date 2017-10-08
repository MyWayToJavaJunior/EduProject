package ru.testtask.dao;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.testtask.model.Address;
import ru.testtask.model.MusicType;
import ru.testtask.model.Role;
import ru.testtask.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nikolay on 03/10/17.
 */
public class UserDAOTest {
    /**
     * User dao.
     */
    private UserDAO userDAO;
    /**
     * address dao.
     */
    private AddressDAO addressDAO;
    /**
     * address 1.
     */
    private Address testAddress1;
    /**
     * address 2.
     */
    private Address testAddress2;
    /**
     * User 1.
     */
    private User testUser1;
    /**
     * User 2.
     */
    private User testUser2;
    /**
     * music types.
     */
    private List<MusicType> music;
    /**
     * before.
     */
    @Before
    public void before() {
        userDAO = new UserDAO();
        addressDAO = new AddressDAO();

        testAddress1 = new Address(0, "SPb", "Lenina", 11);
        testAddress2 = new Address(0, "SPb", "Lenina", 12);

        addressDAO.add(testAddress1);
        addressDAO.add(testAddress2);

        music = Arrays.asList(new MusicType("Rock", ""), new MusicType("Rap", ""));

        testUser1 = new User("Test name", "test", "test",
                new Role("User", ""),
                testAddress1, music);

        userDAO.add(testUser1);
    }
    /**
     * after.
     */
    @After
    public void after() {
        addressDAO.delete(testAddress1);
        addressDAO.delete(testAddress2);
    }
    /**
     * test.
     */
    @Test
    public void addAndGetByNameTest() {
        testUser2 = new User("tester", "tester", "tester",
                new Role("User", ""),
                testAddress2, music);

        userDAO.add(testUser2);
        User user = userDAO.getOne(testUser2);
        Assert.assertThat(user.getLogin(), Is.is("tester"));

        userDAO.delete(testUser1);
        userDAO.delete(testUser2);
    }
    /**
     * test.
     */
    @Test
    public void editTest() {
        User edited = new User("new", "test", "new",
                new Role("User", ""),
                testAddress2, music);

        userDAO.edit(edited);
        User user = userDAO.getOne(edited);
        Assert.assertThat(user.getName(), Is.is("new"));
        Assert.assertThat(user.getPassword(), Is.is("new"));

        userDAO.delete(testUser1);
        userDAO.delete(edited);
    }
    /**
     * test.
     */
    @Test
    public void deleteTest() {
        userDAO.delete(testUser1);
        User user = userDAO.getOne(testUser1);
        Assert.assertNull(user);
    }
}
