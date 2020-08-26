<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/8/24
  Time: 2:25 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.8.2.min.js"></script>
    <script>
        $(function () {
            // $.post("json.do","",function (result) {
            //     var jsonStr = "id:"+result.id +",loginName:"+result.loginName;
            //     $("#showJson").html(jsonStr);
            //     },"json");

            $.post("json.do","",function (result) {
                for(var i=0;i<result.length;i++){
                    var jsonStr = "id:"+result[i].id +",loginName:"+result[i].loginName+"<br/>";
                    $("#showJson").append(jsonStr);
                }
            },"json");
        })
    </script>
</head>
<body>
<div id="showJson"></div>
</body>
</html>
