package pers.booksite.servlet;

import pers.booksite.service.CartService;
import pers.booksite.vo.Cart;
import pers.booksite.vo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ShowOrderServlet", urlPatterns = "/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理中文
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String userName;
        if(request.getParameter("userName") == null){
            userName = request.getAttribute("userName").toString();
        }else {
            userName = request.getParameter("userName");
        }
        CartService cartService = new CartService();
        ArrayList<Cart> orderInfo = new ArrayList<>();
        orderInfo = cartService.showOrder(userName);
        request.setAttribute("orderInfo", orderInfo);
        request.getRequestDispatcher("showOrder.jsp?userName=" + userName).forward(request, response);
    }
}