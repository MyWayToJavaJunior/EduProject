package ru.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.models.Item;
import ru.utils.HibernateUtil;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by nikolay on 08/11/17.
 */
public class ItemDAOImpl implements IDAO<Item> {

    private void operationWithTransaction(Consumer<Session> func) {
        Session session = HibernateUtil.openSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            func.accept(session);
            tr.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
    }

    private List<Item> query(Function<Session, List<Item>> func) {
        Session session = HibernateUtil.openSession();
        List<Item> result = func.apply(session);
        session.close();

        return result;
    }

    @Override
    public List<Item> getAll() {
        return query(session -> session.createQuery("from Item").list());
    }

    @Override
    public List<Item> getActive() {
        return query(session -> session.createQuery("from Item as i where i.done=false").list());
    }

    @Override
    public void add(Item item) {
        operationWithTransaction(session -> session.save(item));
    }

    @Override
    public void update(Item item) {
        operationWithTransaction(session -> session.update(item));
    }

    @Override
    public Item getById(int id) {
        Session session = HibernateUtil.openSession();
        Item item = session.get(Item.class, id);
        session.close();
        return item;
    }
}
