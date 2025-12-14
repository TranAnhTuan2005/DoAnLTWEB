package vn.edu.nlu.fit.model;

public class Banners {
    private int id;
    private String image;
    private int status;

    public Banners() {
    }

    public Banners(int status, String image, int id) {
        this.status = status;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Banners{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", status=" + status +
                '}';
    }
}
