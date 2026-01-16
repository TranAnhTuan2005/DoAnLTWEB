package vn.edu.nlu.fit.controller.Login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.model.Orders;
import vn.edu.nlu.fit.model.Users;
import vn.edu.nlu.fit.services.OrderService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountController", value = "/TaiKhoanCuaBan")
public class AccountController extends HttpServlet {
    private OrderService orderService = new OrderService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Users user = (Users) session.getAttribute("user");

        // lấy đơn hàng theo user_id
        List<Orders> orders = orderService.getOrdersByUser(user.getId());

        request.setAttribute("orders", orders);

        // đã login → vào trang tài khoản
        request.getRequestDispatcher("/TaiKhoan-CoDonHang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}