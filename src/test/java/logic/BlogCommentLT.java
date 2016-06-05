package logic;



import api.BlogComment;
import dao.BlogCommentDAO;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.BlogCommentPOJO;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by alvin on 6/5/16.
 */
public class BlogCommentLT {
    private static final BlogCommentDAO dao = mock(BlogCommentDAO.class);
    private final BlogCommentLogic bcl = BlogCommentLogic.getInstance(dao);
    private static List<BlogCommentPOJO> list1 = new ArrayList<BlogCommentPOJO>();
    @BeforeClass
    public static void setUp(){
        BlogCommentPOJO bcp = new BlogCommentPOJO.Builder("url1", "comment1", "name1", null).build();
        list1.add(bcp);
        when(dao.getAll()).thenReturn(list1);
    }
    @AfterClass
    public static void tearDown(){
        reset(dao);
    }

    @Test
    public void getAllTest(){
        List<BlogComment> list  = bcl.getAll();
        Assert.assertNotNull(list);
        BlogComment bc = list.get(0);
        boolean equals = bc.getUrl().equals("url1")
                && bc.getComment().equals("comment1")
                && bc.getName().equals("name1");
        Assert.assertTrue(equals);
        verify(dao, times(1)).getAll();
    }

    @Test
    public void postTest(){
        bcl.post("email", "comment", "name");
        verify(dao, times(1)).add(any(BlogCommentPOJO.class));
    }

    @Test
    public void getInstance(){
        BlogCommentLogic bcl1 = BlogCommentLogic.getInstance();
        BlogCommentLogic bcl2 = BlogCommentLogic.getInstance();
        Assert.assertEquals(bcl1, bcl2);
    }
}
