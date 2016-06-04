package dao;

import api.BlogComment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.POJOs;

import java.util.List;

/**
 * Created by alvin on 3/2/16.
 * 1.
 */
public class BlogCommentDAOTest {

    private BlogCommentDAO blogCommentDAO;
    private String tableName;

    @Before
    public void setUp() throws Exception{
        blogCommentDAO = BlogCommentDAO.getBlogCommentDAO();
        tableName = POJOs.BlogCommentPOJO.toString();
    }

    @Test
    public void testAddDelet(){
        int before = blogCommentDAO.getSize();
        blogCommentDAO.add("www.baidu.com", "nihao", "alvin");
        int after = blogCommentDAO.getSize();
        BlogComment blogComment = blogCommentDAO.getLast();
        Assert.assertEquals("nihao", blogComment.getComment());
        Assert.assertEquals(1, after - before);
        blogCommentDAO.deleteLast();
        int size = blogCommentDAO.getSize();
        Assert.assertEquals(before, size);
    }

    @Test
    public void getAll(){
        List list = blogCommentDAO.getAll();
        Assert.assertNotNull(list);
    }
}
