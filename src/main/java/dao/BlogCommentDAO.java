package dao;

import org.hibernate.*;
import pojo.BlogCommentPOJO;;
import pojo.POJOs;
import java.util.List;

/**
 * Created by alvin on 3/2/16.
 * 1. Singleton instance, use private static final field, factory method and private constructor
 * to achieve this.
 * 2. All methods are public APIs, use public modifier.
 * 3. Already null obsolete objects.
 */
public class BlogCommentDAO  {
    private static final BlogCommentDAO blogCommentDAO = new BlogCommentDAO();
    private final DAOBase daoBase = DAOBase.getInstance();
    private final String table = POJOs.BlogCommentPOJO.toString();
    private BlogCommentDAO(){
    }

    public void add(BlogCommentPOJO b){
        daoBase.add(b);
    }

    public BlogCommentPOJO getLast(){

        return (BlogCommentPOJO)daoBase.getLast(table);
    }

    public void deleteLast(){
        int last = blogCommentDAO.getLast().getId();
        daoBase.deleteLast(table, last);
    }

    /**
     *This cast is safe because the method in 'daoBase' must
     * return List<BlogCommentPOJO> according to the passed in
     * table name.
     */
    @SuppressWarnings("unchecked")
    public List<BlogCommentPOJO> getAll(){
        return (List<BlogCommentPOJO>)daoBase.getAll(table);
    }

    public int getSize(){
        return daoBase.getSize(table);
    }

    public BlogCommentPOJO getSingle(int id) {
        return (BlogCommentPOJO)daoBase.getSingle(id, table);
    }

    public static BlogCommentDAO getInstance(){
        return blogCommentDAO;
    }
}
