package vn.edu.nlu.fit.controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.dao.AdminCategoryDAO;

import java.io.IOException;

@WebServlet(name = "AdminCategoryDelete", value = "/AdminCategoryDelete")
public class AdminCategoryDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");

        if (idStr != null) {
            int id = Integer.parseInt(idStr);

            AdminCategoryDAO dao = new AdminCategoryDAO();
            dao.deleteCategory(id);
        }

        response.sendRedirect(request.getContextPath() + "/AdminCategory");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}