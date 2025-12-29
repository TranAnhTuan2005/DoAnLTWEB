package vn.edu.nlu.fit.controller.cart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.nlu.fit.Cart.CartItem;
import vn.edu.nlu.fit.model.Products;
import vn.edu.nlu.fit.services.ProductService;
import vn.edu.nlu.fit.Cart.Cart;

import java.io.IOException;

@WebServlet(name = "DelCart", value = "/DelCart")
public class DelCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        ProductService productService=new ProductService();
        Products product= productService.getDetail(id);
        HttpSession session = request.getSession();
        Cart c = (Cart) session.getAttribute("cart");
        CartItem cartItem = c.deleteItem(id);
        if(cartItem==null){
        //
        }
        response.sendRedirect("cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}