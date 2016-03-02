package dao;

import api.BlogComment;
import org.junit.Assert;
import org.junit.Test;
import pojo.POJOs;

/**
 * Created by alvin on 3/2/16.
 */
public class BlogCommentDAOTest {
    @Test
    public void testAddDelet(){
        BlogCommentDAO blogCommentDAO = new BlogCommentDAO();
        int before = blogCommentDAO.getSize(POJOs.BlogCommentPOJO.toString());
        blogCommentDAO.add("www.baidu.com", "nihao", "alvin");
        int after = blogCommentDAO.getSize(POJOs.BlogCommentPOJO.toString());
        BlogComment blogComment = blogCommentDAO.getLast();
        Assert.assertEquals("nihao", blogComment.getComment());
        Assert.assertEquals(1, after - before);
        blogCommentDAO.deleteLast();
        int size = blogCommentDAO.getSize(POJOs.BlogCommentPOJO.toString());
        Assert.assertEquals(before, size);
    }
}
