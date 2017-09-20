package ru.crud2.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.crud2.model.Role;
import ru.crud2.model.User;
import ru.crud2.model.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nikolay on 20/09/17.
 */
public class DelServletTest {
    /**
     * User manager.
     */
    private UserManager manager;
    /**
     * before test.
     */
    @Before
    public void before() {
        manager = new UserManager();
        manager.add(new User("Name", "TestLogin", "Email@mail.ru", new Date(), "Password", Role.User));
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

        when(request.getParameter("login")).thenReturn("TestLogin");

        serv.doPost(request, response);

        User user = manager.getUser("TestLogin");
        Assert.assertNull(user);
        verify(response).sendRedirect(String.format("%s/", request.getContextPath()));
    }
}
