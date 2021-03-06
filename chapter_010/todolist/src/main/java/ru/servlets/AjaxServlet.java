package ru.servlets;

import com.google.gson.Gson;
import ru.dao.ItemDAOImpl;
import ru.dao.IDAO;
import ru.models.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by nikolay on 08/11/17.
 */
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IDAO<Item> dao = new ItemDAOImpl();

        Boolean checked = Boolean.valueOf(req.getParameter("sort"));

        List<Item> items = checked ? dao.getAll() : dao.getActive();

        Gson gson = new Gson();

        String json = gson.toJson(items);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
