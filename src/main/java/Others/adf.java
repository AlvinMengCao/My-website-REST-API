package Others;

import com.google.gson.Gson;
import dao.WebSiteCommentDAO;
import pojo.WebSiteCommentPOJO;
import resource.WebSiteResource;

/**
 * Created by alvin on 2/24/16.
 */
public class adf {
    public static void main(String[] args){

        Gson gson = new Gson();
        WebSiteResource webSiteResource = new WebSiteResource();
        System.out.println(gson.toJson(webSiteResource.getComment()));
    }
}
