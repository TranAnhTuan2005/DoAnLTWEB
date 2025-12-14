package vn.edu.nlu.fit.model;
public class Carts {
    private int id;
    private int user_id;
    private int product_id;
    private int quantity;


    public Carts(int id, int user_id, int quantity, int product_id) {
        this.id = id;
        this.user_id = user_id;
        this.quantity = quantity;
        this.product_id = product_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Carts{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                '}';
    }
}