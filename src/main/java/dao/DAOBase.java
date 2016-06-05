package dao;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

/**
 * Created by alvin on 6/4/16.
 */
 class DAOBase {
    private static final DAOBase dao = new DAOBase();
    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    private DAOBase(){}

    int getSize(String tableName){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        int count = ((Long) ss.createQuery("select count(*) from "+
                tableName).uniqueResult()).intValue();
        ss.getTransaction().commit();
        return count;
    }

    void deleteLast(String tableName, int last){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        Query q = ss.createQuery("delete from "+ tableName + " where id=?");
        q.setInteger(0, last);
        q.executeUpdate();
        ss.getTransaction().commit();
        q = null;
    }

    Object getLast(String table){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        Object b = ss.createQuery("from "+table+" ORDER BY id DESC")
                .setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        return b;
    }

    List getAll(String table){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        List list = ss.createQuery("from "+ table + " ORDER BY id desc").list();
        ss.getTransaction().commit();
        return list;
    }

    Object getSingle(int id, String name){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        Object b = ss.get("pojo."+name,id);
        ss.getTransaction().commit();
        return b;
    }

    void add(Object o){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        ss.save(o);
        ss.getTransaction().commit();
    }

    static DAOBase getInstance(){
        return dao;
    }
}
