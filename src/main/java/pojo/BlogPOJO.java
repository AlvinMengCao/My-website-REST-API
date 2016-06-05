package pojo;

import javax.persistence.*;
import java.util.Date;

/***********************************************************************
 * Created by alvin on 2/26/16.
 * 1. Hibernate pojo mapping class is unique, don't use builder here
 * 2.POJO必须提供无参数的构造器；
 * 3.必须有一个标识属性映射到数据库的主键列，可以是原始类也可以是包装类；
 * 4.必须为持久化的每一个属性创建set跟get方法
 * 5.使用非final类
 * 6.重写equals()和hashCode()方法，使得持久化类的实例能够被放进Set中，Map也推荐。
 ************************************************************************/
@Entity
@Table(name = "blog")
public class BlogPOJO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String url;
    private int percentage;
    private Date date;

    //optimal fields
    private String description;
    private String tag1;
    private String tag2;
    private String tag3;
    private String tag4;
    private String tag5;

    /***********************************************************************************
     * 此无参数构造器必须提供，Hibernate的Constructor.newInstance()会用这个来创建，至少是包可见
     **********************************************************************************/
    public BlogPOJO() {}

    //构造函数以及构建器
    public BlogPOJO(Builder builder) {
        title = builder.title;
        url = builder.url;
        date = builder.date;
        percentage = builder.percentage;

        tag1 = builder.tag1;
        tag2 = builder.tag2;
        tag3 = builder.tag3;
        tag4 = builder.tag4;
        tag5 = builder.tag5;
        description = builder.description;
    }
    public static class Builder{
        private String title;
        private String url;
        private int percentage;
        private Date date;

        private String description = "a";
        private String tag1 = "a";
        private String tag2 = "a";
        private String tag3 = "a";
        private String tag4 = "a";
        private String tag5 = "a";

        public Builder(String title, String url, int percentage, Date date){
            this.title = title;
            this.url = url;
            this.percentage = percentage;
            this.date = date;
        }
        public Builder description(String val){
            description = val;
            return this;
        }
        public Builder tag1(String val){
            description = val;
            return this;
        }
        public Builder tag2(String val){
            description = val;
            return this;
        }
        public Builder tag3(String val){
            description = val;
            return this;
        }
        public Builder tag4(String val){
            description = val;
            return this;
        }
        public Builder tag5(String val){
            description = val;
            return this;
        }
        public BlogPOJO build(){
            return new BlogPOJO(this);
        }
    }

    //架构会用到的setter与getter们
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
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
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTag1() {
        return tag1;
    }
    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }
    public String getTag2() {
        return tag2;
    }
    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }
    public String getTag3() {
        return tag3;
    }
    public void setTag3(String tag3) {
        this.tag3 = tag3;
    }
    public String getTag4() {
        return tag4;
    }
    public void setTag4(String tag4) {
        this.tag4 = tag4;
    }
    public String getTag5() {
        return tag5;
    }
    public void setTag5(String tag5) {
        this.tag5 = tag5;
    }
    public int getPercentage() {
        return percentage;
    }
    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    /*******************************************************************************
     *重写的equals方法，只比较关键的field<br>
     *     注意不能比较Date字段，因为我们数据库中的都是手动添加的，没有Date字段。另外比较这个字段
     *     占用资源。
     *******************************************************************************/
    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        }
        if (!(o instanceof BlogPOJO)){
            return false;
        }
        BlogPOJO b = (BlogPOJO)o;
        return b.title.equals(title)
                && b.url.equals(url)
                && b.percentage == percentage;
    }

    /**************************************************************************
     * 使用了lazily initialize的方式，并且把hashCode缓存起来
     * 注意：此方法work的前提是，这个类是不可变的，否则改变之后，hashCode也应该重新计算。
     * @return 返回hashCode。若此类可变，需使用最原始方式写hashCode。
     ************************************************************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + percentage;
        result = 31 * result + url.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" | Title is: ").append(title);
        sb.append(" | Percentage is: ").append(percentage);
        sb.append(" | ID is: ").append(id);
        return sb.toString();
    }
}
