package pers.booksite.servlet;

import pers.booksite.service.BookService;
import pers.booksite.service.ManagerService;
import pers.booksite.vo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "ChangeBookServlet", urlPatterns = "/ChangeBookServlet")
public class ChangeBookServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 处理中文
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String bookName = request.getParameter("bookName");
        String preBookName = bookName;
        BookService bookService = new BookService();
        ArrayList<Book> allBooks = bookService.getAllBooks();
        Book book = new Book();
        for(Book b:allBooks) {
            if (b.getBookName().equals(bookName)) {
                book.setBookName(b.getBookName());
                book.setAuthor(b.getAuthor());
                book.setPublish(b.getPublish());
                book.setPrice(b.getPrice());
                book.setBookImg(b.getBookImg());
                book.setBookIntroduce(b.getBookIntroduce());
                book.setAuthorIntroduce(b.getAuthorIntroduce());
                break;
            }
        }
        request.setAttribute("book", book);
        request.getRequestDispatcher("changeBook.jsp?preBookName=" + preBookName).forward(request,response);
    }
}
