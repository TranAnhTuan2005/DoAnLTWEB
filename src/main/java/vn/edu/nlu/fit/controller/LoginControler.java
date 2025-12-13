package vn.edu.nlu.fit.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginControler", value = "/Trangchu-login")
public class LoginControler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String  username = request.getParameter("username");
            String password = request.getParameter("password");
            if("tuan".equals(username) && "123".equals(password)){
                response.sendRedirect("SanPham-TatCa.jsp");
            }else{
                request.setAttribute("error","invalid username or password");
                request.getRequestDispatcher("TrangChu.jsp").forward(request, response);
            }
    }
}