package mate.academy.webApp.dao.hibernateDao.impl;

import mate.academy.webApp.dao.hibernateDao.UserDaoHib;
import mate.academy.webApp.model.User;
import mate.academy.webApp.utill.HibernateSessionFactoryUtill;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class UserDaoHibImpl implements UserDaoHib {
    private static final Logger LOGGER = Logger.getLogger(UserDaoHibImpl.class);
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtill.getSessionFactory();

    @Override
    public Long add(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Long id = (Long) session.save(user);
            LOGGER.debug("New user with username (" + user.getName() + ") created");
            session.getTransaction().commit();
            return id;
        }
    }

    @Override
    public Optional<User> getById(Long id) {
        User user;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(User.class, id);
            if (user != null) {
                LOGGER.debug("Got user with id (" + id + ") from DB");
                return Optional.of(user);
            }
            LOGGER.debug("Can't got user with id (" + id + ") from DB");
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> getByLogin(String name) {
        List<User> users;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM User WHERE name = :name");
            query.setParameter("name", name);
            users = query.list();
            if (!users.isEmpty()) {
                LOGGER.debug("Got user with username(" + name + ") from DB");
                return Optional.of(users.get(0));
            }
            LOGGER.error("Can't got user with username(" + name + ") from DB");
            return Optional.empty();
        }
    }

    @Override
    public List<User> getAll() {
        List<User> users;
        try (Session session = sessionFactory.openSession()) {
            LOGGER.debug("Got all users from DB");
            users = session.createQuery("FROM User").list();
        }
        return users;
    }

    @Override
    public int update(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("update User set name = :name," +
                    " login = :login, email = :email," +
                    " password = :password where userId = :userId");
            query.setParameter("name", user.getName());
            query.setParameter("login", user.getLogin());
            query.setParameter("email", user.getEmail());
            query.setParameter("password", user.getEmail());
            query.setParameter("userId", user.getUserId());
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("User updated successfully");
            } else {
                LOGGER.debug("User updating failed");
            }
            return rows;
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