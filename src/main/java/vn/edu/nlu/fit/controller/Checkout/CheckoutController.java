package vn.edu.nlu.fit.controller.Checkout;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.Cart.Cart;
import vn.edu.nlu.fit.dao.PaymentMethodDao;
import vn.edu.nlu.fit.model.PaymentMethods;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CheckoutController", value = "/Checkout-infor")
public class CheckoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart==null || cart.getTotalQuantity() ==0){ // giỏ hàng trống thì quay lại mua hàng
            response.sendRedirect("SanPham-TatCa.jsp");
            return;
        }

        //Lấy ds pttt lên
        PaymentMethodDao paymentDAO = new PaymentMethodDao();
        List<PaymentMethods> listPaymentMethods = paymentDAO.getAllPaymentMethods();
        request.setAttribute("listPaymentMethods", listPaymentMethods);


        request.getRequestDispatcher("ThongTinGiaoHang.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}