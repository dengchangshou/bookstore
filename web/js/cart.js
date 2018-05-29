function cart(bookName)
{
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    var userOut = document.getElementById("userOut").innerHTML.toString();
    var userName = document.getElementById("userName").innerHTML;
    // if(bookName == "delete")
    // var bookName = document.getElementById("bookName").innerHTML;
    if(userOut == ""){
        window.location.href="login.jsp";
    }else {
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("cart").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET", "AddCartServlet?bookName=" + bookName + "&userName=" + userName, true);
        xmlhttp.send();
    }
}

function orderInfo()
{
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    var userOut = document.getElementById("userOut").innerHTML.toString();
    var userName = document.getElementById("userName").innerHTML;
    if(userOut == ""){
        window.location.href="login.jsp";
    }else {
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("cart").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET", "ShowOrderServlet?userName=" + userName, true);
        xmlhttp.send();
    }
}

function createOrder()
{
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    var userOut = document.getElementById("userOut").innerHTML.toString();
    var userName = document.getElementById("userName").innerHTML;
    // if(bookName == "delete")
    // var bookName = document.getElementById("bookName").innerHTML;
    if(userOut == ""){
        window.location.href="login.jsp";
    }else {
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("cart").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("GET", "CreateOrderServlet?userName=" + userName, true);
        xmlhttp.send();
    }
}
