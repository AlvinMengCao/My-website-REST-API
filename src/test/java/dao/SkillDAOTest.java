package dao;

import api.Skill;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pojo.POJOs;

import static org.junit.Assert.*;

/**
 * Created by alvin on 2/28/16.
 */
public class SkillDAOTest {

    private SkillDAO skillDAO;


    @Before
    public void setUp() throws Exception {
        skillDAO = new SkillDAO();
    }

    @Test
    public void testAddSkill() throws Exception {
        int before = skillDAO.getSize(POJOs.SkillPOJO.toString());
        skillDAO.addSkill("a", "b");
        int after = skillDAO.getSize(POJOs.SkillPOJO.toString());
        Assert.assertEquals(1, after - before);
        Skill skill = skillDAO.getLast();
        Assert.assertTrue(skill.getContent().equals("b"));
        Assert.assertTrue(skill.getTitle().equals("a"));
        skillDAO.deleteLast();
        int after_delete = skillDAO.getSize(POJOs.SkillPOJO.toString());
        Assert.assertEquals(before, after_delete);
    }

    @Test
    public void testGetSingle() throws Exception {
        skillDAO.addSkill("a", "b");
        int id = skillDAO.getLast().getId();
        Skill skill = skillDAO.getSingle(id);
        Assert.assertTrue(skill.getTitle().equals("a"));
        Assert.assertTrue(skill.getContent().equals("b"));
        skillDAO.deleteLast();
    }

    @Test
    public void testGetLast() throws Exception {
        skillDAO.addSkill("a", "b");
        Skill skill = skillDAO.getLast();
        Assert.assertTrue(skill.getTitle().equals("a"));
        Assert.assertTrue(skill.getContent().equals("b"));
        skillDAO.deleteLast();
    }

    @Test
    public void testUpdate() throws Exception {
        skillDAO.addSkill("a", "b");
        int id = skillDAO.getLast().getId();
        skillDAO.update(id, "c", "d");
        Skill skill = skillDAO.getLast();
        Assert.assertTrue(skill.getContent().equals("d"));
        Assert.assertTrue(skill.getTitle().equals("c"));
        skillDAO.deleteLast();
    }

    @Test
    public void testDeleteLast() throws Exception {
        skillDAO.addSkill("a", "b");
        skillDAO.addSkill("c", "d");
        skillDAO.deleteLast();
        Skill skill = skillDAO.getLast();
        Assert.assertTrue(skill.getTitle().equals("a"));
        Assert.assertTrue(skill.getContent().equals("b"));
        skillDAO.deleteLast();
    }

    @After
    public void tearDown(){
        skillDAO = null;
    }
}