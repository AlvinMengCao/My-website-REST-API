package resource;

import logic.PhotoLogic;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by alvin on 6/5/16.
 */
@Path("/photos")
@Produces(MediaType.APPLICATION_JSON)
public class PhotoResource {
    private static final PhotoResource pr = new PhotoResource();
    private static PhotoLogic pl = PhotoLogic.getInstance();
    private PhotoResource(){}

    @GET
    public List<String> getAll() throws Exception{
        return pl.getAll();
    }

    @GET
    @Path("/path/{path}")
    public List<String> getByPath(@PathParam("path") String path) throws Exception{
        return pl.getByPath(path);
    }

    @GET
    @Path("/tag/{tag}")
    public List<String> getByTag(@PathParam("tag") String tag) throws Exception{
        return pl.getByTag(tag);
    }

    public static PhotoResource getInstance(){
        return pr;
    }
    public static PhotoResource getInstance(PhotoLogic pl1){
        pl = pl1;
        return pr;
    }
}
