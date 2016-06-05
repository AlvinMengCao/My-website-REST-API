package resource;

import api.BlogComment;
import dao.BlogCommentDAO;
import logic.BlogCommentLogic;

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

    private BlogCommentResource(){}


    //获取所有评论内容
    @GET
    public List<BlogComment> getAll(){
        return BlogCommentLogic.getInstance().getAll();
    }

    @POST
    public Response post(@QueryParam("email") String email, @QueryParam("name") String name, @QueryParam("comment") String comment){
        BlogCommentLogic.getInstance().post(email, comment, name);
        return Response.status(Response.Status.CREATED).build();
    }

    public static BlogCommentResource getInstance(){
        return blogCommentResource;
    }
}
