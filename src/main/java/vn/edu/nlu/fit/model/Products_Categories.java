package vn.edu.nlu.fit.model;

public class Products_Categories {
    private int id;
    private int productId;
    private int categoryId;

    public Products_Categories() {
    }

    public Products_Categories(int id, int productId, int categoryId) {
        this.id = id;
        this.productId = productId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Products_Categories{" +
                "id=" + id +
                ", productId=" + productId +
                ", categoryId=" + categoryId +
                '}';
    }
}
