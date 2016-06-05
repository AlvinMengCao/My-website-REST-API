package pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * 1. Created by alvin on 3/2/16.
 * 2.POJO必须提供无参数的构造器；
 * 3.必须有一个标识属性映射到数据库的主键列，可以是原始类也可以是包装类；
 * 4.必须为持久化的每一个属性创建set跟get方法
 * 5.使用非final类
 * 6.重写equals()和hashCode()方法，使得持久化类的实例能够被放进Set中，Map也推荐。
 */
@Entity
@Table(name = "blogcomments")
public class BlogCommentPOJO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String url;
    private String comment;
    private String name;
    private Date date;

    /****************************************************************************/
    //无参构造器，架构会用到
    public BlogCommentPOJO() {}

    //有参构造器以及构建器
    public BlogCommentPOJO(Builder builder){
        url = builder.url;
        comment = builder.comment;
        name = builder.name;
        date = builder.date;
    }
    public static class Builder{
        private String url;
        private String comment;
        private String name;
        private Date date;

        public Builder(String url, String comment, String name, Date date) {
            this.url = url;
            this.comment = comment;
            this.name = name;
            this.date = date;
        }
        public BlogCommentPOJO build(){
            return new BlogCommentPOJO(this);
        }
    }

    //架构会用到的setter与getter们
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    /****************************************************************************/
    /*******************************************************************************
     *重写的equals方法，只比较关键的field<br>
     *     注意不能比较Date字段，因为我们数据库中的都是手动添加的，没有Date字段。另外比较这个字段
     *     占用资源。
     *     即使ID不同，其他相同的评论也是不允许的。因此这里不比较ID。
     *******************************************************************************/
    @Override
    public boolean equals(Object o) {
        if (o == this){
            return true;
        }
        if (!(o instanceof BlogCommentPOJO)){
            return false;
        }
        BlogCommentPOJO b = (BlogCommentPOJO)o;
        return b.name.equals(name)
                && b.url.equals(url)
                && b.comment.equals(comment);
    }

    /**************************************************************************
     * 使用了lazily initialize的方式，并且把hashCode缓存起来
     * 注意：此方法work的前提是，这个类是不可变的，否则改变之后，hashCode也应该重新计算。
     * @return 返回hashCode。若此类可变，需使用最原始方式写hashCode。
     ************************************************************************/
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + comment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(" | Name is: ").append(name);
        sb.append(" | ID is: ").append(id);
        sb.append(" | Comment is: ").append(comment);
        return sb.toString();
    }
}
