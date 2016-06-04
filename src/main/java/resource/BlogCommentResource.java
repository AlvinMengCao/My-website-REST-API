package resource;

import api.BlogComment;
import dao.BlogCommentDAO;
import pojo.POJOs;
import service.Gravatar;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by alvin on 3/2/16.
 */
@Path("/blogcomments")
@Produces(MediaType.APPLICATION_JSON)
public class BlogCommentResource {

    private static final BlogCommentResource blogCommentResource = new BlogCommentResource();
    private BlogCommentDAO blogCommentDAO = BlogCommentDAO.getBlogCommentDAO();

    //为了测试resource能够注入mock的dao
    public BlogCommentResource(BlogCommentDAO b){
        this.blogCommentDAO = b;
    }
    private BlogCommentResource(){}


    //获取所有评论内容
    @GET
    public List getAll(){
        return blogCommentDAO.getAll();
    }

    @POST
    public Response post(@QueryParam("email") String email, @QueryParam("name") String name, @QueryParam("comment") String comment){
        BlogComment bc = blogCommentDAO.add(email, comment, name);
        return Response.status(Response.Status.CREATED).entity(bc).build();
    }

    public static BlogCommentResource getInstance(){
        return blogCommentResource;
    }
}
