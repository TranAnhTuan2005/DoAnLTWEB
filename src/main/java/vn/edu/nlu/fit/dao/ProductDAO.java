package vn.edu.nlu.fit.dao;

import org.jdbi.v3.core.statement.PreparedBatch;
import vn.edu.nlu.fit.model.Products;


import java.util.*;


public class ProductDAO extends BaseDao {

    //lấy 1 sp theo id 
    public Products findById(int id) {
        return getJdbi().withHandle(h ->
                h.createQuery("""
                            select *
                            from products
                            where id = :id""").bind("id", id).mapToBean(Products.class).findOne().orElse(null)
        );
    }


    //lay du lieu ra
    public List<Products> getListProduct() {
        return getJdbi().withHandle(h ->
                h.createQuery("select * from products").mapToBean(Products.class).list());
    }

    public Products getProduct(int id) {
        return getJdbi().withHandle(h ->
                h.createQuery("select * from products where id=:id").bind("id", id).
                        mapToBean(Products.class).stream().findFirst().orElse(null));
    }

    public void insertProduct(List<Products> products) {

        // jdbi.useHandle() -> không trả về kết quả -> dùng khi câu sql insert, update, delete
        // jdbi.withHandle() -> dùng khi câu sql là select

        //viết theo lamda function
        getJdbi().useHandle(handle -> {
            //dùng hàm prepareBatch() khi muốn insert nhiều dòng
            //dùng hàm createUpdate() khi muốn insert một dòng
            PreparedBatch preparedBatch = handle.prepareBatch("insert into products values(:id,:name,:img,:price)");

            products.forEach(product -> {
                preparedBatch.bindBean(product).add();
            });
            preparedBatch.execute();
        });
    }

    public List<Products> getProductsByFilter(int categoryID, String sortType) {
        String sql = "select p.* from products p";
        if (categoryID > 0)
            sql += " join products_categories pc on p.id = pc.product_id where pc.category_id = :categoryID ";

        switch (sortType != null ? sortType : "") {
            case "price_asc":
                sql += " order by p.price ASC";
                break;
            case "price_desc":
                sql += " order by p.price DESC";
                break;
            case "name_az":
                sql += " order by p.product_name ASC";
                break;
            case "name_za":
                sql += " order by p.product_name DESC";
                break;
            case "oldest":
                sql += " order by p.id ASC";
                break;
            case "newest":
                sql += " order by p.id DESC";
                break;
            default:
                sql += " order by p.id DESC";
                break;
        }

        String finalSql = sql;
        return getJdbi().withHandle(h -> {
            var query = h.createQuery(finalSql);
            if (categoryID > 0) {
                query.bind("categoryID", categoryID);
            }
            return query.mapToBean(Products.class).list();
        });
    }

}
