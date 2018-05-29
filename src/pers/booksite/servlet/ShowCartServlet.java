package pers.booksite.servlet;

import pers.booksite.service.CartService;
import pers.booksite.vo.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowCartServlet", urlPatterns = "/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理中文
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String userName = request.getAttribute("userName").toString();
//        System.out.println(userName);
        CartService cartService = new CartService();
        ArrayList<Cart> cart = new ArrayList<>();
        cart = cartService.showCart(userName);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("cart.jsp").forward(request,response);
    }
}

