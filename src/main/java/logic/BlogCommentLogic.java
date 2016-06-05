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
    public static BlogCommentLogic logic = new BlogCommentLogic();
    private final BlogCommentDAO dao = BlogCommentDAO.getInstance();
    private BlogCommentLogic(){}

    public List<BlogComment> getAll(){
        return convert(dao.getAll());
    }
    public void post(String email, String comment, String name){
        String url = Gravatar.md5Hex(email);
        BlogCommentPOJO bp = new BlogCommentPOJO.Builder(url, comment, name, new Date()).build();
        dao.add(bp);
        bp = null;
    }

    private List<BlogComment> convert(List<BlogCommentPOJO> list){
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
}
