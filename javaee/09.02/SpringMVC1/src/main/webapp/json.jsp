<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/9/2
  Time: 10:39 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.11.1.min.js"></script>
    <script>
        $(function(){
            $("#btn").click(function () {
                $.post("/json1","param=value",function (result) {
                    for(var i=0;i<result.length;i++) {
                        alert(result[i].province + "  " + result[i].city);
                    }
                },"json");
            });
        });
    </script>
</head>
<body>
<input type="button" id="btn" value="提交"/>
</body>
</html>
