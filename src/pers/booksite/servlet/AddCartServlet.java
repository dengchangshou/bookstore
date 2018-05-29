package pers.booksite.servlet;

import pers.booksite.service.BookService;
import pers.booksite.service.CartService;
import pers.booksite.service.ManagerService;
import pers.booksite.vo.Book;
import pers.booksite.vo.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "AddCartServlet", urlPatterns = "/AddCartServlet")
public class AddCartServlet extends HttpServlet {
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

        Cart cart = new Cart();
        CartService cartService = new CartService();
        BookService bookService = new BookService();
        ArrayList<Book> allBooks = new ArrayList<>();
        ArrayList<Cart> carts = new ArrayList<>();
        carts = cartService.showCart(userName);
        allBooks = bookService.getAllBooks();

//        System.out.println(bookName);
//        System.out.println(userName);
        if(bookName != ""){
            for(Book b:allBooks){
                if(b.getBookName().equals(bookName)){
                    cart.setBookName(bookName);
                    cart.setBookImg(b.getBookImg());
                    cart.setBookPrice(b.getPrice());
                    cart.setUser(userName);
                    for(Cart c:carts){
                        if(c.getBookName().equals(bookName)){ //购物车中已有书
                            cart.setTotalPrice((c.getCount() + 1) * c.getBookPrice());
                            break;
                        }
                    }
                    cart.setCount(1);
                    cart.setTotalPrice(b.getPrice());
                    break;
                }
            }
            cartService.addCart(cart);
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("ShowCartServlet").forward(request, response);
        }else if(carts.isEmpty()){
            PrintWriter pw = response.getWriter();
            pw.write("你的购物车里什么都没有.......");
            pw.write("<a href=\"index.jsp?user=" + userName + "\" id=\"goHome\">返回书店</a>");
        }else {
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("ShowCartServlet").forward(request, response);
        }
    }
}

