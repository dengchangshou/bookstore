package pers.booksite.servlet;

import pers.booksite.vo.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerServlet", urlPatterns = "/ManagerServlet")
public class ManagerServlet extends HttpServlet {
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

        Manager manager = new Manager();
//        System.out.println(manager.getAccount());
//        System.out.println(manager.getPassword());
        if(manager.getAccount().equals(account)){
            if(manager.getPassword().equals(password)){//登录成功
                request.getRequestDispatcher("manager.jsp").forward(request, response);
            }else{
                request.setAttribute("message", "密码错误!");
                request.getRequestDispatcher("managerSignup.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("message", "用户不存在！");
            request.getRequestDispatcher("managerSignup.jsp").forward(request, response);
        }
    }
}
