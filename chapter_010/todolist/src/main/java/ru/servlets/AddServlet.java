package ru.servlets;

import ru.dao.ItemDAOImpl;
import ru.dao.IDAO;
import ru.models.Item;
import ru.utils.TimeUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by nikolay on 08/11/17.
 */
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IDAO<Item> dao = new ItemDAOImpl();
        dao.add(new Item(req.getParameter("desc"),
                LocalDateTime.parse(req.getParameter("date"), TimeUtil.getFormatter()),
                req.getParameter("done") == null
        ));
        resp.sendRedirect("index.html");
    }
}
