package ru.testtask.servlet;

import org.junit.Before;
import org.junit.Test;
import ru.testtask.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

/**
 * Created by nikolay on 20/09/17.
 */
public class LogoutServletTest {
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
