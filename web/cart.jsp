<%@ page import="pers.booksite.vo.Cart" %>
<%@ page import="pers.booksite.vo.Book" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: rock
  Date: 2018/5/26
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/cart.css">
    <script charset="UTF-8" src="js/cart.js"></script>
    <title>购物车</title>

</head>
<body style="padding-bottom:82px">
<%
    ArrayList<Cart> carts = (ArrayList<Cart>) request.getAttribute("cart");
%>
<div class="w960" id="cart">
    <ul class="shopping_title" id="j_carttitle">
        <li class="f1"><a id="j_selectall" href="javascript:void(0)" class="checknow fn-checkall check_on" dd_name="全选">选中</a>全选</li>
        <li class="f2">商品信息</li>
        <li class="f3">单价（元）</li>
        <li class="f4">数量</li>
        <li class="f4">金额（元）</li>
        <li class="f5">操作</li>
    </ul>

    <div class="fn-shops" id="J_cartContent">
        <div class="fn-shop">
            <%
                double total = 0;
                for(Cart c:carts){
                    total += c.getTotalPrice();
            %>
            <div class="shopping_list">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <td class="row1">
                    <a href="javascript:void(0)" class="checknow">选中</a>
                </td>
                <td class="row_img">
                    <a href="javascript:void(0)">
                    <img src="<%=c.getBookImg()%>" width="80" height="80">
                    </a>
                </td>
                <td class="row_name">
                    <div class="name">
                        <a href="javascript:void(0)" id="bookName"><%=c.getBookName()%></a>
                    </div>
                </td>
                <td class="row3">
                    <span>¥<%=String.format("%.2f",c.getBookPrice())%></span>
                </td>
                <td data-minbuy="0" class="fn-count-tip row3 ">
                    <span class="amount fn-updatecount " data-value="1">
                        <%=c.getCount()%>
                        <%--<a dd_name="减少数量" href="javascript:void(0)">-</a>--%>
                        <%--<input id="changeCount" value="<%=c.getCount()%>" type="text">--%>
                        <%--<a dd_name="增加数量" href="javascript:void(0)">+</a>--%>
                    </span>
                </td>
                <td class="row4">
                    <span class="red">¥<%=String.format("%.2f",c.getTotalPrice())%></span>
                </td>
                <td class="row5 ">
                <span>
                    <a href="DeleteCartServlet?userName=<%=c.getUser()%>&bookName=<%=c.getBookName()%>" class="fn-remove-product" >删除</a>
                </span>
                </td>
                </tbody>
                </table>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>

<div style="position: static; bottom: -20px; z-index: 101; width: 100%; left: 0px;">
    <div class="shopping_total" id="J_totalMoneyBlock">
        <div class="shopping_total_right">
            <%--CreateOrderServlet?userName=<%=carts.get(0).getUser()%>--%>
            <a class="total_btn fn-checkout" href="javascript:void(0)" onclick="createOrder()" id="checkout_btn" dd_name="结算">结&nbsp;&nbsp;算</a>
            <div class="subtotal">
                <p style="width: 120px"><span class="cartsum">总计：</span><span id="payAmount" class="price">¥<%=String.format("%.2f", total)%></span></p>
            </div>
        </div>
        <div class="shopping_total_left" id="J_leftBar">
            <a id="j_selectall2" href="javascript:void(0)" class="checknow fn-checkall check_on" dd_name="全选">选中</a>全选
            <span>已选择<font color="red"><%=carts.size()%></font>件商品</span>
        </div>
    </div>
</div>

<div class="shopping_total">
    <a href="index.jsp?user=<%=carts.get(0).getUser()%>" id="goHome">返回书店</a>
</div>
</body>
</html>
