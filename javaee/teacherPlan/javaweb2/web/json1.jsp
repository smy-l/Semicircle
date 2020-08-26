<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/8/24
  Time: 11:09 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
        $(function () {
            var user = {
                "id" : 1,
                "name" : "张三",
                "pwd" : "000"
            };
            $("#objectDiv").append("ID：" + user.id + "<br>")
                .append("用户名：" + user.name + "<br>")
                .append("密码：" + user.pwd + "<br>");

            var ary = [ "中", "美", "俄" ];

            var $ary = $(ary);
            var $ul = $("#arrayUl"); // 展示数据的ul元素
            $ary.each(function() { $ul.append("<li>"+this+"</li>"); });

            var $sel = $("#arraySel"); // 展示数据的select元素
            $ary.each(function (i) {
                $sel.append("<option value='"+(i+1)+"'>"+this+"</option>");
            });

            var userArray = [
                { "id" : 2,
                "name" : "admin",
                "pwd" : "123" },
                {
                "id" : 3,
                "name" : "詹姆斯",
                "pwd" : "11111" },
                {
                "id" : 4,
                "name" : "梅西",
                    "pwd" : "6666"
                } ];

            // alert(userArray.length);
            // for(var i=0;i<userArray.length;i++){
            //     var str = userArray[i].id+"   "+userArray[i].name
            //     + "  "+userArray[i].pwd;
            //     alert(str);
            // }

            var $table = $("<table border='1'></table>").append(
                "<tr><td>ID</td><td>用户名</td><td>密码</td></tr>");

            $(userArray).each(function() { $table.append("<tr><td>" + this.id + "</td><td>"
                + this.name + "</td><td>" + this.pwd + "</td></tr>");
            });

            $("#objectArrayDiv").append($table);
        })
    </script>
</head>
<body>
<div id="objectDiv"></div><br>
<ul id="arrayUl"></ul>
<select id="arraySel"></select>
<div id="objectArrayDiv"></div>
</body>
</html>
