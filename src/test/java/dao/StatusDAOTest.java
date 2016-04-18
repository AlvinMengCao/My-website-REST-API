package dao;

import api.Status;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.POJOs;
import service.Singletons;

import java.util.Date;

/**
 * Created by alvin on 2/25/16.
 * Edit by Alvin on 4/18/16
 * 1.Do not eliminate DAO & Gson instances!!! They are singletons.
 * 2.Already null obsolete objects.
 */
public class StatusDAOTest {

    private StatusDAO statusDAO;
    private Gson gson;
    private String tableName;

    @Before
    public void setUp() throws Exception {
        statusDAO = StatusDAO.getStatusDAO();
        gson = Singletons.getGson();
        tableName = POJOs.StatusPOJO.toString();
    }

    @Test
    public void testAddAddwithdateGetsize(){
        int before = statusDAO.getSize(tableName);
        statusDAO.addStatus("this is first");
        statusDAO.addStatusWithDate("this is second", new Date());
        int after = statusDAO.getSize(tableName);
        Assert.assertEquals(2, after - before);
        statusDAO.deleteLast();
        statusDAO.deleteLast();
    }

    @Test
    public void testGetDelete(){
        int before = statusDAO.getSize(tableName);
        statusDAO.addStatus("for test");
        Status s1 = statusDAO.getLast();
        Status s2 = statusDAO.getSingle(s1.getId());
        Assert.assertEquals(s1.getId(), s2.getId());
        statusDAO.deleteLast();
        int after = statusDAO.getSize(tableName);
        Assert.assertEquals(0, before - after);
    }

    @Test
    public void testDeleteLast(){
        Status status = statusDAO.getLast();
        statusDAO.addStatus("for test");
        statusDAO.deleteLast();
        Status status1 = statusDAO.getLast();
        Assert.assertEquals(status.getId(), status1.getId());
        status = null;
    }

    @Test
    public void testUpdate(){
        statusDAO.addStatus("for test");
        String content = "new content";
        int last = statusDAO.getLast().getId();
        Status s = statusDAO.update(last,content);
        Assert.assertEquals(s.getContent(), content);
        statusDAO.deleteLast();
        s = null;
    }

}
