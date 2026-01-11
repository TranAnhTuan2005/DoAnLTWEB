package vn.edu.nlu.fit.controller.Checkout;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.dao.PaymentMethodDao;
import vn.edu.nlu.fit.model.PaymentMethods;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PaymentMethodController", value = "/PaymentMethod")
public class PaymentMethodController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Lấy ds pttt lên
        PaymentMethodDao paymentDAO = new PaymentMethodDao();
        List<PaymentMethods> listPaymentMethods = paymentDAO.getAllPaymentMethods();
        request.setAttribute("listPaymentMethods", listPaymentMethods);
        request.getRequestDispatcher("PhuongThucThanhToan.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}