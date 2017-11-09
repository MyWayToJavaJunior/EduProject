package ru.testtask.servlet;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.testtask.dao.AddressDAO;
import ru.testtask.dao.UserDAO;
import ru.testtask.model.Address;
import ru.testtask.model.MusicType;
import ru.testtask.model.Role;
import ru.testtask.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * Created by nikolay on 20/09/17.
 */
public class EditServletTest {
    /**
     * User manager.
     */
    private UserDAO userDAO;
    /**
     * User .
     */
    private User user;
    /**
     * address.
     */
    private Address address;
    /**
     * address dao.
     */
    private AddressDAO addressDAO;
    /**
     * before controller.
     */
    @Before
    public void before() {
        userDAO = new UserDAO();
        addressDAO = new AddressDAO();

        user = new User("Name", "Login", "Password",
                new Role("User"),
                new Address("City", "Street", 1),
                Arrays.asList(new MusicType("Rap"), new MusicType("Rock")));
        userDAO.add(user);
        address = addressDAO.getOne(new Address("City", "Street", 1));
    }
    /**
     * After controller.
     */
    @After
    public void after() {
        userDAO.delete(user);
    }
    /**
     * Test.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void editTest() throws ServletException, IOException {
        EditServlet serv = new EditServlet();
        serv.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("address_id")).thenReturn(address.getId().toString());
        when(request.getParameter("login_val")).thenReturn("Login");
        when(request.getParameter("name")).thenReturn("EditedName");
        when(request.getParameter("password")).thenReturn("Password");
        when(request.getParameter("role")).thenReturn("User");
        when(request.getParameter("city")).thenReturn("City");
        when(request.getParameter("street")).thenReturn("Street");
        when(request.getParameter("number")).thenReturn("1");
        when(request.getParameterValues("music_type")).thenReturn(new String[] {"Rap", "Rock"});

        serv.doPost(request, response);

        User user = userDAO.getOne(new User("Login"));

        Assert.assertThat(user.getName(), Is.is("EditedName"));
        verify(response).sendRedirect(String.format("%s/", request.getContextPath()));
    }
}
