package dao;

import api.Comment;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.CommentPOJO;

import java.util.Date;

/**
 * Created by alvin on 2/24/16.
 * 1. Singleton instance, use private static final field, factory method and private constructor
 * to achieve this.
 * 2. Already eliminate obsolete object references.
 *
 * Future work-------------------------------------------------------------
 * 1. use enum to achieve singleton(maybe, but not sure).
 */
public class CommentDAO extends DAOBase{
    private static final CommentDAO commentDAO = new CommentDAO();
    private CommentDAO(){}

    public void addComment(String email, String comment){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        CommentPOJO commentPOJO = new CommentPOJO(email, comment);
        ss.save(commentPOJO);
        ss.getTransaction().commit();
        commentPOJO = null;
    }

    public void addCommentWithDate(String email, String comment, Date date){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        CommentPOJO commentPOJO = new CommentPOJO(email, comment);
        commentPOJO.setDate(date);
        ss.save(commentPOJO);
        ss.getTransaction().commit();
        commentPOJO = null;
    }

    public Comment getSingle(int id) {
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        CommentPOJO w = ss.get(CommentPOJO.class,id);
        ss.getTransaction().commit();
        Comment comment = new Comment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
        w = null;
        return comment;
    }

    public Comment getLast(){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        CommentPOJO w = (CommentPOJO) ss.createQuery("from CommentPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        Comment comment = new Comment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
        w = null;
        return comment;
    }

    public Comment update(int id, String email, String comment){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        CommentPOJO w = ss.get(CommentPOJO.class,id);
        w.setEmail(email);
        w.setComment(comment);
        w.setDate(new Date());
        ss.save(w);
        ss.getTransaction().commit();
        Comment comment1 = new Comment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
        w = null;
        return comment1;
    }

    public void deleteLast(){
        int last = (int) commentDAO.getLast().getId();
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from CommentPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
        query = null;
    }

    public static CommentDAO getCommentDAO(){
        return commentDAO;
    }

}
