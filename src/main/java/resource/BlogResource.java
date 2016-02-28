package resource;

import api.Blog;
import dao.BlogDAO;
import pojo.POJO;

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
        return blogDAO.getAll(POJO.BlogPOJO.toString());
    }

    @POST
    public Blog post(@QueryParam("title") String title, @PathParam("url") String url){
        blogDAO.addBlog(title, url);
        return blogDAO.getLast(POJO.BlogPOJO.toString());
    }

    @PUT
    @Path("/{id}")
    public Blog put(@PathParam("id") int id, @QueryParam("title") String title, @QueryParam("url") String url){
        return blogDAO.update(id, title, url);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id){
        blogDAO.delete(id, POJO.BlogPOJO.toString());
        return Response.status(200).build();
    }

    @DELETE
    @Path("/last")
    public Response deleteLast(){
        blogDAO.deleteLast();
        return Response.status(200).build();
    }
}
