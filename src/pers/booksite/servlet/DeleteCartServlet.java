package pers.booksite.servlet;

import pers.booksite.service.CartService;
import pers.booksite.vo.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCartServlet", urlPatterns = "/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理中文
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String bookName = request.getParameter("bookName");
        String userName = request.getParameter("userName");
//        System.out.println(bookName);
//        System.out.println(userName);
        Cart cart = new Cart();
        CartService cartService = new CartService();
        cartService.deleteBook(userName, bookName);
        request.setAttribute("bookName", "");
        request.setAttribute("userName", userName);
        request.getRequestDispatcher("index.jsp?user=" + userName + "&click=true").forward(request, response);
    }
}

