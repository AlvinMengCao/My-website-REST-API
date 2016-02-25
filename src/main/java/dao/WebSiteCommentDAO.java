package dao;

import api.WebSiteComment;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.WebSiteCommentPOJO;

import java.util.Date;

/**
 * Created by alvin on 2/24/16.
 */
public class WebSiteCommentDAO {

    public void getAll(int id){

    }

    //has test case
    public void addComment(String email, String comment){
        Session ss = HibernateUtils.getSession();
        ss.beginTransaction();
        WebSiteCommentPOJO webSiteCommentPOJO = new WebSiteCommentPOJO(email, comment);
        ss.save(webSiteCommentPOJO);
        ss.getTransaction().commit();
    }

    //has test case
    public int getSize(){
        Session ss = HibernateUtils.getSession();
        ss.beginTransaction();
        int count = ((Long) ss.createQuery("select count(*) from WebSiteCommentPOJO").uniqueResult()).intValue();
        ss.getTransaction().commit();
        return count;
    }

    //has test case
    public WebSiteComment getSingle(int id) {
        Session ss = HibernateUtils.getSession();
        ss.beginTransaction();
        WebSiteCommentPOJO w = ss.get(WebSiteCommentPOJO.class,id);
        ss.getTransaction().commit();

        return new WebSiteComment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
    }

    //has test case
    public WebSiteComment getLast(){
        Session ss = HibernateUtils.getSession();
        ss.beginTransaction();
        WebSiteCommentPOJO w = (WebSiteCommentPOJO) ss.createQuery("from WebSiteCommentPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        return new WebSiteComment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
    }

    public WebSiteComment deleteLast(){

        return null;
    }

    //has test case
    public void deleteComment(int id){
        Session ss = HibernateUtils.getSession();
        ss.beginTransaction();
        WebSiteCommentPOJO w = ss.get(WebSiteCommentPOJO.class,id);
        Query query = ss.createQuery("delete from WebSiteCommentPOJO where id= :id");
        query.setInteger("id", id);
        ss.getTransaction().commit();
    }

    //has test case
    public WebSiteComment update(int id, String email, String comment){
        Session ss = HibernateUtils.getSession();
        ss.beginTransaction();
        WebSiteCommentPOJO w = ss.get(WebSiteCommentPOJO.class,id);
        w.setEmail(email);
        w.setComment(comment);
        w.setDate(new Date());
        ss.save(w);
        ss.getTransaction().commit();
        return new WebSiteComment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
    }
}
