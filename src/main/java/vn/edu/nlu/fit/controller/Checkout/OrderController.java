package vn.edu.nlu.fit.controller.Checkout;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.Cart.Cart;

import java.io.IOException;
import java.util.Random;

@WebServlet(name = "OrderController", value = "/Order")
public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        //lấy pttt và ptvc
        String paymentId = request.getParameter("paymentId");
        String deliveryId = request.getParameter("shippingId");

        // lấy từ hàm dopost đã vết bên checkoutcontroller
        String name = (String) session.getAttribute("order_name");
        String phone = (String) session.getAttribute("order_phone");
        String address = (String) session.getAttribute("order_address");
        String email = (String) session.getAttribute("order_email");

        //guwirr dl đi
        request.setAttribute("customerName", name);
        request.setAttribute("customerPhone", phone);
        request.setAttribute("customerEmail", email);
        request.setAttribute("customerAddress", address);

        //tạm thời xài mã random
        Random rand = new Random();
        int orderId = 100000 + rand.nextInt(900000);
        request.setAttribute("orderId", "#" + orderId);

        //gửi giỏ hàng sang request để jsp hiển thị lần cuối
        request.setAttribute("finalCart", cart);
        //mua xong xóa đi
        session.removeAttribute("cart");

        //chuyển trang
        request.getRequestDispatcher("DatHangThanhCong.jsp").forward(request, response);
    }
}