package dao;

import api.Comment;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.CommentPOJO;

import java.util.Date;

/**
 * Created by alvin on 2/24/16.
 */
public class CommentDAO extends DAOBase{

    //has test case
    public void addComment(String email, String comment){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        CommentPOJO commentPOJO = new CommentPOJO(email, comment);
        ss.save(commentPOJO);
        ss.getTransaction().commit();
    }

    //has test case
    public void addCommentWithDate(String email, String comment, Date date){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        CommentPOJO commentPOJO = new CommentPOJO(email, comment);
        commentPOJO.setDate(date);
        ss.save(commentPOJO);
        ss.getTransaction().commit();

    }

    //has test case, don't need to recover data
    public Comment getSingle(int id) {
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        CommentPOJO w = ss.get(CommentPOJO.class,id);
        ss.getTransaction().commit();
        return new Comment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
    }

    //has test case, don't need to recover data
    public Comment getLast(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        CommentPOJO w = (CommentPOJO) ss.createQuery("from CommentPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        return new Comment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
    }

    //has test case
    public Comment update(int id, String email, String comment){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        CommentPOJO w = ss.get(CommentPOJO.class,id);
        w.setEmail(email);
        w.setComment(comment);
        w.setDate(new Date());
        ss.save(w);
        ss.getTransaction().commit();
        return new Comment(w.getId(), w.getComment(), w.getEmail(), w.getDate());
    }

    public void deleteLast(){
        CommentDAO commentDAO = new CommentDAO();
        int last = (int) commentDAO.getLast().getId();
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from CommentPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
    }


}
