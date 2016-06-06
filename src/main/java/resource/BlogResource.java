package resource;

import api.Blog;
import logic.BlogLogic;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by alvin on 2/26/16.
 */
@Path("/blogs")
@Produces(MediaType.APPLICATION_JSON)
public class BlogResource {
    private static final BlogResource blogResource = new BlogResource();
    private static BlogLogic bl = BlogLogic.getInstance();

    private BlogResource() {}

    @GET
    @Path("/{id}")
    public Blog get(@PathParam("id") int id){
        return bl.getSingle(id);
    }

    @GET
    public List<Blog> getAll(){
        return bl.getAll();
    }

    @POST
    public Response post(@QueryParam("title") String title,
                     @QueryParam("url") String url,
                     @QueryParam("description") String description){
        bl.post(title, url, description);
        return Response.status(Response.Status.OK).build();
    }

    public static BlogResource getInstance(){
        return blogResource;
    }
    public static BlogResource getInstance(BlogLogic bl1){
        bl = bl1;
        return blogResource;
    }

}
