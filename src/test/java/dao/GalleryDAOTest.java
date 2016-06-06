package dao;


import org.junit.*;
import pojo.GalleryPOJO;
import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 6/6/16.
 */
public class GalleryDAOTest {
    private final GalleryDAO dao = GalleryDAO.getInstance();
    static GalleryPOJO example1;
    static GalleryPOJO example2;

    @BeforeClass
    public static void setUp(){
        example1 = new GalleryPOJO.Builder("title1", new Date())
                .description("description1").num(1).url1("url11").build();
        example2 = new GalleryPOJO.Builder("title2", new Date())
                .description("description2").num(2).url1("url12").build();
    }

    @Test
    public void testAdd() throws Exception {
        int size1 = dao.getSize();
        dao.add(example1);
        int size2 = dao.getSize();
        GalleryPOJO gp = dao.getLast();
        Assert.assertEquals(size2 - size1, 1);
        Assert.assertEquals(gp, example1);
        dao.deleteLast();
    }

    @Test
    public void testGetLast() throws Exception {
        //same as testAdd();
    }

    @Test
    public void testDeleteLast() throws Exception {
        int size1 = dao.getSize();
        dao.add(example1);
        dao.add(example2);
        dao.deleteLast();
        int size2 = dao.getSize();
        Assert.assertEquals(1, size2 - size1);
        GalleryPOJO gp = dao.getLast();
        dao.deleteLast();
        Assert.assertEquals(gp, example1);
        int size3 = dao.getSize();
        Assert.assertEquals(size1, size3);
    }

    @Test
    public void testGetAll() throws Exception {
        List<GalleryPOJO> list = dao.getAll();
        int size = dao.getSize();
        Assert.assertEquals(list.size(), size);
        Assert.assertEquals(list.get(list.size() - 1),
                dao.getLast());
    }

    @Test
    public void testGetSize() throws Exception {
        //same as testAdd();
    }

    @Test
    public void testGetSingle() throws Exception {
        dao.add(example1);
        int id = dao.getLast().getId();
        GalleryPOJO b = dao.getSingle(id);
        Assert.assertNotNull(b);
        Assert.assertEquals(b, example1);
        dao.deleteLast();
    }

    @Test
    public void testGetInstance() throws Exception {
        GalleryDAO dao1 =GalleryDAO.getInstance();
        Assert.assertEquals(dao1, dao);
    }
}
