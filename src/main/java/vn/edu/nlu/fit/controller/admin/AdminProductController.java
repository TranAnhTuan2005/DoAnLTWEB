package vn.edu.nlu.fit.controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.model.Products;
import vn.edu.nlu.fit.services.AdminProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminProductController", value = "/AdminProductController")
public class AdminProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminProductService service = new AdminProductService();

        List<Products> list = service.getAll();
        request.setAttribute("listProduct", list);
        request.getRequestDispatcher("Admin-QuanLySanPham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}