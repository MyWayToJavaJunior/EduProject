package ru.testtask.servlet;

import ru.testtask.dao.UserDAO;
import ru.testtask.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by nikolay on 04/10/17.
 */
public class AuthServlet extends HttpServlet {
    /**
     * user dao.
     */
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/testtask/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userDAO.authCkeck(login, password)) {
            HttpSession session = req.getSession();
            User user = userDAO.getOne(new User(login, password));
            session.setAttribute("login", login);
            session.setAttribute("role", user.getRole().getRole());
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", "Credentional invalid");
            doGet(req, resp);
        }
    }
}
