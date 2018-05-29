<%--
  Created by IntelliJ IDEA.
  User: rock
  Date: 18-5-22
  Time: 下午9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.sql.*, java.util.*" %>
<%@page import="pers.booksite.dao.UserDao" %>
<%@page import="pers.booksite.vo.User" %>
<%@ page import="pers.booksite.servlet.SigninServlet" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>登录/注册</title>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/sign.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form id="userForm" class="form-signin" method="post" action="ManagerServlet">
        <h2 class="form-signin-heading">管理员登录界面</h2>
        <label for="inputAccount" class="sr-only">Account</label>
        <input type="text" id="inputAccount" class="form-control" placeholder="admin" required="" autofocus="" name="account">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="admin" required="" name="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>
    <%
        Object message = request.getAttribute("message");
        if(message != null){
    %>
    <script type="text/javascript">
        alert("<%=message%>");
    </script>
    <%
        }
    %>
</div>
</body>
</html>

