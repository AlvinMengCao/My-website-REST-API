package logic;

import api.Blog;
import dao.BlogDAO;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.BlogPOJO;
import java.util.*;
import static org.mockito.Mockito.*;
/**
 * Created by alvin on 6/5/16.
 */
public class BlogLogicTest {
    private static final BlogDAO dao = mock(BlogDAO.class);
    private final BlogLogic bl = BlogLogic.getInstance(dao);
    private static List<BlogPOJO> list1 = new ArrayList<BlogPOJO>();

    @BeforeClass
    public static void setUp(){
        BlogPOJO bp = new BlogPOJO.Builder("title", "url", 1, new Date()).build();
        bp.setId(10);
        list1.add(bp);
        when(dao.getAll()).thenReturn(list1);
        when(dao.getSingle(anyInt())).thenReturn(bp);
    }
    @AfterClass
    public static void tearDown(){
        reset(dao);
    }

    @Test
    public void getAllTest(){
        List<Blog> list = bl.getAll();
        Assert.assertNotNull(list);
        Blog b = list.get(0);
        boolean equals = b.getUrl().equals("url")
                && b.getTitle().equals("title")
                && b.getPercentage() == 1;
        Assert.assertTrue(equals);
        verify(dao, times(1)).getAll();
    }
    @Test
    public void getSingleTest(){
        Blog b = bl.getSingle(10);
        Assert.assertNotNull(b);
        Boolean equals = b.getUrl().equals("url")
                && b.getTitle().equals("title")
                && b.getPercentage() == 1
                && b.getId() == 10;
        Assert.assertTrue(equals);
        verify(dao, times(1)).getSingle(anyInt());
    }
    @Test
    public void postTest(){
        bl.post("title", "url", "description");
        verify(dao, times(1)).add(any(BlogPOJO.class));
    }
    @Test
    public void getInstanceTest(){
        BlogLogic bcl1 = BlogLogic.getInstance();
        BlogLogic bcl2 = BlogLogic.getInstance();
        Assert.assertEquals(bcl1, bcl2);
    }
}
