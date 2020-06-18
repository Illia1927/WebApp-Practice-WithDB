package mate.academy.webApp.utill;

import mate.academy.webApp.model.Good;
import mate.academy.webApp.model.Order;
import mate.academy.webApp.model.Role;
import mate.academy.webApp.model.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtill {
    private static final Logger logger = Logger.getLogger(HibernateSessionFactoryUtill.class);
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtill() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Role.class);
                configuration.addAnnotatedClass(Good.class);
                configuration.addAnnotatedClass(Order.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                logger.error("Error in HibernateSessionFactory", e);
            }
        }
        return sessionFactory;
    }
}
