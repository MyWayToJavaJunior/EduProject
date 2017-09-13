package ru.crud2.controller;

import ru.crud2.model.User;
import ru.crud2.model.UserManager;

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
     * constructor with db connection creation.
     */
    public EditServlet() {
        userManager = new UserManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        this.userManager.edit(new User(name, login, email, new Date()));
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
