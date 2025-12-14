package vn.edu.nlu.fit.model;

public  class Payments {
    private int id;
    private int order_id;
    private paymentMethods_id;
    private double amount;
    private boolean status;
    private Date date;


    public Payments(int id, Date date, boolean status, double amount, int order_id) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.amount = amount;
        this.order_id = order_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Payments{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", amount=" + amount +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}