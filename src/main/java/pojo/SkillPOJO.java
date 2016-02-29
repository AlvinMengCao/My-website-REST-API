package pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alvin on 2/28/16.
 */
@Entity
@Table(name = "skills")
public class SkillPOJO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    public SkillPOJO() {
    }

    public SkillPOJO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
