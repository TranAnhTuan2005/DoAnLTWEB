package vn.edu.nlu.fit.services;

import vn.edu.nlu.fit.dao.AdminProductDAO;
import vn.edu.nlu.fit.model.Products;

import java.util.List;

public class AdminProductService {
    AdminProductDAO dao = new AdminProductDAO();

    public List<Products> getAll() {
        return dao.getAllProducts();
    }
}
