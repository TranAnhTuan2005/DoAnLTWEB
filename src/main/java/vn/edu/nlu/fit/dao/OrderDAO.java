package vn.edu.nlu.fit.dao;

import vn.edu.nlu.fit.model.Orders;

import java.util.List;

public class OrderDAO extends BaseDao {

       //tìm user id tướng ứng vs  order_date hiện sp đã đặt
    public List<Orders> findByUserId(int userId) {
        String sql = """
                    SELECT *
                    FROM orders
                    WHERE user_id = :userId
                    ORDER BY order_date DESC
                """;

        return getJdbi().withHandle(h ->
                h.createQuery(sql)
                        .bind("userId", userId)
                        .mapToBean(Orders.class)
                        .list()
        );
    }

}
