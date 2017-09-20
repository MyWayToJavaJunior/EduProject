package ru.crud2.controller;

import ru.crud2.model.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikolay on 11/09/17.
 */
public class DelServlet extends HttpServlet {
    /**
     * connection to db.
     */
    private UserManager userManager;

    @Override
    public void init() throws ServletException {
        userManager = new UserManager();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        this.userManager.delete(login);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
