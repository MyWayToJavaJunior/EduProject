package ru.testtask.servlet;

import ru.testtask.dao.UserDAO;
import ru.testtask.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikolay on 06/10/17.
 */
public class DelServlet extends HttpServlet {
    /**
     * user dao.
     */
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("delete_user");
        User user = userDAO.getOne(new User(login));
        this.userDAO.delete(user);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
