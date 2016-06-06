package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by alvin on 2/26/16.
 * 1. Has optional fields, use builder instead of constructor
 */
public class Blog {
    private  int id;
    private  String title;
    private  String url;
    private  Date date;
    private  int percentage;

    private  String description;
    private  String tag1;
    private  String tag2;
    private  String tag3;
    private  String tag4;
    private  String tag5;

    //构建器
    public static class Builder{
        //required fields
        private final int id;
        private final String title;
        private final String url;
        private final Date date;
        private final int percentage;

        //optional field, initialized them to default values
        private String description = "no description";
        private String tag1 = "tag1";
        private String tag2 = "tag2";
        private String tag3 = "tag3";
        private String tag4 = "tag4";
        private String tag5 = "tag5";

        public Builder(int id, String title, String url, Date date, int percentage){
            this.id = id;
            this.title = title;
            this.url = url;
            this.date = date;
            this.percentage = percentage;
        }
        public Builder tag1(String val){
            tag1 = val;
            return this;
        }
        public Builder tag2(String val){
            tag2 = val;
            return this;
        }
        public Builder tag3(String val){
            tag3 = val;
            return this;
        }
        public Builder tag4(String val){
            tag4 = val;
            return this;
        }
        public Builder tag5(String val){
            tag5 = val;
            return this;
        }
        public Builder descriptin(String val){
            description = val;
            return this;
        }
        public Blog build(){
            return new Blog(this);
        }
    }


    //for test
    public Blog(){}
    public Blog(Builder builder) {
        id = builder.id;
        title = builder.title;
        url = builder.url;
        date = builder.date;
        percentage = builder.percentage;
        description = builder.description;
        tag1 = builder.tag1;
        tag2 = builder.tag2;
        tag3 = builder.tag3;
        tag4 = builder.tag4;
        tag5 = builder.tag5;
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

    @JsonProperty
    public int getPercentage() {
        return percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        }
        if (!(o instanceof Blog)){
            return false;
        }
        Blog b = (Blog)o;
        return b.id == id
                && b.title.equals(title)
                && b.url.equals(url)
                && b.percentage == percentage
                && b.tag1.equals(tag1)
                && b.tag2.equals(tag2)
                && b.tag3.equals(tag3)
                && b.tag4.equals(tag4)
                && b.tag5.equals(tag5);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + id;
        result = result * 31 + title.hashCode();
        result = result * 31 + url.hashCode();
        result = result * 31 + percentage;
        result = result * 31 + tag1.hashCode();
        result = result * 31 + tag2.hashCode();
        result = result * 31 + tag3.hashCode();
        result = result * 31 + tag4.hashCode();
        result = result * 31 + tag5.hashCode();
        return result;
    }
}
