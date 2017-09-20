package ru.crud2.filters;

import org.junit.Test;
import ru.crud2.model.Role;

import javax.servlet.FilterChain;
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
 * Created by nikolay on 20/09/17.
 */
public class RoleFilterTest {
    /**
     * Test.
     * @throws ServletException - ServletException.
     * @throws IOException - IOException.
     */
    @Test
    public void roleFilterTest() throws ServletException, IOException {
        RoleFilter filter = new RoleFilter();
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        FilterChain chain = mock(FilterChain.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher disp = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/accessDenied.jsp")).thenReturn(disp);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestURI()).thenReturn("qweqweqwe");
        when(session.getAttribute("role")).thenReturn(Role.User);
        when(request.getServletPath()).thenReturn("path");

        filter.doFilter(request, response, chain);
        verify(request).getRequestDispatcher("/WEB-INF/views/accessDenied.jsp");
    }
}
