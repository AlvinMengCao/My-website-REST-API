package logic;

import api.Blog;
import dao.BlogDAO;
import pojo.BlogPOJO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 6/5/16.
 */
public class BlogLogic {
    private static BlogLogic logic = new BlogLogic();
    private static BlogDAO dao = BlogDAO.getInstance();
    private BlogLogic(){}

    public List<Blog> getAll(){
        return convertList(dao.getAll());
    }
    public Blog getSingle(int id){
        return convert(dao.getSingle(id));
    }
    public void post(String title, String url, String description){
        BlogPOJO bp = new BlogPOJO.Builder(title, url, 1, new Date())
                .description(description).build();
        dao.add(bp);
        bp = null;
    }

    private List<Blog> convertList(List<BlogPOJO> list){
        List<Blog> result = new ArrayList<Blog>();
        for (BlogPOJO bp : list){
            Blog b = new Blog.Builder(bp.getId(), bp.getTitle(), bp.getUrl(),
                    bp.getDate(), bp.getPercentage()).tag1(bp.getTag1()).
                    tag2(bp.getTag2()).tag3(bp.getTag3()).tag4(bp.getTag4()).
                    tag5(bp.getTag5()).build();
            result.add(b);
            bp = null;
        }
        return result;
    }
    private Blog convert(BlogPOJO bp){
        Blog b = new Blog.Builder(bp.getId(), bp.getTitle(), bp.getUrl(),
                bp.getDate(), bp.getPercentage()).tag1(bp.getTag1()).
                tag2(bp.getTag2()).tag3(bp.getTag3()).tag4(bp.getTag4()).
                tag5(bp.getTag5()).build();
        bp = null;
        return b;
    }

    public static BlogLogic getInstance(){
        return logic;
    }
    public static BlogLogic getInstance(BlogDAO dao1){
        dao = dao1;
        return logic;
    }
}
