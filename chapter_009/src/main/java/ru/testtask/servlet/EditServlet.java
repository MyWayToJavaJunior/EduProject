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
public class EditServlet extends HttpServlet {
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
        String log = req.getParameter("edit_user");
        User user = userDAO.getOne(new User(log));

        req.setAttribute("ulogin", user.getLogin());
        req.setAttribute("address_id", user.getAddress().getId());
        req.setAttribute("name", user.getName());
        req.setAttribute("city", user.getAddress().getCity());
        req.setAttribute("street", user.getAddress().getStreet());
        req.setAttribute("number", user.getAddress().getNumber());
        req.setAttribute("role", user.getRole().getRole());
        req.setAttribute("music", user.getMusicTypes());

        req.getRequestDispatcher("/WEB-INF/testtask/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer addressId = Integer.parseInt(req.getParameter("address_id"));
        String login = req.getParameter("login_val");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String city = req.getParameter("city");
        String street = req.getParameter("street");
        Integer number = Integer.parseInt(req.getParameter("number"));
        String role = req.getParameter("role");
        String[] music = req.getParameterValues("music_type");

        List<MusicType> types = new ArrayList<>();
        for (String s : music) {
            types.add(new MusicType(s));
        }

        User user = new User(name, login, password, new Role(role), new Address(addressId, city, street, number), types);
        userDAO.edit(user);

        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
