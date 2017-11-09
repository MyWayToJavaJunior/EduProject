package ru.servlets;

import ru.dao.DAOImpl;
import ru.dao.IDAO;
import ru.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nikolay on 08/11/17.
 */
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IDAO dao = new DAOImpl();
        Item m = dao.getById(Integer.valueOf(req.getParameter("id")));
        m.setDone((m.getDone() ? false : true));
        dao.update(m);
        resp.sendRedirect("index.html");
    }
}
