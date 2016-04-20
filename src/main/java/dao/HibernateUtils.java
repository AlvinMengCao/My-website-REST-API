package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Created by alvin on 2/24/16.
 * 1. Singleton instance of SessionFactory.
 * 2. getSessionFactory method is only used within this package, so no modifier.
 * 3. Shouldn't be instantiate, use private constructor to override.
 */
 final class  HibernateUtils {

    private static final SessionFactory sessionFactory;

    private HibernateUtils(){

    }

    //run this code block when initialize the project to set SessionFactory instance
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //return singleton instance of SessionFactory, only access within this package.
     static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
