package ru.crud2.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.crud2.model.Role;
import ru.crud2.model.User;
import ru.crud2.model.UserManager;

import javax.servlet.RequestDispatcher;
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
public class AuthServletTest {
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
        manager.add(new User("Name", "TestLogin", "Email@mail.ru", new Date(), "Password", Role.User, "Russia", "SPb"));
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
    public void authTest() throws ServletException, IOException {
        AuthServlet serv = new AuthServlet();
        serv.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getParameter("login")).thenReturn("TestLogin");
        when(request.getParameter("password")).thenReturn("Password");
        when(request.getSession()).thenReturn(session);

        serv.doPost(request, response);

        verify(session).setAttribute("login", "TestLogin");
        verify(session).setAttribute("role", Role.User);
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
        when(request.getRequestDispatcher("/WEB-INF/views/auth.jsp")).thenReturn(disp);

        serv.doPost(request, response);

        verify(request).setAttribute("error", "Credentional invalid");
    }
}
