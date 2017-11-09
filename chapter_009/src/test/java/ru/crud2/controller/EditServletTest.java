package ru.crud2.controller;

import org.hamcrest.core.Is;
import org.junit.After;
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
public class EditServletTest {
    /**
     * User manager.
     */
    private UserManager manager;
    /**
     * before controller.
     */
    @Before
    public void before() {
        manager = new UserManager();
        manager.add(new User("Name", "TestLogin", "Email@mail.ru", new Date(), "Password", Role.User, "Russia", "SPb"));
    }
    /**
     * After controller.
     */
    @After
    public void after() {
        manager.delete("TestLogin");
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

        when(request.getParameter("login")).thenReturn("TestLogin");
        when(request.getParameter("name")).thenReturn("EditedName");
        when(request.getParameter("email")).thenReturn("EditedEmail");
        when(request.getParameter("password")).thenReturn("EditedPassword");
        when(request.getParameter("roles")).thenReturn("User");

        serv.doPost(request, response);
        User user = manager.getUser("TestLogin");

        Assert.assertThat(user.getName(), Is.is("EditedName"));
        verify(response).sendRedirect(String.format("%s/", request.getContextPath()));
    }
}
