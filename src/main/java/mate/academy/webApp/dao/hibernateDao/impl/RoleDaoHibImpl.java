package mate.academy.webApp.dao.hibernateDao.impl;

import mate.academy.webApp.dao.hibernateDao.RoleDaoHib;
import mate.academy.webApp.model.Role;
import mate.academy.webApp.utill.HibernateSessionFactoryUtill;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class RoleDaoHibImpl extends CrudDaoHibImpl<Role> implements RoleDaoHib {
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtill.getSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(RoleDaoHibImpl.class);

    @Override
    public Optional<Role> getByLogin(String name) {
        List<Role> roles;
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Role WHERE roleName = :roleName");
            query.setParameter("roleName", name);
            roles = query.list();
            if (!roles.isEmpty()) {
                LOGGER.debug("Got role with name(" + name + ") from DB");
                return Optional.of(roles.get(0));
            }
            LOGGER.error("Can't got role with name(" + name + ") from DB");
            return Optional.empty();
        }
    }
}
