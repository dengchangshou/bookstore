package pers.booksite.servlet;

import pers.booksite.service.UserService;
import pers.booksite.vo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignupServlet", urlPatterns = "/SignupServlet")
public class SignupServlet extends HttpServlet {
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
        if(userService.searchUsers(account) != null){ //账号存在, 验证
            user.setAccount(account);
            user.setPassword(password);
            try{
                pw = userService.confirmUser(user);
//                System.out.println(pw);//null
                if(pw == null){
                    request.setAttribute("message", "密码错误！");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }else {
                    request.setAttribute("user", account);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            request.setAttribute("message", "用户不存在！请先注册！");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
