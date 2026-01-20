package vn.edu.nlu.fit.controller.cart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.model.Products;
import vn.edu.nlu.fit.services.ProductService;
import vn.edu.nlu.fit.Cart.Cart;

import java.io.IOException;

@WebServlet(name = "addCart", value = "/addCart")
public class AddCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        int quantity=Integer.parseInt(request.getParameter("quantity"));
        ProductService productService=new ProductService();
        Products product= productService.getDetail(id);
        if(product == null){
            response.sendRedirect( request.getContextPath() +"/SanPham-TatCa");
            return;
        }

        HttpSession session=request.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart==null){
            cart = new Cart();
        }
        cart.addItem(product,quantity);
        session.setAttribute("cart", cart);
        // lấy trang đang đứng
        String previousPage = request.getHeader("referer");
        if (previousPage != null) {
            response.sendRedirect(previousPage);
        } else {
            response.sendRedirect("/TrangChu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}