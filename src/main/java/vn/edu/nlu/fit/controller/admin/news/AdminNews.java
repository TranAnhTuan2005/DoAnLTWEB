package vn.edu.nlu.fit.controller.admin.news;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.model.News;
import vn.edu.nlu.fit.services.AdminNewsService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminNews", value = "/AdminNews")
public class AdminNews extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminNewsService service = new AdminNewsService();
        List<News> list = service.getAll();

        request.setAttribute("listNews", list);
        request.getRequestDispatcher("Admin-BaiViet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}