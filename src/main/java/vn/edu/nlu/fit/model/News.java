package vn.edu.nlu.fit.model;

public class News {
    private int id;
    private String title;
    private String content;
    private String image;
    private int user_id;
    private Date date_post;
    private boolean is_published;


    public News(int id, String title, boolean is_published, int user_id, Date date_post, String image, String content) {
        this.id = id;
        this.title = title;
        this.is_published = is_published;
        this.user_id = user_id;
        this.date_post = date_post;
        this.image = image;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate_post() {
        return date_post;
    }

    public void setDate_post(Date date_post) {
        this.date_post = date_post;
    }

    public boolean isIs_published() {
        return is_published;
    }

    public void setIs_published(boolean is_published) {
        this.is_published = is_published;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", user_id=" + user_id +
                ", date_post=" + date_post +
                ", is_published=" + is_published +
                '}';
    }
}