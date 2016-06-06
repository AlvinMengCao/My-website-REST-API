package dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pojo.BlogPOJO;

import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 6/4/16.
 */
public class BlogDAOTest {
    private final BlogDAO dao = BlogDAO.getInstance();
    static BlogPOJO example1;
    static BlogPOJO example2;
    @BeforeClass
    public static void setUp(){
        example1 = new BlogPOJO.Builder("title1,",
                "url1", 1, new Date()).build();
        example2 = new BlogPOJO.Builder("title2,",
                "url2", 2, new Date()).build();
    }

    @Test
    public void testAdd() {
        dao.add(example1);
        BlogPOJO last = dao.getLast();
        Assert.assertTrue(example1.equals(last));
        dao.deleteLast();
    }

    @Test
    public void testGetLast() {
        testAdd();
    }

    @Test
    public void testDeleteLast() {
        int size1 = dao.getSize();
        dao.add(example1);
        dao.add(example2);
        dao.deleteLast();
        int size2 = dao.getSize();
        Assert.assertEquals(1, size2 - size1);
        BlogPOJO b = dao.getLast();
        dao.deleteLast();
        int size3 = dao.getSize();
        Assert.assertEquals(b, example1);
        Assert.assertEquals(size1, size3);
    }

    @Test
    public void testGetAll() {
        List<BlogPOJO> list = dao.getAll();
        int size = dao.getSize();
        Assert.assertEquals(list.size(), size);
        BlogPOJO b = dao.getLast();
        BlogPOJO last = list.get(list.size() - 1);
        Assert.assertNotEquals(b, last);
        Assert.assertTrue(b.getId() > last.getId());
    }

    @Test
    public void testGetSize() {
        int size1 = dao.getSize();
        dao.add(example1);
        int size2 = dao.getSize();
        Assert.assertEquals(size2 - size1, 1);
        dao.deleteLast();
        int size3 = dao.getSize();
        Assert.assertEquals(size1, size3);
    }

    @Test
    public void testGetSingle() {
        dao.add(example1);
        int id = dao.getLast().getId();
        BlogPOJO b = dao.getSingle(id);
        Assert.assertNotNull(b);
        Assert.assertEquals(b, example1);
        dao.deleteLast();
    }

    @Test
    public void testGetInstance() {
        BlogDAO dao1 =BlogDAO.getInstance();
        Assert.assertEquals(dao1, dao);
    }

}
