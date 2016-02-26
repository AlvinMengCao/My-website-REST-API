package pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alvin on 2/25/16.
 */
@Entity
@Table(name = "status")
public class StatusPOJO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Date date;

    public StatusPOJO() {
    }

    public StatusPOJO(String content) {
        this.content = content;
        this.date = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
