package vn.edu.nlu.fit.services;

import vn.edu.nlu.fit.dao.ProductDAO;
import vn.edu.nlu.fit.model.Products;

import java.util.List;

public class ProductService {
    ProductDAO proDao= new ProductDAO();


    public List<Products> getListProduct() {
        return proDao.getListProduct();
    }


    public Products getDetail(int id) {
        return proDao.findById(id);
    }
}
