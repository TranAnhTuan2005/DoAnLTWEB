package vn.edu.nlu.fit.model;

import java.io.Serializable;

public class Products implements Serializable { //dung javaBean

    private int id;
    private String productName;
    private double price;
    private String imageURL;
    private double rating;
    private int productStatus;
    private int quantity;
    private String productDescription;
    private String productExpiryDate;
    private String ingredient;
    private String instruction;
    private String attention;
    private String uses;

    public Products() {
    }

    public Products(int id, String productName, double price, String imageURL, double rating, int productStatus, int quantity, String productDescription, String productExpiryDate, String ingredient, String instruction, String attention, String uses) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.imageURL = imageURL;
        this.rating = rating;
        this.productStatus = productStatus;
        this.quantity = quantity;
        this.productDescription = productDescription;
        this.productExpiryDate = productExpiryDate;
        this.ingredient = ingredient;
        this.instruction = instruction;
        this.attention = attention;
        this.uses = uses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductExpiryDate() {
        return productExpiryDate;
    }

    public void setProductExpiryDate(String productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", imageURL='" + imageURL + '\'' +
                ", rating=" + rating +
                ", productStatus=" + productStatus +
                ", quantity=" + quantity +
                ", productDescription='" + productDescription + '\'' +
                ", productExpiryDate='" + productExpiryDate + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", instruction='" + instruction + '\'' +
                ", attention='" + attention + '\'' +
                ", uses='" + uses + '\'' +
                '}';
    }
}
