package vn.edu.nlu.fit.model;

public class DeliveryMethods {
    private int id;
    private int order_id;
    private boolean isActived;
    private double price;


    public DeliveryMethods(int id, int order_id, boolean isActived, double price) {
        this.id = id;
        this.order_id = order_id;
        this.isActived = isActived;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActived() {
        return isActived;
    }

    public void setActived(boolean actived) {
        isActived = actived;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "DeliveryMethods{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", isActived=" + isActived +
                ", price=" + price +
                '}';
    }
}