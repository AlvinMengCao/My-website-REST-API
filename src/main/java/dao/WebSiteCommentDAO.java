package dao;

import api.WebSiteComment;
import org.hibernate.Session;
import pojo.WebSiteCommentPOJO;

/**
 * Created by alvin on 2/24/16.
 */
public class WebSiteCommentDAO {

    public void getComment(int id){

    }

    public void addComment(String email, String comment){
        Session ss = HibernateUtils.getSession();
        ss.beginTransaction();
        WebSiteCommentPOJO webSiteCommentPOJO = new WebSiteCommentPOJO(email, comment);
        ss.save(webSiteCommentPOJO);
        ss.getTransaction().commit();

    }

    public int getSize(){
        Session ss = HibernateUtils.getSession();
        ss.beginTransaction();
        int count = ((Long) ss.createQuery("select count(*) from WebSiteCommentPOJO").uniqueResult()).intValue();
        ss.getTransaction().commit();
        return count;


    }

    public WebSiteComment getSingle(int id) {
        Session ss = HibernateUtils.getSession();
        ss.beginTransaction();
        WebSiteCommentPOJO w = ss.get(WebSiteCommentPOJO.class,id);
        ss.getTransaction().commit();

        return new WebSiteComment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
    }

    public WebSiteComment getLast(){
        Session ss = HibernateUtils.getSession();
        ss.beginTransaction();
        WebSiteCommentPOJO w = (WebSiteCommentPOJO) ss.createQuery("from WebSiteCommentPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        return new WebSiteComment(w.getId(), w.getComment(), w.getEmail(), w.getDate());

    }
}
