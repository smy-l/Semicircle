## 什么是 HTML？

- HTML 指的是超文本标记语言 (**H**yper **T**ext **M**arkup **L**anguage)用来描述网页



HTML 标签
HTML 标记标签通常被称为 HTML 标签 (HTML tag)。
HTML 标签是由尖括号包围的关键词，比如 <html>
HTML 标签通常是成对出现的，比如 &amp;b&amp; 和 </b>
标签对中的第一个标签是开始标签，第二个标签是结束标签

# 基本的 HTML 标签

## HTML 标题

HTML 标题（Heading）是通过 <h1> - <h6> 等标签进行定义的。

h1 用作主标题（最重要的），其后是 h2（次重要的），再其次是 h3，以此类推

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

## target 属性

使用 Target 属性，你可以定义被链接的文档在何处显示。

```html
<a href="http://www.baidu.com">百度，绝对路径（带ip，域名，访问外部网站资源）</a>
<br/>
<a href="http://www.baidu.com" target="_blank">在新的标签页中，显示百度首页</a>
<br/>
<a href="b.html">a和b在同一级目录下,地址写文件名，相对路径(访问站内资源，不需要写ip，域名)</a>

```

### 命名锚的语法：

```html
<a name="label">锚（显示在页面上的文本）</a>
```

在同一个文档中创建指向该锚的链接：

```html
<a href="#label">有用的提示</a>
```

在其他页面中创建指向该锚的链接

```html
<a href="html_links.asp#label">有用的提示</a>
```



## HTML 图像

HTML 图像是通过 <img> 标签进行定义的。

```html
<img src="w3school.jpg" width="104" height="142" />
```

在浏览器无法载入图像时，替换文本属性告诉读者她们失去的信息。此时，浏览器将显示这个替代性的文本而不是图像。

```html
<img src="images/baidu.png" alt="百度logo" />
```



## HTML 水平线

<hr /> 标签在 HTML 页面中创建水平线。

hr 元素可用于分隔内容。

## HTML 注释

可以将注释插入 HTML 代码中，这样可以提高其可读性，使代码更易被人理解。浏览器会忽略注释，也不会显示它们。

注释是这样写的：

### 实例

```html
<!-- This is a comment -->
```

表格：table.html

iframe ： frame.html



## <head> 元素

<head> 元素是所有头部元素的容器。

可以添加到 head 部分：<title>、<base>、<link>、<meta>、<script> 以及 <style>

##  <title> 元素

<title> 标签定义文档的标题。