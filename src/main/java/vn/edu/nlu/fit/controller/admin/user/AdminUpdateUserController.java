package vn.edu.nlu.fit.controller.admin.user;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.services.UserService;

import java.io.IOException;

@WebServlet(name = "AdminUpdateUserController", value = "/AdminUpdateUser")
public class AdminUpdateUserController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fullName = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String status = request.getParameter("status");

        boolean active = "active".equals(status);

        userService.updateUser(id, fullName, phone, active);

        response.sendRedirect(request.getContextPath() + "/AdminUser");
    }
}