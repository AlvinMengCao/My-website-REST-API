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
    private BlogDAO blogDAO;

    public BlogResource() {
        blogDAO = new BlogDAO();
    }

    @GET
    @Path("/{id}")
    public Blog get(@PathParam("id") int id){
        return blogDAO.getSingle(id);
    }

    @GET
    public List getAll(){
        return blogDAO.getAll(POJOs.BlogPOJO.toString());
    }


}
