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
public class BlogDAO extends DAOBase{

    //has test case, won't pollute data
    public void addBlog(String title, String url, String tag1, String tag2, String tag3, String tag4,
    String tag5, String description){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        BlogPOJO blogPOJO = new BlogPOJO(title, url, new Date(), tag1, tag2,tag3, tag4, tag5, description );
        ss.save(blogPOJO);
        ss.getTransaction().commit();
    }

    //has test case, won't pollute data
    public Blog getSingle(int id) {
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        BlogPOJO b = ss.get(BlogPOJO.class,id);
        ss.getTransaction().commit();
        return new Blog(b.getId(), b.getTitle(), b.getUrl(), b.getDate(),
                b.getDescription(), b.getTag1(), b.getTag2(), b.getTag3(),
                b.getTag4(), b.getTag5());
    }

    //has test case, won't pollute data
    public Blog getLast(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        BlogPOJO b = (BlogPOJO) ss.createQuery("from BlogPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        return new Blog(b.getId(), b.getTitle(), b.getUrl(), b.getDate(),
                b.getDescription(), b.getTag1(), b.getTag2(), b.getTag3(),
                b.getTag4(), b.getTag5());
    }

}
