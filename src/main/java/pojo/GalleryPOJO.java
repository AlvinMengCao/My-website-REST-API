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
    private String url1;
    private String url2;
    private String url3;
    private String url4;
    private String url5;
    private String url6;
    private String url7;
    private String url8;
    private String url9;
    private Date date;
    private String description;
    private int num;
    private String category;

    /***********************************************************************************
     * 此无参数构造器必须提供，Hibernate的Constructor.newInstance()会用这个来创建，至少是包可见
     **********************************************************************************/
    public GalleryPOJO(){}
    public GalleryPOJO(Builder b){
        title = b.title;
        url1 = b.url1;
        url2 = b.url2;
        url3 = b.url3;
        url4 = b.url4;
        url5 = b.url5;
        url6 = b.url6;
        url7 = b.url7;
        url8 = b.url8;
        url9 = b.url9;
        date = b.date;
        description = b.description;
        num = b.num;
        category = b.category;
    }
    public static class Builder{
        private String title;
        private Date date;
        //optional
        private String url1 = "url1";
        private String url2 = "url2";
        private String url3 = "url3";
        private String url4 = "url4";
        private String url5 = "url5";
        private String url6 = "url6";
        private String url7 = "url7";
        private String url8 = "url8";
        private String url9 = "url9";
        private String description = "no description";
        private int num = 0;
        private String category = "default";

        public Builder(String title, Date date){
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
        public Builder url6(String val){
            url6 = val;
            return this;
        }
        public Builder url7(String val){
            url7 = val;
            return this;
        }
        public Builder url8(String val){
            url8 = val;
            return this;
        }
        public Builder url9(String val){
            url9 = val;
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
        public Builder category(String val){
            category = val;
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
    public String getUrl1() {
        return url1;
    }
    public void setUrl1(String url1) {
        this.url1 = url1;
    }
    public String getUrl2() {
        return url2;
    }
    public void setUrl2(String url2) {
        this.url2 = url2;
    }
    public String getUrl3() {
        return url3;
    }
    public void setUrl3(String url3) {
        this.url3 = url3;
    }
    public String getUrl4() {
        return url4;
    }
    public void setUrl4(String url4) {
        this.url4 = url4;
    }
    public String getUrl5() {
        return url5;
    }
    public void setUrl5(String url5) {
        this.url5 = url5;
    }
    public String getUrl6() {
        return url6;
    }
    public void setUrl6(String url6) {
        this.url6 = url6;
    }
    public String getUrl7() {
        return url7;
    }
    public void setUrl7(String url7) {
        this.url7 = url7;
    }
    public String getUrl8() {
        return url8;
    }
    public void setUrl8(String url8) {
        this.url8 = url8;
    }
    public String getUrl9() {
        return url9;
    }
    public void setUrl9(String url9) {
        this.url9 = url9;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
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
                && g.url1.equals(url1)
                && g.url2.equals(url2)
                && g.url3.equals(url3)
                && g.url4.equals(url4)
                && g.url5.equals(url5)
                && g.url6.equals(url6)
                && g.url7.equals(url7)
                && g.url8.equals(url8)
                && g.url9.equals(url9)
                && g.category.equals(category)
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
        result = 31 * result + url6.hashCode();
        result = 31 * result + url7.hashCode();
        result = 31 * result + url8.hashCode();
        result = 31 * result + url9.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + num;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" | Title is: ").append(title);
        sb.append(" | URL is: ").append(url1).append(url2).append(url3).append(url4)
                .append(url5).append(url6).append(url7).append(url8).append(url9);
        sb.append(" | Num of Photos is: ").append(num);
        sb.append(" | Description is: ").append(description);
        return sb.toString();
    }
}
