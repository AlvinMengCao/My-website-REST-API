package pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alvin on 2/24/16.
 */
@Entity
@Table(name = "website_comment")
public class WebSiteCommentPOJO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String comment;
    private Date date;

    public WebSiteCommentPOJO() {
    }

    public WebSiteCommentPOJO(String email, String comment) {
        this.email = email;
        this.comment = comment;
        this.date = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
