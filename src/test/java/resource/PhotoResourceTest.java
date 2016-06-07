package resource;

import api.Gallery;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.testing.junit.ResourceTestRule;
import logic.GalleryLogic;
import logic.PhotoLogic;
import org.junit.*;

import javax.ws.rs.core.Response;
import java.util.*;
import static org.mockito.Mockito.*;
/**
 * Created by alvin on 6/5/16.
 */
public class PhotoResourceTest {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final PhotoLogic pl = mock(PhotoLogic.class);
    private static final GalleryLogic gl = mock(GalleryLogic.class);
    private static final List<String> list = new ArrayList<String>();
    private static final List<Gallery> listg = new ArrayList<Gallery>();
    private static String expected;
    private static PhotoResource pr = PhotoResource.getInstance(pl);
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(pr).build();
    @BeforeClass
    public static void setUp() throws Exception{
        pr.setGl(gl);

        list.add("first_url");
        list.add("second_url");
        expected = mapper.writeValueAsString(list);
        when(pl.getAll()).thenReturn(list);
        when(pl.getByTag(anyString())).thenReturn(list);
        when(pl.getByPath(anyString())).thenReturn(list);
        when(pl.getRootFolder()).thenReturn(list);

        Gallery g1 = new Gallery.Builder(1, "title1", new Date()).build();
        Gallery g2 = new Gallery.Builder(2, "title2", new Date()).build();
        listg.add(g1);
        listg.add(g2);
        when(gl.getAll()).thenReturn(listg);
    }
    @AfterClass
    public static void tearDown() {
        reset(pl);
    }


    @Test
    public void getAllTest() throws Exception{
        String actual = resources.client().target("/photos").request().get(String.class);
        Assert.assertEquals(actual, expected);
        verify(pl, times(1)).getAll();
    }
    @Test
    public void getByTag() throws Exception{
        String actual = resources.client().target("/photos/tag/ttt").request().get(String.class);
        Assert.assertEquals(actual, expected);
        verify(pl, times(1)).getByTag(eq("ttt"));
    }
    @Test
    public void getByPath() throws Exception{
        String actual = resources.client().target("/photos/path/ppp").request().get(String.class);
        Assert.assertEquals(actual, expected);
        verify(pl, times(1)).getByPath(eq("ppp"));
    }
    @Test
    public void getRootFolder() throws Exception{
        String actual = resources.client().target("/photos/folders").request().get(String.class);
        Assert.assertEquals(actual, expected);
        verify(pl, times(1)).getRootFolder();
    }
    @Test
    public void getGalleryTest() throws Exception{

        String expected = mapper.writeValueAsString(listg);
        String actual = resources.client().target("/photos/gallery").request().get(String.class);
        Assert.assertEquals(actual, expected);
        verify(gl, times(1)).getAll();
    }
    @Test
    public void postGalleryTest(){
        Response response = resources.client().target("/photos/gallery")
                .queryParam("title", "title")
                .queryParam("description","description")
                .queryParam("category","category")
                .request().post(null);
        Assert.assertEquals(200, response.getStatus());
        verify(gl, times(1)).post(eq("title"), eq("description"), eq("category"));
    }

}
