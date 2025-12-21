import vn.edu.nlu.fit.model.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    Map<Products, Integer> data;

    public Cart(Map<Products, Integer> list) {
        this.data = new HashMap<>();
    }
    public void add(Products p, int quantity){
        if (!data.containsKey(p.getId())) data.get(p.getId()).upQuantity(quantity);
    }
    public void delete(int productId){
        if(data.containsKey(productId)) data.remove(productId);
    }
    public void deleteAll(){
        data.clear();
    }
    public List<Products> list(){
        List<Products> list = new ArrayList<Products>();
       for(Map.entry(Products, Integer) product : data.entrySet()){
           list.add(product);
       }
        return list;
    }
    public int total(){
        int total;
        for(Map.entry(Products, Integer) product : data.entrySet()){
            total += product.getValue();
        }
        return total;
    }
    public void update(int productId){
        for(Map.entry(Products, Integer) product : data.entrySet()){
            if(product.getKey().equals(productId)){
                product.getKey() = productId;
            }
        }
    }

}
