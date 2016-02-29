package resource;

import api.Status;
import dao.StatusDAO;
import pojo.POJOs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by alvin on 2/26/16.
 */
@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
public class StatusResource {
    private StatusDAO statusDAO;
    public StatusResource( ) {
        statusDAO = new StatusDAO( );
    }

    @GET
    @Path("/{id}")
    public Status get(@PathParam("id") int id){
        return statusDAO.getSingle(id);
    }

    @GET
    public List getAll( ){
        return statusDAO.getAll(POJOs.StatusPOJO.toString());
    }

    @POST
    public Status post(@QueryParam("content") String content){
        statusDAO.addStatus(content);
        return statusDAO.getLast( );
    }

    @PUT
    @Path("/{id}")
    public Status put(@PathParam("id") int id, @QueryParam("content") String content){
        return statusDAO.update(id, content);
    }

    @DELETE
    @Path("/{id}")
    public Response delete (@PathParam("id") int id){
        statusDAO.delete(id, POJOs.StatusPOJO.toString());
        return Response.status(200).build();
    }

    @DELETE
    @Path("/last")
    public Response deleteLast( ){
        statusDAO.deleteLast();
        return Response.status(200).build();
    }
}
