package ru.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.models.Item;
import ru.utils.HibernateUtil;

import java.util.List;

/**
 * Created by nikolay on 08/11/17.
 */
public class DAOImpl implements IDAO {

    @Override
    public List<Item> getAll() {
        Session session = HibernateUtil.openSession();
        List<Item> result = session.createQuery("from Item").list();
        session.close();
        return result;
    }

    @Override
    public List<Item> getActive() {
        Session session = HibernateUtil.openSession();
        List<Item> result = session.createQuery("from Item as i where i.done=false").list();
        session.close();
        return result;
    }

    @Override
    public void add(Item item) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Item item) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Item getById(int id) {
        Session session = HibernateUtil.openSession();
        Query query = session.createQuery("from Item as i where i.id= :id");
        query.setParameter("id", id);
        List<Item> result = query.list();
        session.close();
        return result.get(0);
    }
}
