package vn.edu.nlu.fit.controller.productCategory;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.model.Products;
import vn.edu.nlu.fit.services.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet("/filter")
public class FilterProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sortType = request.getParameter("sort");

        ProductService proS = new ProductService();
        List<Products> list = proS.getProductsByFilter(sortType);

        request.setAttribute("list", list);
        request.setAttribute("selectedSort", sortType); //  Giữ nguyên sự lựa chọn trên menu
        request.getRequestDispatcher("SanPham-TatCa.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}