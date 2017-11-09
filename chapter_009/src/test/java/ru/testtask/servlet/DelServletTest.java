package ru.testtask.servlet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
public class DelServletTest {
    /**
     * User manager.
     */
    private UserDAO userDAO;
    /**
     * before controller.
     */
    @Before
    public void before() {
        userDAO = new UserDAO();
        User user = new User("Name", "Login", "Password",
                new Role("User"),
                new Address("City", "Street", 1),
                Arrays.asList(new MusicType("Rap"), new MusicType("Rock")));
        userDAO.add(user);
    }
    /**
     * Test.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void delTest() throws ServletException, IOException {
        DelServlet serv = new DelServlet();
        serv.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("delete_user")).thenReturn("Login");

        serv.doPost(request, response);

        User user = userDAO.getOne(new User("Login"));
        Assert.assertNull(user);
        verify(response).sendRedirect(String.format("%s/", request.getContextPath()));
    }
}
