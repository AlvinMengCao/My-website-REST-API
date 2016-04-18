package resource;


import api.Comment;
import dao.CommentDAO;
import pojo.POJOs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/comments")
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

    private CommentDAO commentDAO;
    public CommentResource() {
        commentDAO = CommentDAO.getCommentDAO();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment getComment(@PathParam("id") int id){
        return commentDAO.getSingle(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getComments(){
        return commentDAO.getAll(POJOs.CommentPOJO.toString());
    }

    @POST
    public Comment postComment(@FormParam("email") String email,
                               @FormParam("comment") String comment){
        commentDAO.addComment(email,comment);
        return commentDAO.getLast();
    }

    @PUT
    @Path("/{id}")
    public Comment putComment(@PathParam("id") int id, @QueryParam("email") String email,
                              @QueryParam("comment") String comment){
        return commentDAO.update(id,email,comment);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteComment(@PathParam("id") int id){
        commentDAO.delete(id, POJOs.CommentPOJO.toString());
        return Response.status(200).build();
    }

    @DELETE
    @Path("/last")
    public Response deleteLast( ){
        commentDAO.deleteLast();
        return Response.status(200).build();
    }

}
