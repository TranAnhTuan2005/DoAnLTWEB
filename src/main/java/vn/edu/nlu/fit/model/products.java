package vn.edu.nlu.fit.model;

import java.io.Serializable;

public class products implements Serializable { //dung javaBean

    private int id;
    private String name;
    private String img;
    private int price;

    public products(int id, String name, String img, int price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public products() {
    }


}
