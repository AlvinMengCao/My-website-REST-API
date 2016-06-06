package pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alvin on 6/6/16.
 */
@Entity
@Table(name = "gallery")
public class GalleryPOJO {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String url;
    private Date date;
    private String description;
    private int num;

    /***********************************************************************************
     * 此无参数构造器必须提供，Hibernate的Constructor.newInstance()会用这个来创建，至少是包可见
     **********************************************************************************/
    public GalleryPOJO(){}
    public GalleryPOJO(Builder b){
        title = b.title;
        url = b.url;
        date = b.date;
        description = b.description;
        num = b.num;
    }
    public static class Builder{
        private String title;
        private Date date;
        //optional
        private String url = "url";
        private String description = "no description";
        private int num = 0;
        public Builder(String title, Date date){
            this.title = title;
            this.date = date;
        }
        public Builder url(String val){
            url = val;
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
        public GalleryPOJO build(){
            return new GalleryPOJO(this);
        }

    }

    //架构用到的set与get方法


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        }
        if (!(o instanceof GalleryPOJO)){
            return false;
        }
        GalleryPOJO g = (GalleryPOJO)o;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" | Title is: ").append(title);
        sb.append(" | URL is: ").append(url);
        sb.append(" | ID is: ").append(id);
        sb.append(" | Num of Photos is: ").append(num);
        sb.append(" | Description is: ").append(description);
        return sb.toString();
    }
}
