package ru.crud2.filters;

import ru.crud2.model.Role;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by nikolay on 14/09/17.
 */
public class RoleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (!request.getRequestURI().contains("/auth")) {
            Role role;

            role = (Role) session.getAttribute("role");

            if (role == Role.User
                    && !request.getServletPath().equals("/")
                    && !request.getServletPath().equals("/edit")
                    && !request.getServletPath().equals("/logout")) {
                request.getRequestDispatcher("/WEB-INF/views/accessDenied.jsp").forward(request, response);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
