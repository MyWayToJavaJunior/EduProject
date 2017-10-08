package ru.testtask.servlet;

import org.junit.Before;
import org.junit.Test;
import ru.testtask.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nikolay on 08/10/17.
 */
public class MainServletTest {
    /**
     * User manager.
     */
    private UserDAO userDAO;
    /**
     * before test.
     */
    @Before
    public void before() {
        userDAO = new UserDAO();
    }
    /**
     * Test.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void showAdminTest() throws ServletException, IOException {
        MainServlet serv = new MainServlet();
        serv.init();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher disp = mock(RequestDispatcher.class);

        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("role")).thenReturn("Admin");
        when(session.getAttribute("login")).thenReturn("admin");
        when(request.getRequestDispatcher("/WEB-INF/testtask/main.jsp")).thenReturn(disp);

        serv.doGet(request, response);

        verify(request).getRequestDispatcher("/WEB-INF/testtask/main.jsp");
    }
}
