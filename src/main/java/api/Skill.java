package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by alvin on 2/28/16.
 */
public class Skill {
    private int id;
    private String title;
    private String content;


    public Skill() {
    }

    public Skill(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
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
    public String getContent() {
        return content;
    }

}
