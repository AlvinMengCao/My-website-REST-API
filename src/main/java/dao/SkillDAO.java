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
 */
public class SkillDAO extends DAOBase {

    public void addSkill(String title, String content){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        SkillPOJO skillPOJO = new SkillPOJO(title, content);
        ss.save(skillPOJO);
        ss.getTransaction().commit();
    }

    public Skill getSingle(int id) {
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        SkillPOJO s = ss.get(SkillPOJO.class,id);
        ss.getTransaction().commit();
        return new Skill(s.getId(), s.getTitle(), s.getContent());
    }

    //has test, won't pollute data
    public Skill getLast(){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        SkillPOJO s = (SkillPOJO) ss.createQuery("from SkillPOJO ORDER BY id DESC").setMaxResults(1).uniqueResult();
        ss.getTransaction().commit();
        return new Skill(s.getId(), s.getTitle(), s.getContent());
    }

    //has test, won't pollute data
    public Skill update(int id, String title, String content){
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        SkillPOJO s = ss.get(SkillPOJO.class,id);
        s.setTitle(title);
        s.setContent(content);
        ss.save(s);
        ss.getTransaction().commit();
        return new Skill(s.getId(), s.getTitle(), s.getContent());
    }

    public void deleteLast(){
        SkillDAO skillDAO = new SkillDAO();
        int last = skillDAO.getLast().getId();
        Session ss = HibernateUtils.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        Query query = ss.createQuery("delete from SkillPOJO where id=?");
        query.setInteger(0, last);
        query.executeUpdate();
        ss.getTransaction().commit();
    }
}
