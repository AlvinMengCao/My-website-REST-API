package api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alvin on 2/26/16.
 */
public class Blog {
    private int id;
    private String title;
    private String url;

    public Blog() {
    }

    public Blog(int id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
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
}
