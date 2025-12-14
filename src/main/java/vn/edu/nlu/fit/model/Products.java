package vn.edu.nlu.fit.model;

import java.io.Serializable;

public class Products implements Serializable { //dung javaBean

    private int id;
    private String name;
    private double price;
    private String image;
    private double rating;
    private int status;
    private int isNew;
    private int quantity;
    private String brand;
    private String description;
    private String expiryDate;
    private String ingredient;
    private String instruction;
    private String attention;
    private String uses;

    public Products() {
    }

    public Products(int id, String name, double price, String image, double rating, int status, int isNew, int quantity, String brand, String description, String expiryDate, String ingredient, String instruction, String attention, String uses) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.rating = rating;
        this.status = status;
        this.isNew = isNew;
        this.quantity = quantity;
        this.brand = brand;
        this.description = description;
        this.expiryDate = expiryDate;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                ", status=" + status +
                ", isNew=" + isNew +
                ", quantity=" + quantity +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", instruction='" + instruction + '\'' +
                ", attention='" + attention + '\'' +
                ", uses='" + uses + '\'' +
                '}';
    }
}
