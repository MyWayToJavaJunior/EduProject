package ru.crud2.controller;

import ru.crud2.model.Role;
import ru.crud2.model.User;
import ru.crud2.model.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by nikolay on 05/09/17.
 */
public class ShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Role role;
        role = (Role) session.getAttribute("role");
        UserManager userManager = new UserManager();
        if (role == Role.Admin) {
            List<User> users = userManager.getAll();
            List<Role> roles = userManager.getAllRoles();
            req.setAttribute("users", users);
            session.setAttribute("roles", roles);
            req.getRequestDispatcher("/WEB-INF/views/viewAdmin.jsp").forward(req, resp);
        } else {
            User user = userManager.getUser((String) session.getAttribute("login"));
            req.setAttribute("user", user);
            req.getRequestDispatcher("/WEB-INF/views/viewUser.jsp").forward(req, resp);
        }
    }
}
