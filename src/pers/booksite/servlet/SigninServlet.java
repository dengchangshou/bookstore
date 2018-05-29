package pers.booksite.servlet;

import pers.booksite.dao.UserDao;
import pers.booksite.service.BookService;
import pers.booksite.service.UserService;
import pers.booksite.vo.User;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SigninServlet", urlPatterns = "/SigninServlet")
public class SigninServlet extends HttpServlet {
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
        //获取表单数据
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        String pw = null;
        UserService userService = new UserService();
        User user = new User();
        try{
            pw = userService.searchUsers(account);//查找用户
            if(pw == null){//用户不存在，注册
                user.setAccount(account);
                user.setPassword(password);
                try{
                    userService.addUser(user);
                    request.setAttribute("user", account);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{//注册失败，返回注册页面
                request.setAttribute("message", pw);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }catch (Exception e){

        }
    }
}
