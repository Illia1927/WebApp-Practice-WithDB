package mate.academy.webApp.dao.hibernateDao.impl;

import mate.academy.webApp.dao.hibernateDao.GoodDaoHib;
import mate.academy.webApp.model.Good;
import mate.academy.webApp.utill.HibernateSessionFactoryUtill;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class GoodDaoHibImpl extends CrudDaoHibImpl<Good> implements GoodDaoHib {
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtill.getSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(GoodDaoHibImpl.class);
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
