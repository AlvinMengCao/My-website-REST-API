package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by alvin on 6/6/16.
 */
public class Gallery {
    private int id;
    private String title;
    private String url;
    private Date date;
    private String description;
    private int num;

    public Gallery(){}
    public Gallery(int id, String title, String url, Date date, String description, int num) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.date = date;
        this.description = description;
        this.num = num;
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
    public int getNum() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        }
        if (!(o instanceof Gallery)){
            return false;
        }
        Gallery g = (Gallery)o;
        return g.title.equals(title)
                && g.url.equals(url)
                && g.description.equals(description)
                && g.num == num;
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + title.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + num;
        return result;
    }
}
