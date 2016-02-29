package resource;


import api.WebSiteComment;
import dao.WebsiteCommentDAO;
import pojo.POJOs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/website-comments")
@Produces(MediaType.APPLICATION_JSON)
public class WebSiteResource {

    private WebsiteCommentDAO websiteCommentDAO;
    public WebSiteResource() {
        websiteCommentDAO = new WebsiteCommentDAO();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public WebSiteComment getComment(@PathParam("id") int id){
        return websiteCommentDAO.getSingle(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getComments(){
        return websiteCommentDAO.getAll(POJOs.WebSiteCommentPOJO.toString());
    }

    @POST
    public WebSiteComment postComment(@QueryParam("email") String email,
                                      @QueryParam("comment") String comment){
        websiteCommentDAO.addComment(email,comment);
        return websiteCommentDAO.getLast();
    }

    @PUT
    @Path("/{id}")
    public WebSiteComment putComment(@PathParam("id") int id, @QueryParam("email") String email,
                                     @QueryParam("comment") String comment){
        return websiteCommentDAO.update(id,email,comment);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteComment(@PathParam("id") int id){
        websiteCommentDAO.delete(id, POJOs.WebSiteCommentPOJO.toString());
        return Response.status(200).build();
    }

    @DELETE
    @Path("/last")
    public Response deleteLast( ){
        websiteCommentDAO.deleteLast();
        return Response.status(200).build();
    }

}
