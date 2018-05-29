package pers.booksite.servlet;

import pers.booksite.service.BookService;
import pers.booksite.service.UserService;
import pers.booksite.vo.Book;
import pers.booksite.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;

@WebServlet(name = "ManagementServlet", urlPatterns = "/ManagementServlet")
public class ManagementServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 处理中文
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String op = request.getParameter("op");
        request.setAttribute("op", op);

        BookService bookService = new BookService();
        UserService userService = new UserService();
        ArrayList<Book> allBooks = bookService.getAllBooks();
        ArrayList<User> users = userService.getAllUsers();
        request.setAttribute("allBooks", allBooks);
        request.setAttribute("allUsers", users);
        if(op.equals("book"))
            request.getRequestDispatcher("managerBooks.jsp").forward(request,response);
        else
            request.getRequestDispatcher("managerUsers.jsp").forward(request,response);
    }
}

