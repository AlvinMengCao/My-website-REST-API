package dao;

import api.Status;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.StatusPOJO;

import java.util.Date;
import java.util.List;


/**
 * Created by alvin on 2/25/16.
 */
public class StatusDAO extends DAOBase{


    //has test, won't pollute data
    public void addStatus(String content){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        StatusPOJO statusPOJO = new StatusPOJO(content);
        ss.save(statusPOJO);
        ss.getTransaction().commit();
    }

    //has test, won't pollute data
    public void addStatusWithDate(String content, Date date){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        StatusPOJO statusPOJO = new StatusPOJO(content);
        statusPOJO.setDate(date);
        ss.save(statusPOJO);
        ss.getTransaction().commit();
    }

    //has test, won't pollute data
    public Status getSingle(int id) {
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        StatusPOJO s = ss.get(StatusPOJO.class,id);
        ss.getTransaction().commit();
        return new Status(s.getId(), s.getContent(),s.getDate());
    }

    //has test, won't pollute data
    public Status getLast(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        StatusPOJO s = (StatusPOJO) ss.createQuery("from StatusPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        return new Status(s.getId(), s.getContent(),s.getDate());
    }

    //has test, won't pollute data
    public Status update(int id, String content){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        StatusPOJO s = ss.get(StatusPOJO.class,id);
        s.setContent(content);
        s.setDate(new Date());
        ss.save(s);
        ss.getTransaction().commit();
        return new Status(s.getId(), s.getContent(),s.getDate());
    }

    public void deleteLast(){
        StatusDAO statusDAO = new StatusDAO();
        int last = statusDAO.getLast().getId();
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from StatusPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
    }

}
