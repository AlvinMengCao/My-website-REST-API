package resource;


import api.WebSiteComment;
import dao.WebSiteCommentDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/website-comment")
@Produces(MediaType.APPLICATION_JSON)
public class WebSiteResource {

    public WebSiteResource() {
    }

    @GET
    @Path("/comment")
    public WebSiteComment getComment(){
        WebSiteCommentDAO webSiteCommentDAO = new WebSiteCommentDAO();
        return webSiteCommentDAO.getSingle(1);
    }

    @GET
    @Path("/comments")
    public WebSiteComment getComments(){
        WebSiteCommentDAO webSiteCommentDAO = new WebSiteCommentDAO();
        return webSiteCommentDAO.getSingle(2);
    }

    @POST
    @Path("/comment")
    public WebSiteComment putComment(@QueryParam("email") String email, @QueryParam("comment") String comment){
        WebSiteCommentDAO webSiteCommentDAO = new WebSiteCommentDAO();
        webSiteCommentDAO.addComment(email,comment);
        System.out.println(123);
        return webSiteCommentDAO.getLast();
    }



}
