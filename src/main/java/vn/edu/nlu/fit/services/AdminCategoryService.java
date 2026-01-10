package vn.edu.nlu.fit.services;

import vn.edu.nlu.fit.dao.AdminCategoryDAO;
import vn.edu.nlu.fit.model.Categories;

import java.util.List;

public class AdminCategoryService {
    AdminCategoryDAO dao = new AdminCategoryDAO();

    public List<Categories> getListForManage() {
        List<Categories> list = dao.getAll();

        for (Categories c : list) {
            int count = dao.countProductByCategoryID(c.getId());
            c.setTotalProducts(count);
        }

        return list;
    }
}
