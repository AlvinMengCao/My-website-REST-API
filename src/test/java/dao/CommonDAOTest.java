package dao;

import api.WebSiteComment;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by alvin on 2/24/16.
 */
public class CommonDAOTest {


    private CommonDAO commonDAO;
    private Gson gson;

    @Before
    public void setUp() throws Exception {
        commonDAO = new CommonDAO();
        gson = new Gson();
    }


    @Test
    public void testAddComment() throws Exception {
        int before = commonDAO.getSize();
        commonDAO.addComment("new", "tes!!!!!!!t");
        int after = commonDAO.getSize();
        Assert.assertNotNull(before);
        Assert.assertEquals(1, after - before);
    }

    @Test
    public void testGetSingle() throws Exception {
        int last = (int)commonDAO.getLast().getId();
        WebSiteComment w = commonDAO.getSingle(last);
        Assert.assertNotNull(w);
        System.out.println(gson.toJson(w));
    }

    @Test
    public void testGetAll() throws Exception {
        List result = commonDAO.getAll();
        for(Object w:result){
            System.out.println(gson.toJson(w));
        }
        Assert.assertNotNull(result);
    }

    @Test
    public void testUpdate() throws Exception {
        int last = (int)commonDAO.getLast().getId();
        WebSiteComment w = commonDAO.update(last, "new email", "new comment");
        Assert.assertNotNull(w);
        Assert.assertTrue("new email".equals(w.getEmail()));
        Assert.assertTrue("new comment".equals(w.getComment()));
    }

    @Test
    public void testDeleteComment() throws Exception {

        WebSiteComment w= commonDAO.getLast();
        commonDAO.deleteComment((int)w.getId());
        int after = commonDAO.getSize();
        commonDAO.addCommentWithDate(w.getEmail(),w.getComment(),w.getDate());


    }

    @After
    public void tearDown(){
        commonDAO = null;
        gson = null;
    }



}