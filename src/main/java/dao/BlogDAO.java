package dao;

import api.Blog;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.BlogPOJO;

import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 2/26/16.
 */
public class BlogDAO {

    //has test case, won't pollute data
    public void addBlog(String title, String url){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        BlogPOJO blogPOJO = new BlogPOJO(title, url);
        ss.save(blogPOJO);
        ss.getTransaction().commit();
    }

    //has test case, won't pollute data
    public void addBlogWithDate(String title, String url, Date date){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        BlogPOJO blogPOJO = new BlogPOJO(title, url);
        blogPOJO.setDate(date);
        ss.save(blogPOJO);
        ss.getTransaction().commit();
    }

    //has test case, won't pollute data
    public int getSize(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        int count = ((Long) ss.createQuery("select count(*) from BlogPOJO").uniqueResult()).intValue();
        ss.getTransaction().commit();
        return count;
    }

    //has test case, won't pollute data
    public Blog getSingle(int id) {
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        BlogPOJO b = ss.get(BlogPOJO.class,id);
        ss.getTransaction().commit();
        return new Blog(b.getId(), b.getTitle(), b.getUrl());
    }

    //has test case, won't pollute data
    public Blog getLast(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        BlogPOJO b = (BlogPOJO) ss.createQuery("from BlogPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        return new Blog(b.getId(), b.getTitle(), b.getUrl());
    }

    //has test case, won't pollute data
    public List getAll(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        List list = ss.createCriteria(BlogPOJO.class).list();
        ss.getTransaction().commit();
        return list;
    }

    //has test case, won't pollute data
    public Blog update(int id, String title, String url){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        BlogPOJO b = ss.get(BlogPOJO.class,id);
        b.setTitle(title);
        b.setUrl(url);
        b.setDate(new Date());
        ss.save(b);
        ss.getTransaction().commit();
        return new Blog(b.getId(), b.getTitle(), b.getUrl());
    }

    //has test case, won't pollute data
    public void delete(int id){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from BlogPOJO where id=?");
        query.setInteger(0, id);
        query.executeUpdate();
        ss.getTransaction().commit();
    }

    //has test case, won't pollute data
    public void deleteLast(){
        BlogDAO blogDAO = new BlogDAO();
        int last = blogDAO.getLast().getId();
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from BlogPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
    }


}
