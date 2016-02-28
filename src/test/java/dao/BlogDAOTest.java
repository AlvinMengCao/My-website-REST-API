package dao;

import api.Blog;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.POJO;

import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 2/26/16.
 */
public class BlogDAOTest {

    private BlogDAO blogDAO;
    private Gson gson;

    @Before
    public void setUp() throws Exception {
        blogDAO = new BlogDAO();
    }

    @Test
    public void testAddGet(){
        int before = blogDAO.getSize(POJO.BlogPOJO.toString());
        List list = blogDAO.getAll(POJO.BlogPOJO.toString());
        Assert.assertEquals(before, list.size());
        blogDAO.addBlog("add", "url");
        blogDAO.addBlogWithDate("adddd", "add", new Date());
        int after = blogDAO.getSize(POJO.BlogPOJO.toString());
        Assert.assertEquals(2, after - before);
        Blog b1 = blogDAO.getLast(POJO.BlogPOJO.toString());
        Assert.assertTrue("adddd".equals(b1.getTitle()));
        Blog b2 = blogDAO.getSingle(b1.getId());
        Assert.assertEquals(b1.getId(), b2.getId());
        blogDAO.deleteLast();
        blogDAO.deleteLast();
    }

    @Test
    public void testUpdateDelete(){
        int before = blogDAO.getSize(POJO.BlogPOJO.toString());
        blogDAO.addBlog("for test", "for test");
        int id = blogDAO.getLast(POJO.BlogPOJO.toString()).getId();
        Blog blog = blogDAO.update(id, "new", "new");
        Assert.assertTrue("new".equals(blog.getTitle()));
        blogDAO.delete(id, POJO.BlogPOJO.toString());
        int after = blogDAO.getSize(POJO.BlogPOJO.toString());
        Assert.assertEquals(before, after);
    }

    @After
    public void tearDown(){
        blogDAO = null;
    }
}
