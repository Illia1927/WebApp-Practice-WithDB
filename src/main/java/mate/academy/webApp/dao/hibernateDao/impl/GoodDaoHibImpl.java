package mate.academy.webApp.dao.hibernateDao.impl;

import mate.academy.webApp.dao.hibernateDao.GoodDaoHib;
import mate.academy.webApp.model.Good;
import mate.academy.webApp.utill.HibernateSessionFactoryUtill;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class GoodDaoHibImpl implements GoodDaoHib {
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtill.getSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(GoodDaoHibImpl.class);

    @Override
    public Long add(Good good) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Long id = (Long) session.save(good);
            LOGGER.debug("New good with username (" + good.getNameOfGood() + ") created");
            session.getTransaction().commit();
            return id;
        }
    }

    @Override
    public Optional<Good> getById(Long id) {
        Good good;
        try (Session session = sessionFactory.openSession()) {
            good = session.get(Good.class, id);
            if (good != null) {
                LOGGER.debug("Got good with id (" + id + ") from DB");
                return Optional.of(good);
            }
            LOGGER.debug("Can't got good with id (" + id + ") from DB");
            return Optional.empty();
        }
    }

    @Override
    public Optional<Good> getByLogin(String name) {
        List<Good> goods;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Good WHERE nameOfGood = :nameOfGood");
            query.setParameter("nameOfGood", name);
            goods = query.list();
            if (!goods.isEmpty()) {
                LOGGER.debug("Got good with username(" + name + ") from DB");
                return Optional.of(goods.get(0));
            }
            LOGGER.error("Can't got good with username(" + name + ") from DB");
            return Optional.empty();
        }
    }

    @Override
    public List<Good> getAll() {
        List<Good> goods;
        try (Session session = sessionFactory.openSession()) {
            LOGGER.debug("Got all users from DB");
            goods = session.createQuery("FROM Good ").list();
        }
        return goods;
    }

    @Override
    public int update(Good good) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("update Good set nameOfGood = :nameOfGood," +
                    " discription = :discription, price = :price where goodId = :goodId");
            query.setParameter("nameOfGood", good.getNameOfGood());
            query.setParameter("discription", good.getDiscription());
            query.setParameter("price", good.getPrice());
            query.setParameter("goodId", good.getGoodId());
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("Good updated successfully");
            } else {
                LOGGER.debug("Good updating failed");
            }
            return rows;
        }
    }

    @Override
    public int update(Long id, Good good) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("update Good set nameOfGood = :nameOfGood," +
                    " discription = :discription, price = :price where goodId = :goodId");
            query.setParameter("nameOfGood", good.getNameOfGood());
            query.setParameter("discription", good.getDiscription());
            query.setParameter("price", good.getPrice());
            query.setParameter("goodId", id);
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("Good updated successfully");
            } else {
                LOGGER.debug("Good updating failed");
            }
            return rows;
        }
    }

    @Override
    public int delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from Good where goodId = :goodId");
            query.setParameter("goodId", id);
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("Good deleted successfully");
            } else {
                LOGGER.debug("Good deleting failed");
            }
            return rows;
        }
    }
}
