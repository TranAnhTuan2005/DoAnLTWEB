package vn.edu.nlu.fit.model;

public class News {
    private int id;
    private String title;
    private String content;
    private String imageURL;
    private int userID;
    private Date datePost;
    private int isPublished;

    public News() {
    }

    public News(int id, String title, String content, String imageURL, int userID, Date datePost, int isPublished) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageURL = imageURL;
        this.userID = userID;
        this.datePost = datePost;
        this.isPublished = isPublished;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public int isPublished() {
        return isPublished;
    }

    public void setPublished(int published) {
        isPublished = published;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", userID=" + userID +
                ", datePost=" + datePost +
                ", isPublished=" + isPublished +
                '}';
    }
}