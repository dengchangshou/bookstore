<%@ page import="pers.booksite.vo.Cart" %>
<%@ page import="pers.booksite.vo.Book" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: rock
  Date: 2018/5/27
  Time: 12:52
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
<div>
<table id="table" border="2">
    <%
        String userName = request.getParameter("userName");
        ArrayList<Cart> orderInfo = (ArrayList<Cart>) request.getAttribute("orderInfo");
        double totalPrice = 0;
    %>
    <tr>
        <td>书名</td>
        <td>单价</td>
        <td>数量</td>
        <td>总价</td>
    </tr>
    <%
        for(Cart c:orderInfo){
    %>
    <tr>
        <td><%=c.getBookName()%></td>
        <td><%=String.format("%.2f",c.getBookPrice())%></td>
        <td><%=c.getCount()%></td>
        <td><%=String.format("%.2f",c.getTotalPrice())%></td>
    </tr>
    <%
            totalPrice += c.getTotalPrice();
        }
    %>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td>合计：<%=String.format("%.2f",totalPrice)%></td>
    </tr>
</table>
</div>
<div class="shopping_total">
    <a href="index.jsp?user=<%=userName%>" id="goHome" style="float: right; padding: 20px;">返回书店</a>
</div>
</body>
</html>
