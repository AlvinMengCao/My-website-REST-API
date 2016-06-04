package dao;

import api.BlogComment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.BlogCommentPOJO;
import pojo.POJOs;
import service.Gravatar;

import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 3/2/16.
 * 1. Singleton instance, use private static final field, factory method and private constructor
 * to achieve this.
 * 2. All methods are public APIs, use public modifier.
 * 3. Already null obsolete objects.
 */
public class BlogCommentDAO  {
    private static final BlogCommentDAO blogCommentDAO = new BlogCommentDAO();
    final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    private BlogCommentDAO(){

    }
    public BlogComment add(String email, String comment, String name){
        String url = Gravatar.md5Hex(email);
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        BlogCommentPOJO blogCommentPOJO = new BlogCommentPOJO.Builder(url, comment, name, new Date()).build();
        ss.save(blogCommentPOJO);
        ss.getTransaction().commit();
        BlogComment blogComment = new BlogComment(blogCommentPOJO.getId(),url, comment, blogCommentPOJO.getDate(), name);
        return blogComment;
    }

    public BlogComment getLast(){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        BlogCommentPOJO b = (BlogCommentPOJO) ss.createQuery("from BlogCommentPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        BlogComment blogComment = new BlogComment(b.getId(), b.getUrl(), b.getComment(), b.getDate(), b.getName());
        b = null;
        return blogComment;
    }

    public void deleteLast(){
        int last = blogCommentDAO.getLast().getId();
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from BlogCommentPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
    }
    public List getAll(){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        List list = ss.createQuery("from "+ POJOs.BlogCommentPOJO.toString() + " ORDER BY id desc").list();
        ss.getTransaction().commit();
        return list;
    }

    public final int getSize(){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        int count = ((Long) ss.createQuery("select count(*) from "+POJOs.BlogCommentPOJO.toString()).uniqueResult()).intValue();
        ss.getTransaction().commit();
        return count;
    }
    public static BlogCommentDAO getBlogCommentDAO(){
        return blogCommentDAO;
    }
}
