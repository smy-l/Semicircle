# HTTP

## http协议

***http://localhost:8080/web1_war_exploded/a.html***

***http://localhost:8080/web1_war_exploded/index.jsp***

localhost  ---  127.0.0.1

8080 端口

浏览器使用http协议，向127.0.0.1的8080端口发送一个请求

请求web1_war_exploeded目录下的a.html文件

tomcat去web1目录下寻找是否存在a.html文件，如果存在，将页面发送给浏览器

否则返回404错误代码