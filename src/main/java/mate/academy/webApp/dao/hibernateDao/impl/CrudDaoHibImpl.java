package mate.academy.webApp.dao.hibernateDao.impl;

import mate.academy.webApp.dao.hibernateDao.CrudDaoHib;
import mate.academy.webApp.utill.HibernateSessionFactoryUtill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CrudDaoHibImpl<T> implements CrudDaoHib<T> {

    @Override
    public void add(T entity) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
    }

    @Override
    public T getById(Class<T> clazz, Long id) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        T object = session.get(clazz, id);
        session.close();
        return object;
    }

    @Override
    public void delete(T entity) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
        session.close();
    }

    @Override
    public List<T> getAll(Class<T> clazz) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        List<T> objects = (List<T>) session
                .createQuery("From " + clazz.getName())
                .list();
        session.close();
        return objects;
    }

    @Override
    public void update(T entity) {
        Session session = HibernateSessionFactoryUtill.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
    }

}