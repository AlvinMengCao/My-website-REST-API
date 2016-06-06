package resource;

import api.BlogComment;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.testing.junit.ResourceTestRule;
import logic.BlogCommentLogic;
import org.junit.*;
import javax.ws.rs.core.Response;
import java.util.*;

import static org.mockito.Mockito.*;
/**
 * Created by alvin on 6/2/16.
 */
public class BlogCommentResourceTest {
    private final ObjectMapper mapper = new ObjectMapper();
    private static final BlogCommentLogic bcl = mock(BlogCommentLogic.class);
    private static final BlogComment bc = new BlogComment(1, "url", "comment", new Date(), "name");
    private static final List<BlogComment> list = new ArrayList<BlogComment>();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(BlogCommentResource.getInstance(bcl)).build();


    @BeforeClass
    public static void setUp(){
        list.add(bc);
        when(bcl.getAll()).thenReturn(list);
    }

    @AfterClass
    public static void tearDown(){
        reset(bcl);
    }

    @Test
    public void getAll() throws Exception{
        String expected = mapper.writeValueAsString(list);
        String actual = resources.client().target("/blogcomments").request().get(String.class);
        Assert.assertEquals(actual, expected);
        verify(bcl, times(1)).getAll();
    }

    @Test
    public void post() {

        Response response = resources.client().target("/blogcomments")
                .queryParam("email", "email")
                .queryParam("name","name")
                .queryParam("comment", "comment")
                .request().post(null);
        Assert.assertEquals(200, response.getStatus());
        verify(bcl, times(1)).post(eq("email"), eq("comment"), eq("name"));
    }

    @Test
    public void getInstance(){
        BlogCommentResource b1 = BlogCommentResource.getInstance();
        BlogCommentResource b2 = BlogCommentResource.getInstance();
        Assert.assertEquals(b1, b2);
    }
}
