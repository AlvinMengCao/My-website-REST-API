package dao;

import api.Comment;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.POJOs;
import service.GsonInstance;

import java.util.List;

/**
 * Created by alvin on 2/24/16.
 * 1. Do not eliminate DAO & GsonInstance instances!!! They are singletons.
 */
public class CommentDAOTest {


    private CommentDAO commentDAO;
    private String tableName;
    private Gson gson;

    @Before
    public void setUp() throws Exception {
        commentDAO = CommentDAO.getCommentDAO();
        tableName = POJOs.CommentPOJO.toString();
        gson = GsonInstance.INSTANCE.getGson();
    }


    @Test
    public void testAddComment() throws Exception {
        int before = commentDAO.getSize(tableName);
        commentDAO.addComment("new", "tes!!!!!!!t");
        int after = commentDAO.getSize(tableName);
        Assert.assertNotNull(before);
        Assert.assertEquals(1, after - before);
        commentDAO.deleteLast();
    }

    @Test
    public void testGetSingle() throws Exception {
        int last = (int) commentDAO.getLast().getId();
        Comment w = commentDAO.getSingle(last);
        Assert.assertNotNull(w);
        System.out.println(gson.toJson(w));
    }

    @Test
    public void testGetAll() throws Exception {
        List result = commentDAO.getAll(tableName);
        for(Object w:result){
            System.out.println(gson.toJson(w));
        }
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdate() throws Exception {
        commentDAO.addComment("for test", "for test");
        int last = (int) commentDAO.getLast().getId();
        Comment w = commentDAO.update(last, "new email", "new comment");
        Assert.assertNotNull(w);
        Assert.assertTrue("new email".equals(w.getEmail()));
        Assert.assertTrue("new comment".equals(w.getComment()));
        commentDAO.deleteLast();
    }

    @Test
    public void testDeleteComment() throws Exception {
        commentDAO.addComment("for", "f");
        Comment w= commentDAO.getLast();
        commentDAO.delete((int)w.getId(), tableName);
        int after = commentDAO.getSize(tableName);
    }
}