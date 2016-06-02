package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by alvin on 3/2/16.
 */
public class BlogComment {
    private int id;
    private String url;
    private String comment;
    private Date date;
    private String name;


    public BlogComment(int id, String url, String comment, Date date, String name) {
        this.id = id;
        this.url = url;
        this.comment = comment;
        this.date = date;
        this.name = name;
    }
    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getUrl() {
        return url;
    }

    @JsonProperty
    public String getComment() {
        return comment;
    }

    @JsonProperty
    public Date getDate() {
        return date;
    }

    @JsonProperty
    public String getName() {
        return name;
    }
}
