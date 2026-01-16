package vn.edu.nlu.fit.model;

import java.time.LocalDateTime;

public class Orders {
    private int id;
    private double total;
    private LocalDateTime orderDate;
    private String orderAddress;
    private String  orderStatus;
    private int userID;
    private int deliveryMethodID;
    private int discountID;


    public Orders() {
    }

    public Orders(int discountID, int deliveryMethodID, int userID, String  orderStatus, String orderAddress, LocalDateTime  orderDate, double total, int id) {
        this.discountID = discountID;
        this.deliveryMethodID = deliveryMethodID;
        this.userID = userID;
        this.orderStatus = orderStatus;
        this.orderAddress = orderAddress;
        this.orderDate = orderDate;
        this.total = total;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime  getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime  orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String  getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String  orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getDeliveryMethodID() {
        return deliveryMethodID;
    }

    public void setDeliveryMethodID(int deliveryMethodID) {
        this.deliveryMethodID = deliveryMethodID;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", total=" + total +
                ", orderDate=" + orderDate +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderStatus=" + orderStatus +
                ", userID=" + userID +
                ", deliveryMethodID=" + deliveryMethodID +
                ", discountID=" + discountID +
                '}';
    }
}
