package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by alvin on 2/26/16.
 */
public class Blog {
    private int id;
    private String title;
    private String url;
    private Date date;

    public Blog() {
    }

    public Blog(int id, String title, String url,Date date) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.date = date;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getUrl() {
        return url;
    }

    @JsonProperty
    public Date getDate() {
        return date;
    }
}
