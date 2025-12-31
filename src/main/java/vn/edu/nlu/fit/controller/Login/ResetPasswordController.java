package vn.edu.nlu.fit.controller.Login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.model.Users;
import vn.edu.nlu.fit.services.UserService;

import java.io.IOException;

@WebServlet(name = "ResetPasswordController", value = "/ResetPassword")
public class ResetPasswordController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");

        Users user = userService.findByResetToken(token);
        if (user == null) {
            response.sendError(403);
            return;
        }

        request.setAttribute("token", token);
        request.getRequestDispatcher("DatLaiMatKhau.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        String newPassword = request.getParameter("password");

        userService.resetPasswordByToken(token, newPassword);
        response.sendRedirect("TrangChu.jsp");
    }
}