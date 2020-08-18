<%@ page import="java.util.List" %>
<%@ page import="club.banyuan.pojo.Product" %><%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/8/18
  Time: 2:11 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品查询结果</title>
</head>
<body>
<%
    List<Product> productList = (List<Product>) request.getAttribute("productList");
    for (Product product : productList) {
        out.println(product.getId() + "   " + product.getName() + "<br/>");
    }
%>
</body>
</html>
