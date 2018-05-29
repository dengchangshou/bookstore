<%@ page import="pers.booksite.vo.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pers.booksite.vo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: rock
  Date: 2018/5/25
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap-table.css">
    <script src="js/jquery.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="bootstrap/js/bootstrap-table.js"></script>
    <script src="bootstrap/js/bootstrap-table-zh-CN.js"></script>
    <link rel="stylesheet" href="css/management.css">
</head>
<body>
<table id="table" border="2">
    <%
        ArrayList<User> allUsers = (ArrayList<User>) request.getAttribute("allUsers");
    %>
    <tr>
        <td>账号</td>
        <td>密码</td>
        <td><a href="addUser.jsp">添加</a></td>
    </tr>
    <%
        for(User user:allUsers){
    %>
    <tr>
        <td><%=user.getAccount()%></td>
        <td><%=user.getPassword()%></td>
        <td><a href="DeleteUserServlet?account=<%=user.getAccount()%>">删除</a> <a href="ChangeUserServlet?account=<%=user.getAccount()%>">修改</a></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>