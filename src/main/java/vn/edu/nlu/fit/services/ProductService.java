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

    public List<Products> getProductsByFilter(String type) {
        String filter = "";
        String sortType = "DESC";

        switch (type) {
            case "price_asc":
                filter = "price"; sortType = "ASC"; break;
            case "price_desc":
                filter = "price"; break;
            case "name_az":
                filter = "product_name"; sortType = "ASC"; break;
            case "name_za":
                filter = "product_name"; break;
            case "oldest":
                filter = "is_new"; sortType = "ASC"; break;
            case "newest":
                filter = "is_new"; break;
        }

        return proDao.getProductsByFilter(filter, sortType);
    }
}
