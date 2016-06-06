package logic;

import api.Gallery;
import dao.BlogCommentDAO;
import dao.GalleryDAO;
import pojo.GalleryPOJO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 6/6/16.
 */
public class GalleryLogic {
    private static GalleryLogic logic = new GalleryLogic();
    private static GalleryDAO dao = GalleryDAO.getInstance();
    private GalleryLogic(){}

    public List<Gallery> getAll(){
        return convertList(dao.getAll());
    }
    public void post(String title, String description){
        GalleryPOJO gp = new GalleryPOJO.Builder(title, new Date())
                .description(description).build();
        dao.add(gp);
        gp = null;
    }

    private List<Gallery> convertList(List<GalleryPOJO> all) {
        List<Gallery> result = new ArrayList<Gallery>();
        for (GalleryPOJO gp : all){
            Gallery g = new Gallery(gp.getId(), gp.getTitle(), gp.getUrl()
            , gp.getDate(), gp.getDescription(), gp.getNum());
            result.add(g);
            gp = null;
        }
        return result;
    }
    public static  GalleryLogic getInstance(){
        return logic;
    }

    /**
     * Should only be used while mock testing
     * @param dao1 The mocked dao
     * @return Singleton instance
     */
    public static GalleryLogic getInstance(GalleryDAO dao1){
        dao = dao1;
        return logic;
    }

}
