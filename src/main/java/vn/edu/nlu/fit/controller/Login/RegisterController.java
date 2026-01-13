package vn.edu.nlu.fit.controller.Login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.model.Users;
import vn.edu.nlu.fit.services.UserService;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/TaoTaiKhoan")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/TaoTaiKhoan.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("fullName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");

        try {
            UserService userService = new UserService();
            userService.register(name, email, phoneNumber, password, birthday);

        // đăng nhập luôn sau khi đăng ký
            Users user = userService.login(email, password);

        // lưu user vào session
            request.getSession().setAttribute("user", user);

        // quay về trang chủ
            response.sendRedirect(request.getContextPath() + "/TrangChu");

        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/TaoTaiKhoan")
                    .forward(request, response);
        }
    }
}