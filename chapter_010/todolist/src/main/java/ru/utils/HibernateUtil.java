package ru.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by nikolay on 08/11/17.
 * Class for work with session factory.
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return SESSION_FACTORY.openSession();
    }

    public static void closeFactory() {
        SESSION_FACTORY.close();
    }
}
