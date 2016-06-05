package dao;

import api.Blog;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pojo.BlogCommentPOJO;
import pojo.BlogPOJO;
import pojo.POJOs;

import java.util.Date;
import java.util.List;

/**
 * Created by alvin on 2/26/16.
 * 1. Singleton instance, use private static final field, factory method and private constructor
 * to achieve this.
 * 2. Already null obsolete objects.
 *
 * Future work--------------------------------------------------------
 * 1.Use builder instead of constructor.
 */
public class BlogDAO {
    private static final BlogDAO blogDAO = new BlogDAO();
    private final DAOBase daoBase = DAOBase.getInstance();
    private final String table = POJOs.BlogPOJO.toString();
    private BlogDAO(){}

    public void add(BlogPOJO b){
        daoBase.add(b);
    }

    public BlogPOJO getLast(){

        return (BlogPOJO)daoBase.getLast(table);
    }

    public void deleteLast(){
        int last = blogDAO.getLast().getId();
        daoBase.deleteLast(table, last);
    }

    /**
     *This cast is safe because the method in 'daoBase' must
     * return List<BlogPOJO> according to the passed in
     * table name.
     */
    @SuppressWarnings("unchecked")
    public List<BlogPOJO> getAll(){
        return (List<BlogPOJO>)daoBase.getAll(table);
    }

    public int getSize(){
        return daoBase.getSize(table);
    }

    public BlogPOJO getSingle(int id) {
        return (BlogPOJO)daoBase.getSingle(id, table);
    }

    public static BlogDAO getInstance(){
        return blogDAO;
    }
}
