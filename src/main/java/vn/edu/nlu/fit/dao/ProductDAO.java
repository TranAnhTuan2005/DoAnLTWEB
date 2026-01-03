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

    public List<Products> getProductsByFilter(String filter, String sortType) {
        String sql = "select * from products order by <filter> <sortType>";
        return getJdbi().withHandle(h ->
                h.createQuery(sql).define("filter", filter).define("sortType", sortType).mapToBean(Products.class).list());
    }
}
