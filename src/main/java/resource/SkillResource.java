package resource;

import api.Skill;
import dao.SkillDAO;
import pojo.POJOs;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by alvin on 2/28/16.
 */
@Path("/skills")
@Produces(MediaType.APPLICATION_JSON)
public class SkillResource {
    private SkillDAO skillDAO;

    public SkillResource() {
        skillDAO = new SkillDAO();
    }

    @GET
    @Path("/{id}")
    public Skill get(@PathParam("id") int id){
        return skillDAO.getSingle(id);
    }

    @GET
    public List getAll(){
        return skillDAO.getAll(POJOs.SkillPOJO.toString());
    }

    @POST
    public Skill post(@QueryParam("title") String title, @PathParam("content") String content){
        skillDAO.addSkill(title, content);
        return skillDAO.getLast();
    }

    @PUT
    @Path("/{id}")
    public Skill put(@PathParam("id") int id, @QueryParam("title") String title, @QueryParam("content") String content){
        return skillDAO.update(id, title, content);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id){
        skillDAO.delete(id, POJOs.SkillPOJO.toString());
        return Response.status(200).build();
    }

    @DELETE
    @Path("/last")
    public Response deleteLast(){
        skillDAO.deleteLast();
        return Response.status(200).build();
    }
}
