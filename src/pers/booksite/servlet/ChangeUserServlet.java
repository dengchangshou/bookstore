package pers.booksite.servlet;

import pers.booksite.service.BookService;
import pers.booksite.service.ManagerService;
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

@WebServlet(name = "ChangeUserServlet", urlPatterns = "/ChangeUserServlet")
public class ChangeUserServlet extends HttpServlet {
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

        String account = request.getParameter("account");//123
        String preAccount = account;//123
        UserService userService = new UserService();
        ArrayList<User> allUsers = userService.getAllUsers();
        User user = new User();
        for(User u:allUsers){
//            System.out.println(u.getAccount());
            if(u.getAccount().equals(account)){
                user.setAccount(u.getAccount());
                user.setPassword(u.getPassword());
                break;
            }
        }
//        request.setAttribute("allUsers", allUsers);
        request.setAttribute("user", user);
        request.getRequestDispatcher("changeUser.jsp?preAccount=" + preAccount).forward(request,response);
    }
}

