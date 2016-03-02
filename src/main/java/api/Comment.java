package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


/**
 * Created by alvin on 2/24/16.
 */

public class Comment {

    private long id;
    private String comment;
    private String email;
    private Date date;

    public Comment() {
        // for Jackson deserialization
    }

    public Comment(long id, String comment, String email, Date date) {
        this.id = id;
        this.comment = comment;
        this.email = email;
        this.date = date;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getComment() {
        return comment;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public Date getDate() {
        return date;
    }
}