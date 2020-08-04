# CSS概述

- CSS 指层叠样式表(**C**ascading **S**tyle **S**heets)
- 样式定义**如何显示** HTML 元素
- 样式通常存储在 HTML 表中
- 解决内容与表现分离的问题
- **外部样式表**可以极大提高工作效率
- 外部样式表通常存储在 **CSS** 文件中
- 多个样式定义可**层叠**为一

## 层叠次序

**当同一个 HTML 元素被不止一个样式定义时，会使用哪个样式呢？**

1. 浏览器缺省设置
2. 外部样式表
3. 内部样式表（位于 \<head\> 标签内部）(页内)
4. 内联样式（在 HTML 元素内部）(行内)

## 如何创建CSS

### 内联样式

1. 在相关的标签内使用样式（style）属性。Style 属性可以包含任何 CSS 属性。
2. 将表现和内容混杂在一起
3. 仅需要在一个元素上应用一次时

```html
<p>默认样式，浏览器给予的样式</p>
<p style="color: sienna; margin-left: 20px">
    内联样式，写在标签的style属性中，作用范围仅限于这个标签里的内容
</p>
```

### 内部样式表

1. 使用 \<style\> 标签在文档头部定义内部样式表

```html
<style type="text/css">
        p{
            font-size: 30px;
          	color: blue;
        }
</style>
```

### 外部样式表

创建css文件

```css
p{
    font-style: italic;
    color: red;
}
```

**调用**(在head标签中使用\<link\>来调用)

```html
<!-- 调用 -->
<link href="css/mystyle.css"rel="stylesheet" type="text/css">
```

## CSS 语法

CSS 规则由两个主要的部分构成：选择器，以及一条或多条声明。

```css
selector {declaration1; declaration2; ... declarationN}
```

## id选择器

1. 样式的 id 选择器 --- 仅对当前这一个标签
2. id 还用来表示当前标签的唯一标识符
3. name属性：可以重复
4. id属性：不可以重复

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>css</title>
    <link href="css/mystyle.css"rel="stylesheet" type="text/css">
    <style type="text/css">
        #p1{
            color: blueviolet;
        }
    </style>
</head>
<body>
<p id="p1">
    样式的 id 选择器 --- 仅对当前这一个标签 <br/>
    id 还用来表示当前标签的唯一标识符 <br/>
    name属性：可以重复 <br/>
    id属性：不可以重复
</p>

</body>
</html>
```

## 类选择器

```css
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>css</title>
    <link href="css/mystyle.css"rel="stylesheet" type="text/css">
    <style type="text/css">
        .center{
            text-align: center;
        }
        .left{
            text-align: left;
        }
    </style>
</head>
<body>

<p class="center">
    class 选择器
</p>

<h1 class="left">h1h1h1</h1>

</body>
</html>
```

id选择器>类选择器>标签选择器

## 派生选择器

**通过依据元素在其位置的上下文关系来定义样式**

## 选择器的分组

你可以对选择器进行分组，这样，被分组的选择器就可以分享相同的声明。用逗号将需要分组的选择器分开。

