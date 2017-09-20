package ru.crud2.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.crud2.model.Role;
import ru.crud2.model.User;
import ru.crud2.model.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nikolay on 20/09/17.
 */
public class LogoutServletTest {
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
     * After test.
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
    public void logoutTest() throws ServletException, IOException {
        LogoutServlet serv = new LogoutServlet();
        serv.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);

        serv.doPost(request, response);
        verify(session).invalidate();
    }
}
