package resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.testing.junit.ResourceTestRule;
import logic.PhotoLogic;
import org.junit.*;
import java.util.*;
import static org.mockito.Mockito.*;
/**
 * Created by alvin on 6/5/16.
 */
public class PhotoResourceTest {
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final PhotoLogic pl = mock(PhotoLogic.class);
    private static final List<String> list = new ArrayList<String>();
    private static String expected;
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(PhotoResource.getInstance(pl)).build();
    @BeforeClass
    public static void setUp() throws Exception{
        list.add("first_url");
        list.add("second_url");
        expected = mapper.writeValueAsString(list);
        when(pl.getAll()).thenReturn(list);
        when(pl.getByTag(anyString())).thenReturn(list);
        when(pl.getByPath(anyString())).thenReturn(list);
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
}
