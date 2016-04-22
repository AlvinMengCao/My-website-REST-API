package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.BlogPOJO;

import java.util.List;

/********************************************************************************************
 * Created by alvin on 2/27/16.
 * 1. This is a class which contains three common DAO method.
 * 2. Shouldn't instantiate this class, use abstract to prevent this.
 * 3. All three methods are public APIs to other package, so they are public.
 * 4. This class is only seen within this package, outside client shouldn't touch this class,
 * but the methods.
 * 5. protected SessionFactory, ensure subclass can use it.
 * 6. Don't need to null obsolete objects
 * 7. Do not override methods in this class, don't provide override maintenance.
 * Future work-------------------------------------------------
 * 1. Add generics to getAll method
 * ***********************************************************************************************
 */
  abstract class DAOBase {
    //this object is only a collection of method, shouldn't be instantiated

    protected final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    public final int getSize(String pojo){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        int count = ((Long) ss.createQuery("select count(*) from "+pojo).uniqueResult()).intValue();
        ss.getTransaction().commit();
        return count;
    }

    public final List getAll(String pojo){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        List list = ss.createQuery("from "+ pojo).list();
        ss.getTransaction().commit();
        return list;
    }

    public final void delete(int id, String pojo){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from " + pojo + " where id=?");
        query.setInteger(0, id);
        query.executeUpdate();
        ss.getTransaction().commit();
    }

}
