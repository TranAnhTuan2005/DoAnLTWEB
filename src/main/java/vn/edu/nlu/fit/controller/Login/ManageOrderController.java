package vn.edu.nlu.fit.controller.Login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.dao.OrderDAO;
import vn.edu.nlu.fit.model.Orders;
import vn.edu.nlu.fit.model.Users;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManageOrderController", value = "/ManageOrders")
public class ManageOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("TrangDangNhapTK.jsp");
            return;
        }
        OrderDAO orderDAO = new OrderDAO();
        List<Orders> listOrders = orderDAO.getOrdersByUserId(user.getId());

        request.setAttribute("orders", listOrders);

        request.getRequestDispatcher("TaiKhoan-CoDonHang.jsp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}