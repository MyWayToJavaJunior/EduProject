package ru.testtask.servlet;

import ru.testtask.dao.UserDAO;
import ru.testtask.model.Address;
import ru.testtask.model.MusicType;
import ru.testtask.model.Role;
import ru.testtask.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikolay on 06/10/17.
 */
public class AddServlet extends HttpServlet {
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
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        String city = req.getParameter("city");
        String street = req.getParameter("street");
        Integer number = Integer.parseInt(req.getParameter("number"));

        String[] music = req.getParameterValues("music_type");
        List<MusicType> types = new ArrayList<>();
        for (String s : music) {
            types.add(new MusicType(s));
        }

        User user = new User(name, login, password, new Role(role, ""), new Address(0, city, street, number), types);

        userDAO.add(user);

        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
