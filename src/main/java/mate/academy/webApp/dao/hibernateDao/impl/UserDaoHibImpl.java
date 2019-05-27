package mate.academy.webApp.dao.hibernateDao.impl;

import mate.academy.webApp.dao.hibernateDao.UserDaoHib;
import mate.academy.webApp.model.User;
import mate.academy.webApp.utill.HibernateSessionFactoryUtill;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoHibImpl extends CrudDaoHibImpl<User> implements UserDaoHib {
    private static final Logger LOGGER = Logger.getLogger(UserDaoHibImpl.class);
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtill.getSessionFactory();
    @Override
    public Optional<User> getByLogin(String login) {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM User WHERE login = :login");
            query.setParameter("login", login);
            users = query.list();
            if (!users.isEmpty()) {
                LOGGER.debug("Got user with username(" + login + ") from DB");
                return Optional.of(users.get(0));
            }
            LOGGER.error("Can't got user with username(" + login + ") from DB");
            return Optional.empty();
        }
    }

    @Override
    public int delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from User where userId = :userId");
            query.setParameter("userId", id);
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("User deleted successfully");
            } else {
                LOGGER.debug("User deleting failed");
            }
            return rows;
        }
    }
}
