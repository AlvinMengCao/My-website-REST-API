package resource;

import api.Gallery;
import logic.GalleryLogic;
import logic.PhotoLogic;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by alvin on 6/5/16.
 */
@Path("/photos")
@Produces(MediaType.APPLICATION_JSON)
public class PhotoResource {
    private static final PhotoResource pr = new PhotoResource();
    private static PhotoLogic pl = PhotoLogic.getInstance();
    private static GalleryLogic gl = GalleryLogic.getInstance();
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

    @GET
    @Path("/folders")
    public List<String> getRootFolder () throws Exception{
        return pl.getRootFolder();
    }

    @GET
    @Path("/gallery")
    public List<Gallery> getGallery() {
        return gl.getAll();
    }

    @POST
    @Path("/gallery")
    public Response post(@QueryParam("title") String title, @QueryParam("description") String description,
                         @QueryParam("category") String category){
        gl.post(title, description, category);
        return Response.status(Response.Status.OK).build();
    }

    public static PhotoResource getInstance(){
        return pr;
    }
    public static PhotoResource getInstance(PhotoLogic pl1){
        pl = pl1;
        return pr;
    }

    /**
     * should only be used for mock test. Actually no other change
     * can this be used in runtime.
     */
    public static void setGl(GalleryLogic gl) {
        PhotoResource.gl = gl;
    }

}
