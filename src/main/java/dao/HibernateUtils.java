package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Created by alvin on 2/24/16.
 */
public class HibernateUtils {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
            if (sessionFactory != null) {
                return sessionFactory;
            }
        Configuration conf = new Configuration().configure();

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();

        serviceRegistryBuilder.applySettings(conf.getProperties());

		/*ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();*/

        SessionFactory sf = conf.buildSessionFactory();
        return sf;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }
}
