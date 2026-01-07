package vn.edu.nlu.fit.controller.cart;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.google.gson.Gson;
import vn.edu.nlu.fit.Cart.CartItem;
import vn.edu.nlu.fit.Cart.Cart;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UpdateQuantityInCart", value = "/UpdateQuantityInCart")
public class UpdateQuantityInCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        HttpSession session = request.getSession();//lấy giỏ hàng
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart!=null){
            cart.update(productId, quantity);
            session.setAttribute("cart", cart);

            CartItem item = cart.getCartItem(productId);
            Map<String, Object> result = new HashMap<>();
            result.put("itemTotal", item.getTotal()); // Tổng tiền của riêng món đó
            result.put("cartTotal", cart.getTotal()); // Tổng tiền cả giỏ hàng
            result.put("totalQuantity", cart.getTotalQuantity()); // Tổng số lượng SP

            //Gửi JSON về cho trình duyệt
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new Gson().toJson(result));
        }
    }
}