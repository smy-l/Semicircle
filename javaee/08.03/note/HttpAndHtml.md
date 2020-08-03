# HTTP and HTML

## http协议

***http://localhost:8080/web1_war_exploded/a.html***

***http://localhost:8080/web1_war_exploded/index.jsp***

localhost  ---  127.0.0.1

8080 端口

浏览器使用http协议，向127.0.0.1的8080端口发送一个请求

请求web1_war_exploeded目录下的a.html文件

tomcat去web1目录下寻找是否存在a.html文件，如果存在，将页面发送给浏览器

否则返回404错误代码

## 什么是HTML？

- HTML 指的是超文本标记语言(**H**yper **T**ext **M**arkup **L**anguage)用来描述网页

HTML 标签
HTML 标记标签通常被称为 HTML 标签 (HTML tag)。
HTML 标签是由尖括号包围的关键词，比如 <html>
HTML 标签通常是成对出现的，比如 &amp;b&amp; 和 </b>
标签对中的第一个标签是开始标签，第二个标签是结束标签

# 基本的 HTML 标签

## HTML 标题

HTML 标题（Heading）是通过 <h1> - <h6> 等标签进行定义的。

```html
<h1>h1h1h1h1h1h</h1>
<h2>h2h2h2h2h2h</h2>
<h3>h3h3h3h3h3h3</h3>
<h6>h6h6h6h66hh6h6</h6>
```

## HTML 段落

HTML 段落是通过 <p> 标签进行定义的。



## HTML 链接

HTML 链接是通过 <a> 标签进行定义的。

```html
<a href="http://www.baidu.com">百度，绝对路径（带ip，域名，访问外部网站资源）</a>
<br/>
<a href="b.html">a和b在同一级目录下,地址写文件名，相对路径(访问站内资源，不需要写ip，域名)</a>
<br/>
```

## HTML 图像

HTML 图像是通过 <img> 标签进行定义的。

```html
<img src="w3school.jpg" width="104" height="142" />
```

