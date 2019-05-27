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

public class RoleDaoHibImpl implements RoleDaoHib {
    private static final SessionFactory sessionFactory = HibernateSessionFactoryUtill.getSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(RoleDaoHibImpl.class);

    @Override
    public Long add(Role role) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Long id = (Long) session.save(role);
            LOGGER.debug("New role with username (" + role.getRoleName() + ") created");
            session.getTransaction().commit();
            return id;
        }
    }

    @Override
    public Optional<Role> getById(Long id) {
        Role role;
        try (Session session = sessionFactory.openSession()) {
            role = session.get(Role.class, id);
            if (role != null) {
                LOGGER.debug("Got user with id (" + id + ") from DB");
                return Optional.of(role);
            }
            LOGGER.debug("Can't got user with id (" + id + ") from DB");
            return Optional.empty();
        }
    }

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

    @Override
    public List<Role> getAll() {
        List<Role> roles;
        try (Session session = sessionFactory.openSession()) {
            LOGGER.debug("Got all roles from DB");
            roles = session.createQuery("FROM Role").list();
        }
        return roles;
    }

    @Override
    public int update(Role role) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("update Role set roleName = :roleName " +
                    "where idRole = :idRole");
            query.setParameter("roleName", role.getRoleName());
            query.setParameter("idRole", role.getIdRole());
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("Role updated successfully");
            } else {
                LOGGER.debug("Role updating failed");
            }
            return rows;
        }
    }

    @Override
    public int delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("delete from Role where idRole = :idRole");
            query.setParameter("idRole", id);
            int rows = query.executeUpdate();
            session.getTransaction().commit();
            if (rows == 1) {
                LOGGER.debug("Role deleted successfully");
            } else {
                LOGGER.debug("Role deleting failed");
            }
            return rows;
        }
    }
}
