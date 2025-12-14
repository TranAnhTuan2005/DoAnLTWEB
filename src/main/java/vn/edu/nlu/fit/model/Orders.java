package vn.edu.nlu.fit.model;

public class Orders {
    private int id;
    private double total;
    private Date date;
    private String address;
    private boolean status;
    private int user_id;
    private int deliveryMethod_id;
    private int discount_id;


    public Orders(int id, String address, Date date, double total, boolean status, int user_id, int discount_id, int deliveryMethod_id) {
        this.id = id;
        this.address = address;
        this.date = date;
        this.total = total;
        this.status = status;
        this.user_id = user_id;
        this.discount_id = discount_id;
        this.deliveryMethod_id = deliveryMethod_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public int getDeliveryMethod_id() {
        return deliveryMethod_id;
    }

    public void setDeliveryMethod_id(int deliveryMethod_id) {
        this.deliveryMethod_id = deliveryMethod_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Orders{" +
                "id=" + id +
                ", total=" + total +
                ", date=" + date +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", user_id=" + user_id +
                ", deliveryMethod_id=" + deliveryMethod_id +
                ", discount_id=" + discount_id +
                '}';
    }
}
