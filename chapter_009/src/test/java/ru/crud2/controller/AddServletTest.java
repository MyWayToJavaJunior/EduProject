package ru.crud2.controller;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.crud2.model.User;
import ru.crud2.model.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nikolay on 20/09/17.
 */
public class AddServletTest {
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
    }
    /**
     * After test.
     */
    @After
    public void after() {
        manager.delete("Login");
    }
    /**
     * Test.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void addTest() throws ServletException, IOException {
        AddServlet serv = new AddServlet();
        serv.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("login")).thenReturn("Login");
        when(request.getParameter("name")).thenReturn("Name");
        when(request.getParameter("email")).thenReturn("Email");
        when(request.getParameter("password")).thenReturn("Password");
        when(request.getParameter("roles")).thenReturn("User");

        serv.doPost(request, response);
        User user = manager.getUser("Login");

        Assert.assertThat(user.getName(), Is.is("Name"));
        verify(response).sendRedirect(String.format("%s/", request.getContextPath()));
    }
}
