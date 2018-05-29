<%@ page import="pers.booksite.vo.Book" %>
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
    <title>ChangeBook</title>
</head>
<body>
<div class="container">
    <%
        String preBookName = request.getParameter("preBookName");
//        System.out.println(preBookName);
        session.setAttribute("preBookName", preBookName);
//        request.setAttribute("preBookName", preBookName);
        session.setAttribute("op", "book");
        Book book = (Book)request.getAttribute("book");
    %>

    <form class="addBook" action="CommitChangeServlet" method="post">
        <div class="control-group">
            <label>书名</label>
            <div class="controls">
                <input type="text" name="bookName" value="<%=book.getBookName()%>"/>
            </div>
        </div>
        <div class="control-group">
            <label>作者</label>
            <div class="controls">
                <input type="text" name="author" value="<%=book.getAuthor()%>"/>
            </div>
        </div>
        <div class="control-group">
            <label>出版社</label>
            <div class="controls">
                <input type="text" name="publish" value="<%=book.getPublish()%>"/>
            </div>
        </div>
        <div class="control-group">
            <label>价格</label>
            <div class="controls">
                <input type="text" name="price" value="<%=String.format("%.2f",book.getPrice())%>"/>
            </div>
        </div>
        <div class="control-group">
            <label>图片(相对路径)</label>
            <div class="controls">
                <input type="text" name="bookImg" value="<%=book.getBookImg()%>"/>
            </div>
        </div>
        <div class="control-group">
            <label>内容简介</label>
            <div class="controls">
                <textarea name="bookIntroduce" cols="50" rows="5"><%=book.getBookIntroduce()%></textarea>
            </div>
        </div>
        <div class="control-group">
            <label>作者简介</label>
            <div class="controls">
                <textarea name="authorIntroduce" cols="50" rows="5"><%=book.getAuthorIntroduce()%></textarea>
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
