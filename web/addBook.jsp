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
    <title>AddBook</title>
</head>
<body>
<div class="container">
    <form class="addBook" action="AddBookServlet" method="post">
        <div class="control-group">
            <label>分类</label>
            <select class="ct" name="category">
                <option value="novel">小说</option>
                <option value="children">童书</option>
                <option value="education">教育</option>
                <option value="science">计算机</option>
                <option value="others">其他</option>
            </select>
        </div>
        <div class="control-group">
            <label>书名</label>
            <div class="controls">
                <input type="text" name="bookName" required/>
            </div>
        </div>
        <div class="control-group">
            <label>作者</label>
            <div class="controls">
                <input type="text" name="author" required/>
            </div>
        </div>
        <div class="control-group">
            <label>出版社</label>
            <div class="controls">
                <input type="text" name="publish" required/>
            </div>
        </div>
        <div class="control-group">
            <label>价格</label>
            <div class="controls">
                <input type="text" name="price" required/>
            </div>
        </div>
        <div class="control-group">
            <label>图片(相对路径)</label>
            <div class="controls">
                <input type="text" name="bookImg" required/>
            </div>
        </div>
        <div class="control-group">
            <label>内容简介</label>
            <div class="controls">
                <textarea name="bookIntroduce" cols="50" rows="5" required></textarea>
            </div>
        </div>
        <div class="control-group">
            <label>作者简介</label>
            <div class="controls">
                <textarea name="authorIntroduce" cols="50" rows="5" required></textarea>
            </div>
        </div>

        <div class="control-group">
            <div class="controls">
                <button class="btn" contenteditable="true" type="submit">确认添加</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
