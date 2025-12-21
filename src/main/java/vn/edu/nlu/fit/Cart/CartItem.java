import vn.edu.nlu.fit.model.Products;

public class CartItem {
    private Products p;
    private double price;
    private int quantiy;


    public CartItem(Products p, int quantiy, double price) {
        this.p = p;
        this.quantiy = quantiy;
        this.price = price;
    }
    public void upQuantity(int quan){
        if(quantiy<=1)  quantiy =1;
        this.quantiy = quan;

    }
}
