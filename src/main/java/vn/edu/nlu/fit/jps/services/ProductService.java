package vn.edu.nlu.fit.jps.services;

import vn.edu.nlu.fit.jps.dao.ProductDAO;
import vn.edu.nlu.fit.jps.model.Product;

import java.util.List;

public class ProductService {
    ProductDAO proDao= new ProductDAO();


    public List<Product> getListProduct() {
        return proDao.getListProduct();
    }
}
