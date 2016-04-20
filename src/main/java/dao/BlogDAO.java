package dao;

import api.Blog;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.BlogPOJO;

import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 2/26/16.
 * 1. Singleton instance, use private static final field, factory method and private constructor
 * to achieve this.
 * 2. Already null obsolete objects.
 *
 * Future work--------------------------------------------------------
 * 1.Use builder instead of constructor.
 */
public final class BlogDAO extends DAOBase{
    private static final BlogDAO blogDAO = new BlogDAO();
    private BlogDAO(){}

    public void addBlog(String title, String url, String tag1, String tag2, String tag3, String tag4,
    String tag5, String description){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        BlogPOJO blogPOJO = new BlogPOJO(title, url, new Date(), tag1, tag2,tag3, tag4, tag5, description );
        ss.save(blogPOJO);
        ss.getTransaction().commit();
        blogPOJO = null;
    }

    public Blog getSingle(int id) {
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        BlogPOJO b = ss.get(BlogPOJO.class,id);
        ss.getTransaction().commit();
        Blog blog = new Blog.Builder(b.getId(), b.getTitle(), b.getUrl(), b.getDate()).tag1(b.getTag1())
                .tag2(b.getTag2()).tag3(b.getTag3()).tag4(b.getTag4()).tag5(b.getTag5())
                .descriptin(b.getDescription()).build();
        b = null;
        return blog;
    }

    //has test case, won't pollute data
    //need to use builder to create object!!!!!!!!!!!!!!!!!!!!!
    public Blog getLast(){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        BlogPOJO b = (BlogPOJO) ss.createQuery("from BlogPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        Blog blog = new Blog.Builder(b.getId(), b.getTitle(), b.getUrl(), b.getDate()).tag1(b.getTag1())
                .tag2(b.getTag2()).tag3(b.getTag3()).tag4(b.getTag4()).tag5(b.getTag5())
                .descriptin(b.getDescription()).build();
        b = null;
        return blog;
    }


    public void deleteLast(){
        int last = blogDAO.getLast().getId();
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from BlogPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
        query = null;
    }
    public static BlogDAO getBlogDAO(){
        return blogDAO;
    }
}
