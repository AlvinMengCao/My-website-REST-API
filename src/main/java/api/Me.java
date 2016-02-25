package api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alvin on 2/24/16.
 */
public class Me {
    private String name;

    public Me(String name) {
        this.name = name;
    }

    public Me() {
    }
    @JsonProperty
    public String getName() {
        return name;
    }
    @JsonProperty
    public void setName(String name) {
        this.name = name;
    }
}
