package ru.testtask.repository;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.testtask.dao.AddressDAO;
import ru.testtask.dao.MusicTypeDAO;
import ru.testtask.dao.RoleDAO;
import ru.testtask.dao.UserDAO;
import ru.testtask.model.Address;
import ru.testtask.model.MusicType;
import ru.testtask.model.Role;
import ru.testtask.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nikolay on 04/10/17.
 */
public class UserRepoTest {
    /**
     * User repo.
     */
    private IUserRepository userRepo;
    /**
     * address dao.
     */
    private AddressDAO addressDAO;
    /**
     * user dao.
     */
    private UserDAO userDAO;
    /**
     * role dao.
     */
    private RoleDAO roleDAO;
    /**
     * music dao.
     */
    private MusicTypeDAO musicTypeDAO;
    /**
     * user 1.
     */
    private User testUser1;
    /**
     * user 2.
     */
    private User testUser2;
    /**
     * address 1.
     */
    private Address testAddress1;
    /**
     * address 2.
     */
    private Address testAddress2;
    /**
     * role 1.
     */
    private Role testRole1;
    /**
     * spec.
     */
    private ISpecification spec;
    /**
     * music type 1.
     */
    private MusicType testType1;
    /**
     * music list.
     */
    private List<MusicType> music;
    /**
     * before.
     */
    @Before
    public void before() {
        userRepo = new UserRepository();
        addressDAO = new AddressDAO();
        userDAO = new UserDAO();
        roleDAO = new RoleDAO();
        musicTypeDAO = new MusicTypeDAO();

        //Music type
        testType1 = new MusicType("testType", "");
        musicTypeDAO.add(testType1);
        music = Arrays.asList(testType1);

        //Addresses
        testAddress1 = new Address(0, "SPb", "Lenina", 11);
        testAddress2 = new Address(0, "SPb", "Lenina", 12);

        addressDAO.add(testAddress1);
        addressDAO.add(testAddress2);

        //Roles
        testRole1 = new Role("testRole", "");
        roleDAO.add(testRole1);

        //Users
        testUser1 = new User("Test name1", "test1", "test1",
                testRole1,
                testAddress1,
                music);

        testUser2 = new User("Test name2", "test2", "test2",
                testRole1,
                testAddress2,
                music);

        userDAO.add(testUser1);
        userDAO.add(testUser2);


    }
    /**
     * controller.
     */
    @After
    public void after() {
        userDAO.delete(testUser1);
        userDAO.delete(testUser2);
        addressDAO.delete(testAddress1);
        addressDAO.delete(testAddress2);
        roleDAO.delete(testRole1);
        musicTypeDAO.delete(testType1);
    }

    /**
     * controller.
     */
    @Test
    public void findUserByAddressTest() {
        spec = new UserSearchByAddress(testAddress1);
        List<User> users = userRepo.query(spec);
        Assert.assertThat(users.get(0).getLogin(), Is.is("test1"));
    }
    /**
     * controller.
     */
    @Test
    public void findUserByRoleTest() {
        spec = new UserSearchByRole(testRole1);
        List<User> users = userRepo.query(spec);
        Assert.assertThat(users.size(), Is.is(2));
        Assert.assertThat(users.get(0).getLogin(), Is.is("test1"));
        Assert.assertThat(users.get(1).getLogin(), Is.is("test2"));
    }
    /**
     * controller.
     */
    @Test
    public void findUserByMusicTypeTest() {
        spec = new UserSearchByMusicType(testType1);
        List<User> users = userRepo.query(spec);
        Assert.assertThat(users.size(), Is.is(2));
        Assert.assertThat(users.get(0).getLogin(), Is.is("test1"));
        Assert.assertThat(users.get(1).getLogin(), Is.is("test2"));
    }
}
