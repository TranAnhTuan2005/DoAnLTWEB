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

    public List<Products> getProductsByFilter(String stringCategoryID, String sortType) {
        int categoryID = 0;
        try {
            if (stringCategoryID != null) categoryID = Integer.parseInt(stringCategoryID);
        } catch (NumberFormatException e) {
            categoryID = 0;
        }

        // Gọi DAO
        return proDao.getProductsByFilter(categoryID, sortType);
    }
}
