package vn.edu.nlu.fit.controller.Login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.dao.OrderDAO;
import vn.edu.nlu.fit.model.Orders;
import vn.edu.nlu.fit.model.Users;
import vn.edu.nlu.fit.services.OrderService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AccountController", value = "/TaiKhoanCuaBan")
public class AccountController extends HttpServlet {
    //private OrderService orderService = new OrderService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Users user = (Users) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("TrangDangNhapTK.jsp");
            return;
        }
        OrderDAO orderDAO = new OrderDAO();
        List<Orders> listOrders = orderDAO.getOrdersByUserId(user.getId());
        listOrders.removeIf(order -> order.getOrderStatus() == 4);
        request.setAttribute("orders", listOrders);

        // đã login → vào trang tài khoản
        request.getRequestDispatcher("/TaiKhoan-CoDonHang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}