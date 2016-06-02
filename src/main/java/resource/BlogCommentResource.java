package resource;

import dao.BlogCommentDAO;
import pojo.POJOs;
import service.Gravatar;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by alvin on 3/2/16.
 */
@Path("/blogcomments")
@Produces(MediaType.APPLICATION_JSON)
public class BlogCommentResource {
    private static final BlogCommentResource blogCommentResource = new BlogCommentResource();
    private BlogCommentDAO blogCommentDAO = BlogCommentDAO.getBlogCommentDAO();;

    private BlogCommentResource() {}


    //获取所有评论内容
    @GET
    public List getAll(){
        return blogCommentDAO.getAll(POJOs.BlogCommentPOJO.toString());
    }

    @POST
    public List post(@QueryParam("email") String email, @QueryParam("name") String name, @QueryParam("comment") String comment){
        String url = Gravatar.md5Hex(email);
        blogCommentDAO.add(url, comment, name);
        return blogCommentDAO.getAll(POJOs.BlogCommentPOJO.toString());
    }

    public static BlogCommentResource getInstance(){
        return blogCommentResource;
    }
}
