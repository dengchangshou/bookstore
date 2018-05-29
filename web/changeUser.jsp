<%@ page import="pers.booksite.vo.Book" %>
<%@ page import="pers.booksite.vo.User" %>
<%--
  Created by IntelliJ IDEA.
  User: rock
  Date: 18-5-24
  Time: 上午11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/addBooks.css">
    <title>ChangeUser</title>
</head>
<body>
<div class="container">
    <%
        String preAccount = request.getParameter("preAccount");
        session.setAttribute("preAccount", preAccount);
        session.setAttribute("op", "user");
        User user = (User) request.getAttribute("user");
    %>

    <form class="addBook" action="CommitChangeServlet" method="post">
        <div class="control-group">
            <label>账号</label>
            <div class="controls">
                <input type="text" name="account" value="<%=user.getAccount()%>"/>
            </div>
        </div>
        <div class="control-group">
            <label>密码</label>
            <div class="controls">
                <input type="text" name="password" value="<%=user.getPassword()%>"/>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <button class="btn" contenteditable="true" type="submit">确认修改</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
