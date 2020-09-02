<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/7/21
  Time: 9:38 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- enctype="multipart/form-data为上传文档内容的编码方式 -->
<form action="/upload" method="post" enctype="multipart/form-data">
    选择文件：<input type="file" name="uploadFile"/>
    <br/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
