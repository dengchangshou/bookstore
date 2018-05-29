package pers.booksite.servlet;

import pers.booksite.service.BookService;
import pers.booksite.service.CartService;
import pers.booksite.service.ManagerService;
import pers.booksite.vo.Book;
import pers.booksite.vo.Cart;
import pers.booksite.vo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CreateOrderServlet", urlPatterns = "/CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理中文
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String userName = request.getParameter("userName");

        Order order = new Order();
        order.setUserName(userName);
        CartService cartService = new CartService();
        ArrayList<Cart> carts = new ArrayList<>();
        carts = cartService.showCart(userName);
        cartService.createOrder(order, carts);
        request.setAttribute("userName", userName);
        request.getRequestDispatcher("ShowOrderServlet").forward(request, response);
    }
}
