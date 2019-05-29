package mate.academy.webApp.dao.hibernateDao.impl;

import mate.academy.webApp.dao.hibernateDao.CrudDaoHib;
import mate.academy.webApp.utill.HibernateSessionFactoryUtill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CrudDaoHibImpl<T> implements CrudDaoHib<T> {

    @Override
    public void add(T entity) {
        try (Session session = HibernateSessionFactoryUtill
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public T getById(Class<T> clazz, Long id) {
        try (Session session = HibernateSessionFactoryUtill
                .getSessionFactory()
                .openSession()) {
            T object = session.get(clazz, id);
            return object;
        }
    }

    @Override
    public void delete(T entity) {
        try (Session session = HibernateSessionFactoryUtill
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        }
    }

    @Override
    public List<T> getAll(Class<T> clazz) {
        try (Session session = HibernateSessionFactoryUtill
                .getSessionFactory()
                .openSession()) {
            List<T> objects = (List<T>) session
                    .createQuery("From " + clazz.getName())
                    .list();
            session.close();
            return objects;
        }
    }

    @Override
    public void update(T entity) {
        try (Session session = HibernateSessionFactoryUtill
                .getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
    }
}
