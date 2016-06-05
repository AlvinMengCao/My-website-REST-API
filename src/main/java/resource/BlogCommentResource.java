package resource;

import api.BlogComment;
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
    private static BlogCommentLogic bcl = BlogCommentLogic.getInstance();
    private BlogCommentResource(){}


    //获取所有评论内容
    @GET
    public List<BlogComment> getAll(){
        return bcl.getAll();
    }

    @POST
    public Response post(@QueryParam("email") String email, @QueryParam("name") String name, @QueryParam("comment") String comment){
        bcl.post(email, comment, name);
        System.out.println(email + "  " + name + " "+ comment);
        return Response.status(Response.Status.OK).build();
    }

    public static BlogCommentResource getInstance(){
        return blogCommentResource;
    }
    public static BlogCommentResource getInstance(BlogCommentLogic b){
        bcl = b;
        return blogCommentResource;
    }
}
