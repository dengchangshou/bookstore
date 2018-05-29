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

@WebServlet(name = "GetBooksServlet", urlPatterns = "/GetBooksServlet")
public class GetBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //判断GetBooksServlet是否被调用
//        System.out.println("GetBooksServlet 成功调用");
        String bookCategory = request.getParameter("category");
        ArrayList<Book> books;
        BookService bookService = new BookService();
        if(bookCategory.equals("random")){
            books = bookService.getRandomBooks();
        }else {
            books = bookService.getBooksByCategory(bookCategory);
        }
        if(books != null) {
            PrintWriter pw = response.getWriter();
            pw.write("<ul class=\"bookcontainer\" id=\"allbooks\">");
            for(Book b:books){
                pw.write("<li class=\"book\">" +
                                "<a href=\"javascript:void(0);\" onclick=\"showIntroduce('" + b.getBookName() + "')\">" +
                                "<img id=\"bookImg\" src="+b.getBookImg()+"></a>" +
                                "<p class=\"name\">" +
                                "<a href=\"javascript:void(0);\" onclick=\"showIntroduce('" + b.getBookName() + "')\" title=" + b.getBookName() + ">" + b.getBookName() + "</a></p>" +
                                "<p class=\"author\"" +
                                "<span class=\"author_t\"></span>" + b.getAuthor() + "</p>" +
                                "<p class=\"price\">" +
                                "<span class=\"rob\">" +
                                "<span class=\"sign\">¥ </span>" +
                                "<span class=\"num\">" + String.format("%.2f", b.getPrice()) +
                                " <a href=\"javascript:void(0);\" onclick=\"cart('" + b.getBookName() + "')\"><img src=\"img/cargo.png\" id=\"cargo\"></a>" +
                                "</span></span></p></li>");
            }
        }
    }
}
