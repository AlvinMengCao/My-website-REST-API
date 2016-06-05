package resource;

import api.BlogComment;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.BlogCommentDAO;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
/**
 * Created by alvin on 6/2/16.
 */
public class BlogCommentResourceTest {
    private final ObjectMapper mapper = new ObjectMapper();
    private static final BlogCommentDAO dao = mock(BlogCommentDAO.class);
    private final BlogComment bc = new BlogComment(1, "url", "comment", new Date(), "name");
    private final List<BlogComment> list = new ArrayList<BlogComment>();

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new BlogCommentResource(dao)).build();

    @Before
    public void setUp(){
        list.add(bc);
        //when(dao.getAll()).thenReturn(list);
        //when(dao.add("url","comment","name")).thenReturn(bc);
    }

    @After
    public void tearDown(){
        reset(dao);
    }
    @Test
    public void getAll() throws Exception{
        String expected = mapper.writeValueAsString(list);
        String actual = resources.client().target("/blogcomments").request().get(String.class);

        System.out.println("Actual is " + actual);

        //assertThat(actual).isEqualTo(expected);
        verify(dao, times(1)).getAll();
    }
    @Test
    public void post() throws Exception{
        String expected = mapper.writeValueAsString(bc);
        Response response = resources.client().target("/blogcomments").request()
                .post(Entity.entity(bc, MediaType.APPLICATION_JSON_TYPE));
        System.out.println(response.getEntity());
        //String actual = mapper.writeValueAsString(response.getEntity());
        //System.out.println(expected);
       // System.out.println(actual);

        //verify(dao).add(anyString(), anyString(), anyString());
    }

}
