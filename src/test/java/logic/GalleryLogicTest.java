package logic;

import api.Gallery;
import dao.GalleryDAO;
import org.junit.*;
import pojo.GalleryPOJO;
import java.util.*;
import static org.mockito.Mockito.*;
/**
 * Created by alvin on 6/6/16.
 */
public class GalleryLogicTest {
    private static final GalleryDAO dao = mock(GalleryDAO.class);
    private final GalleryLogic gl = GalleryLogic.getInstance(dao);
    private static List<GalleryPOJO> list1 = new ArrayList<GalleryPOJO>();

    @BeforeClass
    public static void setUp(){
        GalleryPOJO bcp = new GalleryPOJO.Builder("title1", new Date()).url("url1").build();
        list1.add(bcp);
        when(dao.getAll()).thenReturn(list1);
    }
    @AfterClass
    public static void tearDown(){
        reset(dao);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Gallery> list  = gl.getAll();
        Assert.assertNotNull(list);
        Gallery bc = list.get(0);
        boolean equals = bc.getUrl().equals("url1")
                && bc.getTitle().equals("title1");
        Assert.assertTrue(equals);
        verify(dao, times(1)).getAll();
    }

    @Test
    public void testPost() throws Exception {
        gl.post("title1","description");
        verify(dao, times(1)).add(any(GalleryPOJO.class));
    }

    @Test
    public void testGetInstance() throws Exception {
        GalleryLogic gl1 = GalleryLogic.getInstance();
        Assert.assertEquals(gl1, gl);
    }
}
