<%--
  Created by IntelliJ IDEA.
  User: rock
  Date: 2018/4/12
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="pers.booksite.vo.Book" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="./img/bookstore.ico" type="image/x-icon" />
    <link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/booksite.css">
    <script src="js/manager.js"></script>
    <script src="jQuery.js"></script>
    <%
        String op = "book";
        if(request.getAttribute("op") != null)
            op = request.getAttribute("op").toString();
    %>
    <script>window.onload = manager("<%=op%>")</script>
    <title>admin</title>
</head>
<body>
<nav id="nav" class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav">
                    <li style="margin-top: 15px">admin</li>
                    <li><a href="index.jsp">退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<!--左侧-->
<div id="category-1" class="category">
    <h3>管理</h3>
    <ul class="nav nav-sidebar">
        <li><a href="javascript:void(0);" onclick="manager('book')">图书管理</a></li>
        <li><a href="javascript:void(0);" onclick="manager('user')">用户管理</a></li>
    </ul>
</div>

<!--右侧-->
<div class="content" id="info">

</div>
</body>
</html>

