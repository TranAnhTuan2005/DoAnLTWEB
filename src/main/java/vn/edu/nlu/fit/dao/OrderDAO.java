package vn.edu.nlu.fit.dao;

import vn.edu.nlu.fit.Cart.Cart;
import vn.edu.nlu.fit.Cart.CartItem;
import java.sql.Timestamp;

public class OrderDAO extends BaseDao {

    public int createOrder(String name, String phone, String email, String address,
                           int deliveryId, int paymentId, double totalMoney, Integer userId, Cart cart) {

        return getJdbi().inTransaction(handle -> {
            try {
                String sqlOrder = "INSERT INTO orders " +
                        "(fullname, phone, email, total, order_date, order_address, order_status, user_id, delivery_method_id, payment_method_id) " +
                        "VALUES " +
                        "(:name, :phone, :email, :total, :date, :address, :status, :userId, :deliveryId, :paymentId)";

                int orderId = handle.createUpdate(sqlOrder)
                        .bind("name", name)
                        .bind("phone", phone)
                        .bind("email", email)
                        .bind("total", totalMoney)
                        .bind("date", new Timestamp(System.currentTimeMillis()))
                        .bind("address", address)
                        .bind("status", 1)
                        .bind("userId", userId)
                        .bind("deliveryId", deliveryId)
                        .bind("paymentId", paymentId)
                        .executeAndReturnGeneratedKeys("id")
                        .mapTo(Integer.class)
                        .one();

                String sqlDetail = "INSERT INTO products_orders " +
                        "(order_id, product_id, quantity, price_at_time) " +
                        "VALUES " +
                        "(:orderId, :productId, :quantity, :price)";

                for (CartItem item : cart.getItem()) {
                    handle.createUpdate(sqlDetail)
                            .bind("orderId", orderId)
                            .bind("productId", item.getProduct().getId())
                            .bind("quantity", item.getQuantity())
                            .bind("price", item.getProduct().getPrice())
                            .execute();
                }
                return orderId;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Lỗi tạo đơn hàng: " + e.getMessage());
            }
        });
    }
}