package pers.booksite.servlet;

import pers.booksite.service.BookService;
import pers.booksite.vo.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "BookIntroduceServlet", urlPatterns = "/BookIntroduceServlet")
public class BookIntroduceServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //判断GetBooksServlet是否被调用
//        System.out.println("BookIntroduceServlet 成功调用");
        String bk = request.getParameter("bk");
        BookService bookService = new BookService();
        ArrayList<Book> allBooks = bookService.getAllBooks();
        if(allBooks != null) {
            PrintWriter pw = response.getWriter();
            for(Book b:allBooks){
                if(b.getBookName().equals(bk))
                {
                    pw.write("<img id=\"bookImg1\" src="+b.getBookImg()+">" +
                            "<div id=\"bookIntroduction\" class=\"section\">" +
                            "       <div class=\"title\"><span>内容简介</span></div>" +
                            "       <div class=\"descrip\"><span id=\"content-show\">" +
                                    b.getBookIntroduce() +
                            "       </span></div>" +
                            "</div>" +
                            "<div id=\"authorIntroduction\" class=\"section\">" +
                            "       <div class=\"title\"><span>作者简介</span></div>" +
                            "       <div class=\"descrip\"><span id=\"content-show\">" +
                                    b.getAuthorIntroduce() +
                            "       </span></div>" +
                            "</div>");
                    break;
                }
            }
        }
    }
}
