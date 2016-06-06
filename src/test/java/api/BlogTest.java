package api;
import static io.dropwizard.testing.FixtureHelpers.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

/**
 * Created by alvin on 6/2/16.
 */
public class BlogTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void deserializesFromJSON() throws Exception{
        final Blog blog = new Blog.Builder(1, "title", "url", null, 20).tag1("tag1")
                .tag2("tag2").tag3("tag3").tag4("tag4").tag5("tag5").build();
        //assertThat(MAPPER.readValue(fixture("fixtures/blog.json"), Blog.class))
                //.isEqualTo(blog);
    }

    @Test
    public void serializesToJSON() throws Exception{
        final Blog blog = new Blog.Builder(1, "title", "url", null, 20).tag1("tag1")
                .tag2("tag2").tag3("tag3").tag4("tag4").tag5("tag5").descriptin("description").build();
        final String expected = MAPPER.writeValueAsString(MAPPER.readValue(
                fixture("fixtures/blog.json"), Blog.class));
        //assertThat(MAPPER.writeValueAsString(blog)).isEqualTo(expected);
    }
}
