package dao;

import api.Skill;
import api.Status;
import org.hibernate.Query;
import org.hibernate.Session;
import pojo.SkillPOJO;
import pojo.StatusPOJO;

import java.util.Date;

/**
 * Created by alvin on 2/28/16.
 * 1. Singleton instance of SkillDAO.
 * 2. Already eliminate obsolete object references.
 */
public class SkillDAO extends DAOBase {
    private static final SkillDAO skillDAO = new SkillDAO();
    private SkillDAO(){}

    public void addSkill(String title, String content){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        SkillPOJO skillPOJO = new SkillPOJO(title, content);
        ss.save(skillPOJO);
        ss.getTransaction().commit();
        skillPOJO = null;
    }

    public Skill getSingle(int id) {
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        SkillPOJO s = ss.get(SkillPOJO.class,id);
        ss.getTransaction().commit();
        Skill skill = new Skill(s.getId(), s.getTitle(), s.getContent());
        s = null;
        return skill;
    }

    //has test, won't pollute data
    public Skill getLast(){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        SkillPOJO s = (SkillPOJO) ss.createQuery("from SkillPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        Skill skill = new Skill(s.getId(), s.getTitle(), s.getContent());
        s = null;
        return skill;
    }

    //has test, won't pollute data
    public Skill update(int id, String title, String content){
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        SkillPOJO s = ss.get(SkillPOJO.class,id);
        s.setTitle(title);
        s.setContent(content);
        ss.save(s);
        ss.getTransaction().commit();
        Skill skill = new Skill(s.getId(), s.getTitle(), s.getContent());
        s = null;
        return skill;
    }

    public void deleteLast(){
        int last = skillDAO.getLast().getId();
        Session ss = sessionFactory.getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from SkillPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
        query = null;
    }
    public static SkillDAO getSkillDAO(){
        return skillDAO;
    }
}
