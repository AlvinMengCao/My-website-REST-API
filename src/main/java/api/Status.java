package api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * Created by alvin on 2/25/16.
 */
public class Status {
    private int id;
    private String content;
    private Date date;

    public Status() {
    }

    public Status(int id, String content, Date date) {
        this.id = id;
        this.content = content;
        this.date = date;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @JsonProperty
    public Date getDate() {
        return date;
    }
}
