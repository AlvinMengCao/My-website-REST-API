package api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by alvin on 6/6/16.
 */
public class Gallery {
    private int id;
    private String title;
    private String url1;
    private String url2;
    private String url3;
    private String url4;
    private String url5;
    private Date date;
    private String description;
    private int num;

    public static class Builder{
        private int id;
        private String title;
        private Date date;
        //optional
        private String url1 = "url1";
        private String url2 = "url2";
        private String url3 = "url3";
        private String url4 = "url4";
        private String url5 = "url5";
        private String description = "no description";
        private int num = 0;
        public Builder(int id, String title, Date date){
            this.id = id;
            this.title = title;
            this.date = date;
        }
        public Builder url1(String val){
            url1 = val;
            return this;
        }
        public Builder url2(String val){
            url2 = val;
            return this;
        }
        public Builder url3(String val){
            url3 = val;
            return this;
        }
        public Builder url4(String val){
            url4 = val;
            return this;
        }
        public Builder url5(String val){
            url5 = val;
            return this;
        }
        public Builder description(String val){
            description = val;
            return this;
        }
        public Builder num(int val){
            num = val;
            return this;
        }
        public Gallery build(){
            return new Gallery(this);
        }
    }
    public Gallery(){}
    public Gallery(Builder b){
        id = b.id;
        title = b.title;
        url1 = b.url1;
        url2 = b.url2;
        url3 = b.url3;
        url4 = b.url4;
        url5 = b.url5;
        date = b.date;
        description = b.description;
        num = b.num;
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
    public String getUrl1() {
        return url1;
    }
    @JsonProperty
    public String getUrl2() {
        return url2;
    }
    @JsonProperty
    public String getUrl3() {
        return url3;
    }
    @JsonProperty
    public String getUrl4() {
        return url4;
    }
    @JsonProperty
    public String getUrl5() {
        return url5;
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
                && g.url1.equals(url1)
                && g.url2.equals(url2)
                && g.url3.equals(url3)
                && g.url4.equals(url4)
                && g.url1.equals(url5)
                && g.description.equals(description)
                && g.num == num;
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + title.hashCode();
        result = 31 * result + url1.hashCode();
        result = 31 * result + url2.hashCode();
        result = 31 * result + url3.hashCode();
        result = 31 * result + url4.hashCode();
        result = 31 * result + url5.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + num;
        return result;
    }
}
