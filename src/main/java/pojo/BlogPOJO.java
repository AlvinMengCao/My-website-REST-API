package pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alvin on 2/26/16.
 */
@Entity
@Table(name = "blog")
public class BlogPOJO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String url;
    private Date date;

    public BlogPOJO() {
    }

    public BlogPOJO(String title, String url) {
        this.title = title;
        this.url = url;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
