package resource;


import api.WebSiteComment;
import dao.WebSiteCommentDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/website-comment")
@Produces(MediaType.APPLICATION_JSON)
public class WebSiteResource {

    /*private final  String template;
    private final String defaultName;
    private final AtomicLong counter;



    public WebSiteResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }*/

    public WebSiteResource() {
    }

    @GET
    public WebSiteComment getComment(){
        WebSiteCommentDAO webSiteCommentDAO = new WebSiteCommentDAO();
        return webSiteCommentDAO.getSingle(1);
    }




}
