package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Created by alvin on 2/24/16.
 */
public class HibernateUtils {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
