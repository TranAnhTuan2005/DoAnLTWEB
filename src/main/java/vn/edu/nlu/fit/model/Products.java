package vn.edu.nlu.fit.model;

import java.io.Serializable;

public class Products implements Serializable { //dung javaBean

    private int id;
    private String name;
    private String img;
    private int price;

///
    private int status;
    private int quantity;

    private String brand;
    private String description;
    private String expiry_date;
    private String instruction;
    private String attention;
    private String uses;
    private String ingredient;
    public Products() {
    }


    public Products(int id, String ingredient, String uses, String instruction, String description, int quantity, int price, String img, String name, int status, String brand, String expiry_date, String attention) {
        this.id = id;
        this.ingredient = ingredient;
        this.uses = uses;
        this.instruction = instruction;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.img = img;
        this.name = name;
        this.status = status;
        this.brand = brand;
        this.expiry_date = expiry_date;
        this.attention = attention;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
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
}
