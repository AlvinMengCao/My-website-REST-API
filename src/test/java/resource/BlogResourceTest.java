package resource;

import api.Blog;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.testing.junit.ResourceTestRule;
import logic.BlogLogic;
import org.junit.*;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by alvin on 6/5/16.
 */
public class BlogResourceTest {
    private final ObjectMapper mapper = new ObjectMapper();
    private static final BlogLogic bl = mock(BlogLogic.class);
    private static final Blog b = new Blog.Builder(1, "title", "url", new Date(), 10).build();
    private static final List<Blog> list = new ArrayList<Blog>();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(BlogResource.getInstance(bl)).build();

    @BeforeClass
    public static void setUp(){
        list.add(b);
        when(bl.getAll()).thenReturn(list);
        when(bl.getSingle(10)).thenReturn(b);

    }
    @AfterClass
    public static void tearDown(){
        reset(bl);
    }

    @Test
    public void testGet() throws Exception {
        String expected = mapper.writeValueAsString(b);
        String actual = resources.client().target("/blogs/10")
                .request().get(String.class);
        Assert.assertEquals(actual, expected);
        verify(bl, times(1)).getSingle(10);
    }

    @Test
    public void testGetAll() throws Exception {
        String expected = mapper.writeValueAsString(list);
        String actual = resources.client().target("/blogs").request()
                .get(String.class);
        Assert.assertEquals(actual, expected);
        verify(bl, times(1)).getAll();
    }

    @Test
    public void testPost() throws Exception {
        Response response = resources.client().target("/blogs")
                .queryParam("title", "title")
                .queryParam("url","url")
                .queryParam("description", "description")
                .request().post(null);
        Assert.assertEquals(200, response.getStatus());
        verify(bl, times(1)).post(eq("title"), eq("url"), eq("description"));
    }

    @Test
    public void testGetInstance() throws Exception {
        BlogResource b1 = BlogResource.getInstance();
        BlogResource b2 = BlogResource.getInstance();
        Assert.assertEquals(b1, b2);
    }

}