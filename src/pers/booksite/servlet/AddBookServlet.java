package pers.booksite.servlet;

import pers.booksite.service.ManagerService;
import pers.booksite.vo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddBookServlet", urlPatterns = "/AddBookServlet")
public class AddBookServlet extends HttpServlet {
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // 处理中文
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");

            ManagerService managerService = new ManagerService();
            Book book = new Book();
            book.setBookName(request.getParameter("bookName"));
            book.setAuthor(request.getParameter("author"));
            book.setPublish(request.getParameter("publish"));
            double price = Double.valueOf(request.getParameter("price"));
            book.setPrice(price);
            book.setBookImg(request.getParameter("bookImg"));
            book.setBookIntroduce(request.getParameter("bookIntroduce"));
            book.setAuthorIntroduce(request.getParameter("authorIntroduce"));
            String category = request.getParameter("category");
            managerService.addBook(book, category);
            request.getRequestDispatcher("manager.jsp").forward(request,response);
        }
}
