package ru.testtask.servlet;

import org.junit.After;
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
import ru.testtask.repository.IUserRepository;
import ru.testtask.repository.UserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * Created by nikolay on 20/09/17.
 */
public class AuthServletTest {
    /**
     * user repo.
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
     * music.
     */
    private MusicType testType1;
    /**
     * music types.
     */
    private List<MusicType> music;
    /**
     * before test.
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
     * After test.
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
     * Test.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void authTest() throws ServletException, IOException {
        AuthServlet serv = new AuthServlet();
        serv.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getParameter("login")).thenReturn("test1");
        when(request.getParameter("password")).thenReturn("test1");
        when(request.getSession()).thenReturn(session);

        serv.doPost(request, response);

        verify(session).setAttribute("login", "test1");
        verify(session).setAttribute("role", "testRole");
        verify(response).sendRedirect(String.format("%s/", request.getContextPath()));
    }
    /**
     * Test.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void authErrorTest() throws ServletException, IOException {
        AuthServlet serv = new AuthServlet();
        serv.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher disp = mock(RequestDispatcher.class);

        when(request.getParameter("login")).thenReturn("Login");
        when(request.getParameter("password")).thenReturn("Pass");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/WEB-INF/testtask/auth.jsp")).thenReturn(disp);

        serv.doPost(request, response);

        verify(request).setAttribute("error", "Credentional invalid");
    }
}
