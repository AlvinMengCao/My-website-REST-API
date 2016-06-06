package api;

import static io.dropwizard.testing.FixtureHelpers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;
/**
 * Created by alvin on 6/6/16.
 */
public class GalleryTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void deserializesFromJSON() throws Exception{
        final Gallery gallery = new Gallery(1, "title","url", null, "description", 2);
        //assertThat(MAPPER.readValue(fixture("fixtures/blog.json"), Blog.class))
        //.isEqualTo(blog);
    }
}
