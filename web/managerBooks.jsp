<%@ page import="pers.booksite.vo.Book" %>
<%@ page import="java.util.ArrayList" %>
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
    ArrayList<Book> allBooks = (ArrayList<Book>) request.getAttribute("allBooks");
%>
<tr>
    <td>ID</td>
    <td>书名</td>
    <td>作者</td>
    <td>出版社</td>
    <td>价格</td>
    <td><a href="addBook.jsp">添加</a></td>
</tr>
    <%
        for(Book book:allBooks){
    %>
<tr>
    <td><%=book.getBookID()%></td>
    <td><%=book.getBookName()%></td>
    <td><%=book.getAuthor()%></td>
    <td><%=book.getPublish()%></td>
    <td><%=String.format("%.2f",book.getPrice())%></td>
    <td><a href="DeleteBookServlet?bookName=<%=book.getBookName()%>">删除</a> <a href="ChangeBookServlet?bookName=<%=book.getBookName()%>">修改</a></td>
</tr>
    <%
        }
    %>
</table>
</body>
</html>