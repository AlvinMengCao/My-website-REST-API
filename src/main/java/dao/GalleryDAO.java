package dao;

import api.Gallery;
import pojo.BlogPOJO;
import pojo.GalleryPOJO;
import pojo.POJOs;

import java.util.List;

/**
 * Created by alvin on 6/6/16.
 */
public class GalleryDAO {
    private static final GalleryDAO dao = new GalleryDAO();
    private final DAOBase daoBase = DAOBase.getInstance();
    private final String table = POJOs.GalleryPOJO.toString();
    private GalleryDAO(){}

    public void add(GalleryPOJO g){
        daoBase.add(g);
    }
    public GalleryPOJO getLast(){
        return (GalleryPOJO) daoBase.getLast(table);
    }
    public void deleteLast(){
        int last = dao.getLast().getId();
        daoBase.deleteLast(table, last);
    }

    /**
     * Safe cast! Data from this table can only be GalleryPOJO
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<GalleryPOJO> getAll(){
        return (List<GalleryPOJO>)daoBase.getAll(table);
    }
    public int getSize(){
        return daoBase.getSize(table);
    }
    public GalleryPOJO getSingle(int id){
        return (GalleryPOJO)daoBase.getSingle(id, table);
    }

    public static GalleryDAO getInstance(){
        return dao;
    }
}
