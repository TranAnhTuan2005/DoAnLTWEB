package vn.edu.nlu.fit.dao;

import vn.edu.nlu.fit.model.Categories;

import java.util.List;

public class AdminCategoryDAO extends BaseDao{
    public List<Categories> getAll() {
        return getJdbi().withHandle(h ->
                h.createQuery("SELECT * FROM categories")
                        .mapToBean(Categories.class)
                        .list()
        );
    }

    public int countProductByCategoryID(int categoryID) {
        return getJdbi().withHandle(handle ->
                handle.createQuery("SELECT COUNT(*) FROM products_categories WHERE category_id = :categoryID")
                        .bind("categoryID", categoryID)
                        .mapTo(Integer.class)
                        .one()
        );
    }
}
