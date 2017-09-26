package ru.crud2.controller;

import com.google.gson.Gson;
import ru.crud2.model.UserManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by nikolay on 26/09/17.
 */
public class AjaxController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new Gson();
        String country = gson.fromJson(req.getParameter("country"), String.class);

        UserManager manager = new UserManager();
        List<String> list = manager.getCities(country);

        String json = gson.toJson(list);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
    }
}
