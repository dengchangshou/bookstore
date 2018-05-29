<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: rock
  Date: 2018/4/12
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="./img/bookstore.ico" type="image/x-icon" />
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/booksite.css">
    <script src="js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/showBooks.js"></script>
    <script src="js/showIntroduce.js"></script>
    <script src="js/initHomePage.js"></script>
    <script charset="UTF-8" src="js/cart.js"></script>
    <script src="jQuery.js"></script>
    <script>window.onload = initHomePage()</script>
    <title>booksite</title>

</head>
<body>
<!--头部-->
<%
    String user = "登录/注册";
    String userOut = "";
    String welcome = "";
    if(request.getAttribute("user") != null || request.getParameter("user") != null){
        welcome = "Welcome,";
        userOut = "退出";
        if(request.getAttribute("user") != null)
            user = request.getAttribute("user").toString();
        else
            user = request.getParameter("user");
    }
%>
<nav id="nav" class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="javascript:void(0);" onclick="orderInfo()">订 单</a></li>
                <li><a href="javascript:void(0);" onclick="cart('')">购物车</a></li>
                <li><a href="managerSignup.jsp">管理员入口</a></li>
                <li><a href="javascript:void(0);" style="padding-right:  0px;"><%=welcome%></a></li>
                <li><a href="login.jsp"  id="userName" style="padding-left:  0px;"><%=user%></a></li>
                <li><a href="index.jsp"  id="userOut"><%=userOut%></a></li>
            </ul>
        </div>
    </div>
</nav>

<div id="cart">
<!--左侧-->
<%
    if(request.getParameter("click") != null){
%>
<script>onload = cart('')</script>
<%
    }
%>
<div class="category">
    <h3>图书分类</h3>
    <%--<ul>--%>
    <ul class="nav nav-sidebar">
        <li><a href="javascript:void(0);" onclick="showBooks('novel')" name="novel">小说</a></li>
        <li><a href="javascript:void(0);" onclick="showBooks('children')" name="children">童书</a></li>
        <li><a href="javascript:void(0);" onclick="showBooks('education')" name="education">教育</a></li>
        <li><a href="javascript:void(0);" onclick="showBooks('science')" name="science">计算机</a></li>
        <li><a href="javascript:void(0);" onclick="showBooks('others')" name="others">其他</a></li>
    </ul>
</div>

<!--右侧-->
<div class="content" id="books">

</div>
</div>
</body>
</html>

