package resource;

import api.Blog;
import dao.BlogDAO;
import pojo.POJOs;

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
    private BlogDAO blogDAO = BlogDAO.getBlogDAO();

    private BlogResource() {}

    @GET
    @Path("/{id}")
    public Blog get(@PathParam("id") int id){
        return blogDAO.getSingle(id);
    }

    @GET
    public List getAll(){
        return blogDAO.getAll(POJOs.BlogPOJO.toString());
    }

    public static BlogResource getInstance(){
        return blogResource;
    }

}
