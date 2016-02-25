package dao;

import api.WebSiteComment;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by alvin on 2/24/16.
 */
public class WebSiteCommentDAOTest {


    private WebSiteCommentDAO webSiteCommentDAO;
    private Gson gson;

    @Before
    public void setUp() throws Exception {
        webSiteCommentDAO = new WebSiteCommentDAO();
        gson = new Gson();
    }

   /* @Test
    public void testGetComment() throws Exception {

    }*/

    @Test
    public void testAddComment() throws Exception {
        int before = webSiteCommentDAO.getSize();
        webSiteCommentDAO.addComment("new","tes!!!!!!!t");
        int after = webSiteCommentDAO.getSize();
        Assert.assertNotNull(before);
        Assert.assertEquals(1,after-before);

    }

    @Test
    public void testGetSize() throws Exception {
        int before = webSiteCommentDAO.getSize();
        webSiteCommentDAO.addComment("test","test");
        int after = webSiteCommentDAO.getSize();
        Assert.assertNotNull(before);
        Assert.assertEquals(after-before,1);
    }

    @Test
    public void testGetSingle() throws Exception {
        WebSiteComment w = webSiteCommentDAO.getSingle(1);
        Assert.assertNotNull(w);
        System.out.println(gson.toJson(w));
    }

    @Test
    public void testGetLast() throws Exception {
        WebSiteComment w = webSiteCommentDAO.getLast();
        Assert.assertNotNull(w);
        System.out.println(gson.toJson(w));
    }

    @Test
    public void testUpdate() throws Exception {
        WebSiteComment w = webSiteCommentDAO.update(1, "new email", "new comment");
        Assert.assertNotNull(w);
        Assert.assertTrue("new email".equals(w.getEmail()));
        Assert.assertTrue("new comment".equals(w.getComment()));
    }

    @After
    public void tearDown(){
        webSiteCommentDAO = null;
        gson = null;
    }

    @Test
    public void testDeleteComment() throws Exception {
        int before = webSiteCommentDAO.getSize();
        webSiteCommentDAO.deleteComment(24);
        int after = webSiteCommentDAO.getSize();
        WebSiteComment n = webSiteCommentDAO.getSingle(1);
        //Assert.assertNull(n);
        //Assert.assertEquals(1, before - after);
    }
}