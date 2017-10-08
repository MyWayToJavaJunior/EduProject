package ru.testtask.servlet;

import ru.testtask.dao.MusicTypeDAO;
import ru.testtask.dao.RoleDAO;
import ru.testtask.dao.UserDAO;
import ru.testtask.model.MusicType;
import ru.testtask.model.Role;
import ru.testtask.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by nikolay on 04/10/17.
 */
public class MainServlet extends HttpServlet {
    /**
     * role dao.
     */
    private RoleDAO roleDAO;
    /**
     * music.
     */
    private MusicTypeDAO musicTypeDAO;
    /**
     * user dao.
     */
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        roleDAO = new RoleDAO();
        musicTypeDAO = new MusicTypeDAO();
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        List<User> users = userDAO.getAll();
        User user = userDAO.getOne(new User(session.getAttribute("login").toString()));
        List<Role> roles = roleDAO.getAll();
        List<MusicType> musicTypes = musicTypeDAO.getAll();

        req.setAttribute("user", user);
        req.setAttribute("users", users);

        session.setAttribute("roles", roles);
        session.setAttribute("music", musicTypes);

        req.getRequestDispatcher("/WEB-INF/testtask/main.jsp").forward(req, resp);
    }
}
