package vn.edu.nlu.fit.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.model.Users;
import vn.edu.nlu.fit.services.UserService;

import java.io.IOException;

@WebServlet(name = "LoginControler", value = "/Trangchu-login")
public class LoginControler extends HttpServlet {
    private UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("TrangChu-daDNTK.jsp").forward(request, response);
    }

    //    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String  username = request.getParameter("username");
//            String password = request.getParameter("password");
//            if("012345678".equals(username) && "123".equals(password)){
//                response.sendRedirect("SanPham-TatCa.jsp");
//            }else{
//                request.setAttribute("error","invalid username or password");
//                request.getRequestDispatcher("TrangChu.jsp").forward(request, response  );
//            }
//    }
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Users user = userService.login(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect(request.getContextPath() + "/TrangChu-daDNTK.jsp");
        } else {
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            request.getRequestDispatcher("TrangChu-daDNTK.jsp").forward(request, response);
        }
    }
}