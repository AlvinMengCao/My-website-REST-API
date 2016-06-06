package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;

/**
 * Created by alvin on 6/2/16.
 */
public class BlogCommentTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    @Test
    public void deserializesFromJSON() throws Exception{
        final BlogComment bc = new BlogComment(1, "url", "comment", null, "name");
        /*assertThat(MAPPER.readValue(fixture("fixtures/blogcomment.json"), BlogComment.class))
                .isEqualTo(bc);*/
    }

    @Test
    public void serializesToJSON() throws Exception{
        final BlogComment bc = new BlogComment(1, "url", "comment", null, "name");
        final String expected = MAPPER.writeValueAsString(MAPPER.readValue(
                fixture("fixtures/blogcomment.json"), BlogComment.class));
        //assertThat(MAPPER.writeValueAsString(bc)).isEqualTo(expected);
    }
}
