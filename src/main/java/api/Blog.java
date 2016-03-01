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

    private String description;
    private String tag1;
    private String tag2;
    private String tag3;
    private String tag4;
    private String tag5;

    public Blog() {
    }

    public Blog(int id, String title, String url, Date date, String description, String tag1, String tag2, String tag3, String tag4, String tag5) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.date = date;
        this.description = description;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.tag3 = tag3;
        this.tag4 = tag4;
        this.tag5 = tag5;
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

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public String getTag1() {
        return tag1;
    }

    @JsonProperty
    public String getTag2() {
        return tag2;
    }

    @JsonProperty
    public String getTag3() {
        return tag3;
    }

    @JsonProperty
    public String getTag4() {
        return tag4;
    }

    @JsonProperty
    public String getTag5() {
        return tag5;
    }
}
