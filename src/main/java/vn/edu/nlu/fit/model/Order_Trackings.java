package vn.edu.nlu.fit.model;

public class Order_Trackings {
    private int id;
    private int order_id;
    private boolean status;
    private String note;
    private Date update_time;


    public Order_Trackings(int id, int order_id, Date update_time, String note, boolean status) {
        this.id = id;
        this.order_id = order_id;
        this.update_time = update_time;
        this.note = note;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Order_Trackings{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", status=" + status +
                ", note='" + note + '\'' +
                ", update_time=" + update_time +
                '}';
    }
}