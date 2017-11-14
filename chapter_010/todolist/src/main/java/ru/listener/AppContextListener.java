package ru.listener;

import ru.utils.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by nikolay on 14/11/17.
 */
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.closeFactory();
    }
}
