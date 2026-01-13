package vn.edu.nlu.fit.controller.Login;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.model.Users;
import vn.edu.nlu.fit.services.UserService;

import java.io.IOException;

@WebServlet(name = "LoginControler", value = "/DangNhapTaiKhoan")
public class LoginControler extends HttpServlet {
    private UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/TrangDangNhapTK.jsp").forward(request, response);
    }

    //    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("email");
        String password = request.getParameter("password");

        Users user = userService.login(username, password);

        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);

            // redirect về sevlet trang chủ
            response.sendRedirect(request.getContextPath() + "/TrangChu");

        } else {
            request.setAttribute("error", "Sai email hoặc mật khẩu");

            // quay lại TRANG ĐĂNG NHẬP
            request.getRequestDispatcher("/TrangDangNhapTK.jsp")
                    .forward(request, response);
        }
    }
}