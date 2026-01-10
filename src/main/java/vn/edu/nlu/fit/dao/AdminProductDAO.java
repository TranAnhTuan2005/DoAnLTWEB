package vn.edu.nlu.fit.dao;

import vn.edu.nlu.fit.model.Products;

import java.util.List;

public class AdminProductDAO extends BaseDao{
    public List<Products> getAllProducts() {
        String sql = "SELECT p.id, p.product_name, p.image_url, p.price, p.quantity, c.category_name " +
                "FROM products p " +
                "JOIN products_categories pc ON p.id = pc.product_id " +
                "JOIN categories c ON pc.category_id = c.id " +
                "ORDER BY p.id DESC";

        return getJdbi().withHandle(h ->
                h.createQuery(sql)
                        .map((rs, context) -> new Products(
                                rs.getInt("id"),
                                rs.getString("product_name"),
                                rs.getDouble("price"),
                                rs.getString("image_url"),
                                rs.getInt("quantity"),
                                rs.getString("category_name")
                        ))
                        .list()
        );
    }
}
