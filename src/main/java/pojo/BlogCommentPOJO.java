package pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alvin on 3/2/16.
 */
@Entity
@Table(name = "blogcomments")
public class BlogCommentPOJO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;
    private String comment;
    private String name;
    private Date date;

    public BlogCommentPOJO() {
    }

    public BlogCommentPOJO(String name, String comment, String url) {
        this.name = name;
        this.comment = comment;
        this.date = new Date();
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
