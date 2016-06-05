package logic;

import api.BlogComment;
import dao.BlogCommentDAO;
import pojo.BlogCommentPOJO;
import service.Gravatar;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 6/4/16.
 */
public class BlogCommentLogic {

    private static BlogCommentLogic logic = new BlogCommentLogic();
    private  static BlogCommentDAO dao = BlogCommentDAO.getInstance();
    private BlogCommentLogic(){}

    public List<BlogComment> getAll(){
        return convertList(dao.getAll());
    }
    public void post(String email, String comment, String name){
        String url = Gravatar.md5Hex(email);
        BlogCommentPOJO bp = new BlogCommentPOJO.Builder(url, comment, name, new Date()).build();
        dao.add(bp);
        bp = null;
    }
    private List<BlogComment> convertList(List<BlogCommentPOJO> list){
        List<BlogComment> result = new ArrayList<BlogComment>();
        for (BlogCommentPOJO bp : list){
            BlogComment b = new BlogComment(bp.getId(), bp.getUrl()
                    , bp.getComment(),bp.getDate(),bp.getName());
            result.add(b);
            bp = null;
        }
        return result;
    }

    public static  BlogCommentLogic getInstance(){
        return logic;
    }

    /**
     * Should only be used while mock testing
     * @param dao1 The mocked dao
     * @return Singleton instance
     */
    public static BlogCommentLogic getInstance(BlogCommentDAO dao1){
        dao = dao1;
        return logic;
    }
}
