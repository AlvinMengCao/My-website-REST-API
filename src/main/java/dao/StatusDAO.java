package dao;

import api.Status;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.StatusPOJO;
import java.util.Date;


/**
 * Created by alvin on 2/25/16.
 * 1.Singleton instance, use private static final field, factory method and private constructor
 * to achieve this.
 * 2. Already null obsolete objects.
 */
public final class StatusDAO extends DAOBase{
    private static final StatusDAO statusDAO = new StatusDAO();
    private StatusDAO(){}

    //has test, won't pollute data
    public void addStatus(String content){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        StatusPOJO statusPOJO = new StatusPOJO(content);
        ss.save(statusPOJO);
        ss.getTransaction().commit();
        statusPOJO = null;
    }

    //has test, won't pollute data
    public void addStatusWithDate(String content, Date date){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        StatusPOJO statusPOJO = new StatusPOJO(content);
        statusPOJO.setDate(date);
        ss.save(statusPOJO);
        ss.getTransaction().commit();
        statusPOJO = null;
    }

    //has test, won't pollute data
    public Status getSingle(int id) {
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        StatusPOJO s = ss.get(StatusPOJO.class,id);
        ss.getTransaction().commit();
        Status status = new Status(s.getId(), s.getContent(),s.getDate());
        s = null;
        return status;
    }

    //has test, won't pollute data
    public Status getLast(){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        StatusPOJO s = (StatusPOJO) ss.createQuery("from StatusPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        Status status = new Status(s.getId(), s.getContent(),s.getDate());
        s = null;
        return status;
    }

    //has test, won't pollute data
    public Status update(int id, String content){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        StatusPOJO s = ss.get(StatusPOJO.class,id);
        s.setContent(content);
        s.setDate(new Date());
        ss.save(s);
        ss.getTransaction().commit();
        Status status = new Status(s.getId(), s.getContent(),s.getDate());
        s = null;
        return status;
    }

    public void deleteLast(){
        StatusDAO statusDAO = new StatusDAO();
        int last = statusDAO.getLast().getId();
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from StatusPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
        query = null;
    }
    public static StatusDAO getStatusDAO(){
        return statusDAO;
    }
}
