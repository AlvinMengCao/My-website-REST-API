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
    public void post(String title, String description, String category){
        GalleryPOJO gp = new GalleryPOJO.Builder(title, new Date())
                .description(description).category(category).build();
        dao.add(gp);
        gp = null;
    }

    private List<Gallery> convertList(List<GalleryPOJO> all) {
        List<Gallery> result = new ArrayList<Gallery>();
        for (GalleryPOJO gp : all){
            Gallery g = new Gallery.Builder(gp.getId(), gp.getTitle(), gp.getDate()).url1(gp.getUrl1())
                    .url2(gp.getUrl2()).url3(gp.getUrl3()).url4(gp.getUrl4()).url5(gp.getUrl5())
                    .url6(gp.getUrl6()).url7(gp.getUrl7()).url8(gp.getUrl8()).url9(gp.getUrl9())
                    .category(gp.getCategory()).description(gp.getDescription()).num(gp.getNum()).build();
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
