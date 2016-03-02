package dao;

import api.BlogComment;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.BlogCommentPOJO;
import pojo.POJOs;
import pojo.SkillPOJO;

import java.util.List;

/**
 * Created by alvin on 3/2/16.
 */
public class BlogCommentDAO extends DAOBase{
    public void add(String url, String comment, String name){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        BlogCommentPOJO blogCommentPOJO = new BlogCommentPOJO(name, comment, url);
        ss.save(blogCommentPOJO);
        ss.getTransaction().commit();
    }

    public BlogComment getLast(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        BlogCommentPOJO b = (BlogCommentPOJO) ss.createQuery("from BlogCommentPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        return new BlogComment(b.getId(), b.getUrl(), b.getComment(), b.getDate(), b.getName());
    }

    public void deleteLast(){
        BlogCommentDAO blogCommentDAO = new BlogCommentDAO();
        int last = blogCommentDAO.getLast().getId();
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from BlogCommentPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
    }
}
