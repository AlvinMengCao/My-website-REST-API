package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import pojo.BlogPOJO;

import java.util.List;

/**
 * Created by alvin on 2/27/16.
 */
public class DAOBase {
    public int getSize(String pojo){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        int count = ((Long) ss.createQuery("select count(*) from "+pojo).uniqueResult()).intValue();
        ss.getTransaction().commit();
        return count;
    }

    public List getAll(String pojo){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        List list = ss.createQuery("from "+ pojo).list();
        ss.getTransaction().commit();
        return list;
    }

    public void delete(int id, String pojo){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from " + pojo + " where id=?");
        query.setInteger(0, id);
        query.executeUpdate();
        ss.getTransaction().commit();
    }

}
