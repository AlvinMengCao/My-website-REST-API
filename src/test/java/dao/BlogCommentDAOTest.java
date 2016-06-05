package dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.BlogCommentPOJO;

import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 3/2/16.
 * 1.
 */
public class BlogCommentDAOTest {
    private final BlogCommentDAO dao = BlogCommentDAO.getInstance();
    static  BlogCommentPOJO example1;
    static  BlogCommentPOJO example2;
    @BeforeClass
    public static void setUp(){
        example1 = new BlogCommentPOJO.Builder("url1",
                "comment1", "name1", new Date()).build();
        example2 = new BlogCommentPOJO.Builder("url2",
                "comment2", "name2", new Date()).build();
    }

    @Test
    public void addTest(){
        dao.add(example1);
        BlogCommentPOJO last = dao.getLast();
        Assert.assertTrue(example1.equals(last));
        dao.deleteLast();
    }

    @Test
    public void getLastTest(){
        addTest();
    }

    @Test
    public void deleteLastTest(){
        int size1 = dao.getSize();
        dao.add(example1);
        dao.add(example2);
        dao.deleteLast();
        int size2 = dao.getSize();
        Assert.assertEquals(size2 - size1, 1);
        BlogCommentPOJO b = dao.getLast();
        Assert.assertEquals(b, example1);
        dao.deleteLast();
        int size3 = dao.getSize();
        Assert.assertEquals(size1, size3);
    }

    @Test
    public void getAllTest(){
        List<BlogCommentPOJO> list = dao.getAll();
        int size = dao.getSize();
        Assert.assertEquals(list.size(), size);
        BlogCommentPOJO b = dao.getLast();
        BlogCommentPOJO last = list.get(list.size() - 1);
        Assert.assertNotEquals(b, last);
        Assert.assertTrue(b.getId() > last.getId());
    }

    @Test
    public void getSizeTest(){
        int size1 = dao.getSize();
        dao.add(example1);
        int size2 = dao.getSize();
        dao.deleteLast();
        int size3 = dao.getSize();
        Assert.assertEquals(size1, size3);
        Assert.assertEquals(size2 - size1, 1);
    }

    @Test
    public void getSingle(){
        dao.add(example1);
        int id = dao.getLast().getId();
        Assert.assertTrue(id != 0);
        BlogCommentPOJO b = dao.getSingle(id);
        Assert.assertEquals(b, example1);
        dao.deleteLast();
    }

    @Test
    public void getBlogCommentDAOTest(){
        BlogCommentDAO dao1 =BlogCommentDAO.getInstance();
        Assert.assertEquals(dao1, dao);
    }
}
