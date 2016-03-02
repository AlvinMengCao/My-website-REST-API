package dao;

import api.Blog;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.POJOs;

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
        int before = blogDAO.getSize(POJOs.BlogPOJO.toString());
        List list = blogDAO.getAll(POJOs.BlogPOJO.toString());
        Assert.assertEquals(before, list.size());
        blogDAO.addBlog("for test", "for test", "1", "1", "1", "1", "1", "1");
        int after = blogDAO.getSize(POJOs.BlogPOJO.toString());
        Assert.assertEquals(1, after - before);
        Blog b1 = blogDAO.getLast();
        Assert.assertTrue("for test".equals(b1.getTitle()));
        Blog b2 = blogDAO.getSingle(b1.getId());
        Assert.assertEquals(b1.getId(), b2.getId());
        blogDAO.deleteLast();


    }

    @Test
    public void testUpdateDelete(){
        int before = blogDAO.getSize(POJOs.BlogPOJO.toString());
        blogDAO.addBlog("for test", "for test", "1", "1", "1", "1", "1", "1");
        int id = blogDAO.getLast().getId();
        blogDAO.delete(id, POJOs.BlogPOJO.toString());
        int after = blogDAO.getSize(POJOs.BlogPOJO.toString());
        Assert.assertEquals(before, after);
    }

    @After
    public void tearDown(){
        blogDAO = null;
    }
}
