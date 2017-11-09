package ru.crud2.controller;

import org.junit.Before;
import org.junit.Test;
import ru.crud2.model.Role;
import ru.crud2.model.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nikolay on 20/09/17.
 */
public class ShowServletTest {
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
    }
    /**
     * Test.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void showAdminTest() throws ServletException, IOException {
        ShowServlet serv = new ShowServlet();
        serv.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher disp = mock(RequestDispatcher.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("role")).thenReturn(Role.Admin);
        when(request.getRequestDispatcher("/WEB-INF/views/viewAdmin.jsp")).thenReturn(disp);

        serv.doGet(request, response);

        List<Role> roles = manager.getAllRoles();
        verify(session).setAttribute("roles", roles);
        verify(request).getRequestDispatcher("/WEB-INF/views/viewAdmin.jsp");
    }
    /**
     * Test.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void showUserTest() throws ServletException, IOException {
        ShowServlet serv = new ShowServlet();
        serv.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher disp = mock(RequestDispatcher.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("role")).thenReturn(Role.User);
        when(request.getRequestDispatcher("/WEB-INF/views/viewUser.jsp")).thenReturn(disp);

        serv.doGet(request, response);

        verify(request).getRequestDispatcher("/WEB-INF/views/viewUser.jsp");
    }
}
