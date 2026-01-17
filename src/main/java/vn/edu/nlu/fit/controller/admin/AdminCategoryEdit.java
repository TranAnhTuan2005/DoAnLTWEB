package vn.edu.nlu.fit.controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.dao.AdminCategoryDAO;
import vn.edu.nlu.fit.model.Categories;

import java.io.IOException;

@WebServlet(name = "AdminCategoryEdit", value = "/AdminCategoryEdit")
public class AdminCategoryEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);

        AdminCategoryDAO dao = new AdminCategoryDAO();
        Categories c = dao.getCategoryById(id);

        request.setAttribute("cate", c);

        request.getRequestDispatcher("Admin-QuanLyDanhMuc-ChinhSua.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("categoryName");
        int status = Integer.parseInt(request.getParameter("status"));

        AdminCategoryDAO dao = new AdminCategoryDAO();
        dao.updateCategory(id, name, status);

        response.sendRedirect(request.getContextPath() + "/AdminCategory");
    }
}