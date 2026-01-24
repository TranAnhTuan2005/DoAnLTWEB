package vn.edu.nlu.fit.controller.admin.news;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.services.AdminNewsService;

import java.io.IOException;

@WebServlet(name = "AdminNewsDelete", value = "/AdminNewsDelete")
public class AdminNewsDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id != null) {
            new AdminNewsService().delete(Integer.parseInt(id));
        }
        response.sendRedirect("AdminNews");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}