package dao;

import api.BlogComment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.POJOs;

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
        int before = blogCommentDAO.getSize(tableName);
        blogCommentDAO.add("www.baidu.com", "nihao", "alvin");
        int after = blogCommentDAO.getSize(tableName);
        BlogComment blogComment = blogCommentDAO.getLast();
        Assert.assertEquals("nihao", blogComment.getComment());
        Assert.assertEquals(1, after - before);
        blogCommentDAO.deleteLast();
        int size = blogCommentDAO.getSize(tableName);
        Assert.assertEquals(before, size);
    }
}
