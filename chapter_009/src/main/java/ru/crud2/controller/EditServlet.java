package ru.crud2.controller;

import ru.crud2.model.Role;
import ru.crud2.model.User;
import ru.crud2.model.UserManager;
import ru.crud2.model.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by nikolay on 11/09/17.
 */
public class EditServlet extends HttpServlet {
    /**
     * connection to db.
     */
    private UserManager userManager;
    /**
     * Validator for user data.
     */
    private UserValidator validator;
    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
        validator = new UserValidator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("login", req.getParameter("editlogin"));
        req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("roles");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        if (role == null) {
            role = Role.User.name();
        }
        User user = new User(name, login, email, new Date(), password, Role.valueOf(role), country, city);
        if (validator.validate(user)) {
            this.userManager.edit(user);
        }
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
