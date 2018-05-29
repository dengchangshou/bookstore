package pers.booksite.servlet;

import pers.booksite.service.ManagerService;
import pers.booksite.vo.Book;
import pers.booksite.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CommitChangeServlet", urlPatterns = "/CommitChangeServlet")
public class CommitChangeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理中文
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String op = request.getSession().getAttribute("op").toString();
        ManagerService managerService = new ManagerService();
        if(op.equals("book")){
            Book book = new Book();
            book.setBookName(request.getParameter("bookName"));
            book.setAuthor(request.getParameter("author"));
            book.setPublish(request.getParameter("publish"));
            double price = Double.valueOf(request.getParameter("price"));
            book.setPrice(price);
            book.setBookImg(request.getParameter("bookImg"));
            book.setBookIntroduce(request.getParameter("bookIntroduce"));
            book.setAuthorIntroduce(request.getParameter("authorIntroduce"));
            String preBookName = request.getSession().getAttribute("preBookName").toString();
            managerService.updateBook(book, preBookName);
        }
        if(op.equals("user")){
            User user = new User();
            user.setAccount(request.getParameter("account"));
            user.setPassword(request.getParameter("password"));
            String preAccount = request.getSession().getAttribute("preAccount").toString();
//            System.out.println(preAccount);
//            System.out.println(user.getAccount());
            managerService.updateUser(user, preAccount);
        }
        request.getRequestDispatcher("manager.jsp?op="+op).forward(request,response);
    }
}

