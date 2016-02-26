package dao;

import api.WebSiteComment;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.WebSiteCommentPOJO;

import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 2/24/16.
 */
public class WebsiteCommentDAO {

    //has test case
    public void addComment(String email, String comment){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        WebSiteCommentPOJO webSiteCommentPOJO = new WebSiteCommentPOJO(email, comment);
        ss.save(webSiteCommentPOJO);
        ss.getTransaction().commit();
    }

    //has test case
    public void addCommentWithDate(String email, String comment, Date date){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        WebSiteCommentPOJO webSiteCommentPOJO = new WebSiteCommentPOJO(email, comment);
        webSiteCommentPOJO.setDate(date);
        ss.save(webSiteCommentPOJO);
        ss.getTransaction().commit();

    }

    //has test case, don't need to recover data
    public int getSize(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        int count = ((Long) ss.createQuery("select count(*) from WebSiteCommentPOJO").uniqueResult()).intValue();
        ss.getTransaction().commit();
        return count;
    }

    //has test case, don't need to recover data
    public WebSiteComment getSingle(int id) {
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        WebSiteCommentPOJO w = ss.get(WebSiteCommentPOJO.class,id);
        ss.getTransaction().commit();
        return new WebSiteComment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
    }

    //has test case, don't need to recover data
    public WebSiteComment getLast(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        WebSiteCommentPOJO w = (WebSiteCommentPOJO) ss.createQuery("from WebSiteCommentPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        return new WebSiteComment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
    }

    //has test case, be care of different object type!!
    public List getAll(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        List list = ss.createCriteria(WebSiteCommentPOJO.class).list();
        ss.getTransaction().commit();
        return list;
    }

    //has test case
    public WebSiteComment update(int id, String email, String comment){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        WebSiteCommentPOJO w = ss.get(WebSiteCommentPOJO.class,id);
        w.setEmail(email);
        w.setComment(comment);
        w.setDate(new Date());
        ss.save(w);
        ss.getTransaction().commit();
        return new WebSiteComment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
    }

    //has test case
    public void delete(int id){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from WebSiteCommentPOJO where id=?");
        query.setInteger(0, id);
        query.executeUpdate();
        ss.getTransaction().commit();
    }

    public void deleteLast(){
        WebsiteCommentDAO websiteCommentDAO = new WebsiteCommentDAO();
        int last = (int)websiteCommentDAO.getLast().getId();
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from WebSiteCommentPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
    }


}
