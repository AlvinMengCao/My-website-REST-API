package dao;

import api.WebSiteComment;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.POJOs;

import java.util.List;

/**
 * Created by alvin on 2/24/16.
 */
public class WebsiteCommentDAOTest {


    private WebsiteCommentDAO websiteCommentDAO;
    private Gson gson;

    @Before
    public void setUp() throws Exception {
        websiteCommentDAO = new WebsiteCommentDAO();
        gson = new Gson();
    }


    @Test
    public void testAddComment() throws Exception {
        int before = websiteCommentDAO.getSize(POJOs.WebSiteCommentPOJO.toString());
        websiteCommentDAO.addComment("new", "tes!!!!!!!t");
        int after = websiteCommentDAO.getSize(POJOs.WebSiteCommentPOJO.toString());
        Assert.assertNotNull(before);
        Assert.assertEquals(1, after - before);
        websiteCommentDAO.deleteLast();
    }

    @Test
    public void testGetSingle() throws Exception {
        int last = (int) websiteCommentDAO.getLast().getId();
        WebSiteComment w = websiteCommentDAO.getSingle(last);
        Assert.assertNotNull(w);
        System.out.println(gson.toJson(w));
    }

    @Test
    public void testGetAll() throws Exception {
        List result = websiteCommentDAO.getAll(POJOs.WebSiteCommentPOJO.toString());
        for(Object w:result){
            System.out.println(gson.toJson(w));
        }
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdate() throws Exception {
        websiteCommentDAO.addComment("for test", "for test");
        int last = (int) websiteCommentDAO.getLast().getId();
        WebSiteComment w = websiteCommentDAO.update(last, "new email", "new comment");
        Assert.assertNotNull(w);
        Assert.assertTrue("new email".equals(w.getEmail()));
        Assert.assertTrue("new comment".equals(w.getComment()));
        websiteCommentDAO.deleteLast();
    }

    @Test
    public void testDeleteComment() throws Exception {
        websiteCommentDAO.addComment("for", "f");
        WebSiteComment w= websiteCommentDAO.getLast();
        websiteCommentDAO.delete((int)w.getId(), POJOs.WebSiteCommentPOJO.toString());
        int after = websiteCommentDAO.getSize(POJOs.WebSiteCommentPOJO.toString());
    }

    @After
    public void tearDown(){
        websiteCommentDAO = null;
        gson = null;
    }



}