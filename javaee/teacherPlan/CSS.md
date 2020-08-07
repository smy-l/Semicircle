- CSS 指层叠样式表 (*C*ascading *S*tyle *S*heets)

- 样式定义*如何显示* HTML 元素

为了*解决内容与表现分离的问题*

- *外部样式表*可以极大提高工作效率



### 层叠次序

**当同一个 HTML 元素被不止一个样式定义时，会使用哪个样式呢？**

1. 浏览器缺省设置
2. 外部样式表
3. 内部样式表（位于 <head> 标签内部）
4. 内联样式（在 HTML 元素内部）





# 如何创建 CSS

### 内联样式

在相关的标签内使用样式（style）属性。Style 属性可以包含任何 CSS 属性。

将表现和内容混杂在一起

仅需要在一个元素上应用一次时

### 内部样式表

<style> 标签在文档头部定义内部样式表

### 外部样式表

```html
<head>
<link rel="stylesheet" type="text/css" href="mystyle.css" />
</head>
```

```
CSS 语法
CSS 规则由两个主要的部分构成：选择器，以及一条或多条声明。
selector {declaration1; declaration2; ... declarationN }
```

id选择器 >class选择器> 标签选择器  

案例：css1.html



## 派生选择器

**通过依据元素在其位置的上下文关系来定义样式，你可以使标记更加简洁。**

## 选择器的分组

被分组的选择器就可以分享相同的样式

案例：css2.html

background   案例：css3.html

文本，字体  案例：css4.html

表格： 案例css5.html

margin，框大小计算：css6.html

定位：relative（相对于原始位置） absolute(相对于父元素(已经被relative定位)定位)

案例：css7.html

定位：float（left、right）清除浮动（clear：both 让后面的元素另起一行）

先用一个父框定大小，里面再用浮动布局 案例：css8.HTML

