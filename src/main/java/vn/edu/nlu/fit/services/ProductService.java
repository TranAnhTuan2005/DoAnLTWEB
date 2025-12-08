package vn.edu.nlu.fit.services;

import vn.edu.nlu.fit.dao.ProductDAO;
import vn.edu.nlu.fit.model.products;

import java.util.List;

public class ProductService {
    ProductDAO proDao= new ProductDAO();


    public List<products> getListProduct() {
        return proDao.getListProduct();
    }
}
