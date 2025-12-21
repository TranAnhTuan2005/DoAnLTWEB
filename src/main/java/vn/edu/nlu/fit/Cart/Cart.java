import vn.edu.nlu.fit.model.Products;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    Map<Products, Integer> list;

    public Cart(Map<Products, Integer> list) {
        this.list = new HashMap<>();
    }
    public void add(Products p, int quantity){

    }
    public void delete(int productId){

    }
    public void deleteAll(){

    }
    public List<Products> list(){
        return null;
    }
    public int total(){
        return 0;
    }
    public void update(int productId){

    }
    
}
