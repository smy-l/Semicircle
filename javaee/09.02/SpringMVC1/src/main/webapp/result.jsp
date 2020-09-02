<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/9/1
  Time: 11:01 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>result.jsp</h1>
<img src="images/bg.jpg"/>
<br/>
${requestScope.reqAttr}
<br/>
${sessionScope.sessionAttr}
<br/>
${applicationScope.appAttr}
<hr/>
${requestScope.modelAttr}
</body>
</html>
