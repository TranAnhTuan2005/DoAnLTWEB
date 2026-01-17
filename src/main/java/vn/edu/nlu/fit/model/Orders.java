package vn.edu.nlu.fit.model;

import java.time.LocalDateTime;

public class Orders {
    private int id;
    private String fullName;
    private String phone;
    private String email;
    private double total;
    private LocalDateTime orderDate;
    private String orderAddress;
    private int  orderStatus;
    private int userID;
    private int deliveryMethodID;
    private int paymentMethodID;
    private int discountID;


    public Orders(int id, String fullName, double total, String email, String phone, LocalDateTime orderDate, String orderAddress, int orderStatus, int userID, int deliveryMethodID, int paymentMethodID, int discountID) {
        this.id = id;
        this.fullName = fullName;
        this.total = total;
        this.email = email;
        this.phone = phone;
        this.orderDate = orderDate;
        this.orderAddress = orderAddress;
        this.orderStatus = orderStatus;
        this.userID = userID;
        this.deliveryMethodID = deliveryMethodID;
        this.paymentMethodID = paymentMethodID;
        this.discountID = discountID;
    }

    public Orders() {
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

    public int  getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int  orderStatus) {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(int paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", total=" + total +
                ", orderDate=" + orderDate +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderStatus=" + orderStatus +
                ", userID=" + userID +
                ", deliveryMethodID=" + deliveryMethodID +
                ", paymentMethodID=" + paymentMethodID +
                ", discountID=" + discountID +
                '}';
    }
}
