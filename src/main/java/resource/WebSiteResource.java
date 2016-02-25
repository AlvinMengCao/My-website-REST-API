package resource;


import api.WebSiteComment;
import dao.CommonDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/website-comment")
@Produces(MediaType.APPLICATION_JSON)
public class WebSiteResource {

    public WebSiteResource() {
    }

    @GET
    @Path("/comment{id}")
    public WebSiteComment getComment(@PathParam("id") int id){
        CommonDAO commonDAO = new CommonDAO();
        return commonDAO.getSingle(id);
    }

    @GET
    @Path("/comments")
    public WebSiteComment getComments(){
        CommonDAO commonDAO = new CommonDAO();
        return commonDAO.getSingle(2);
    }

    @POST
    @Path("/comment")
    public WebSiteComment postComment(@QueryParam("email") String email,
                                      @QueryParam("comment") String comment){
        CommonDAO commonDAO = new CommonDAO();
        commonDAO.addComment(email,comment);
        return commonDAO.getLast();
    }

    @PUT
    @Path("comment/{id}")
    public WebSiteComment putComment(@PathParam("id") int id, @QueryParam("email") String email,
                                     @QueryParam("comment") String comment){
        CommonDAO commonDAO = new CommonDAO();
        return commonDAO.update(id,email,comment);
    }

    @DELETE
    @Path("/comment/{id}")
    public Response deleteComment(@PathParam("id") int id){
        CommonDAO commonDAO = new CommonDAO();
        commonDAO.deleteComment(id);
        return Response.status(200).build();
    }



}
