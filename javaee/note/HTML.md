# HTML

## 什么是HTML？

- HTML 指的是超文本标记语言(**H**yper **T**ext **M**arkup **L**anguage)用来描述网页

HTML 标签
HTML 标记标签通常被称为 HTML 标签 (HTML tag)。
HTML 标签是由尖括号包围的关键词，比如 \<html\>
HTML 标签通常是成对出现的，比如 &amp;b&amp; 和 \</b\>
标签对中的第一个标签是开始标签，第二个标签是结束标签

# 基本的 HTML 标签

## HTML 标题

HTML 标题（Heading）是通过 \<h1\> - \<h6\> 等标签进行定义的。

```html
<h1>h1h1h1h1h1h</h1>
<h2>h2h2h2h2h2h</h2>
<h3>h3h3h3h3h3h3</h3>
<h6>h6h6h6h66hh6h6</h6>
```

## HTML \<p\>(段落)

HTML 段落是通过 \<p\> 标签进行定义的。

```html
<p>第一段内容</p>
<p>第二段内容</p>
<p>段落间距(p)比行间距(br/)大</p>
```

## HTML \<a\>(链接)

HTML 链接是通过 \<a\> 标签进行定义的。

```html
<a href="http://www.baidu.com">百度，绝对路径（带ip，域名，访问外部网站资源）</a>
<br/>
<a href="b.html">a和b在同一级目录下,地址写文件名，相对路径(访问站内资源，不需要写ip，域名)</a>
<br/>
<a href="http://www.baidu.com" target="_blank">百度(新标签页)</a>
<br/>
```

## HTML \<img\>(图像)

HTML 图像是通过 \<img\> 标签进行定义的。

图片是在当前页面中的子目录中，地址：子目录/文件名   子目录/.../文件名

alt="信息"  当图片无法正常显示的时候，将显示"信息",告诉用户缺失了什么信息

```html
<img src="w3school.jpg" width="104" height="142" />
<img src="images/picture.png" width="384" height="216" alt="图片信息">
```

## HTML \<hr/\>(水平线)

使用\<hr/\>表示

```html
<hr/>
```

## HTML \<!-- --\>(注释)

HTML注释(生成页面的时候会将注释删除)

```html
<!-- This is a comment -->
```

## HTML href(锚链接)

1. 在超链接\<a\>中使用`href="#关键字"`表示
2. 在需要进行跳转的地方进行命名，命名语句`<a name="关键字"></a>`
3. 如果在不同网页下，需要在关键字`#`号的前加上访问文件的路径

```html
<a href="#chapter1">第一章</a> <br/>
<a href="#chapter2">第二章</a> <br/>
<a href="#chapter3">第三章</a> <br/>
<a href="#ending">结尾</a> <br/>

<!-- 在同一网页下 -->
<a name="chapter1"></a><h2 style="color: green">第一章</h2>
<a name="chapter2"></a><h2 style="color: yellow">第二章</h2>
<a name="chapter3"></a><h2 style="color: orange">第三章</h2>
<a name="ending"></a><h2 style="color: red">结尾</h2>

<!-- 在不同网页下 -->
<a href="b.html#chapter1">第一章</a> <br/>
<a href="b.html#chapter2">第二章</a> <br/>
<a href="b.html#chapter3">第三章</a> <br/>
<a href="b.html#ending">结尾</a> <br/>
```

## HTML 多级目录

```html
<a href="folder1/d.html">d.html</a> <br/>
<a href="folder1/folder2/e.html">e.html</a>
```

## HTML \<table\>(表格)

1. 使用`<table></table>`进行表示
2. `<tr></tr>`表示一行，`<td></td>`表示一列
3. `<th></th>`表示列名称
4. `&nbsp` 使得表格中内容为空
5. `colspan`跨列合并
6. `rowspan`跨行合并
7. 该表格只能是举行

```html
<!-- 使用&nbsp可以使表格内容为空，如2行1列 -->
<table border="3px" width="600px" height="200px">
    <tr>
        <th>第一列</th>
        <th>第二列</th>
        <th>第三列</th>
        <th>第四列</th>
    </tr>
    <tr>
        <td colspan="3">1,1/1,2/1,3 跨列合并</td>
<!--        <td>1,2</td>-->
<!--        <td>1,3</td>-->
        <td rowspan="2">1,4/2,4 跨行合并</td>
    </tr>
    <tr>
        <td colspan="2" rowspan="2">2,1/2,2/3,1/3,2合并</td>
<!--        <td>2,2</td>-->
        <td>2,3</td>
<!--        <td>2,4</td>-->
    </tr>
    <tr>
<!--        <td>3,1</td>-->
<!--        <td>3,2</td>-->
        <td>3,3</td>
        <td>3,4</td>
    </tr>
</table>
```

## HTML 列表

1. 无序表，使用`<ul></ul>`
2. 有序表，使用`<ol></ol>`
3. 其中，使用`<li><li>`表示里面具体内容，无序表没有编号，有序表有编号

### 定义列表

1. 使用`<dl></dl>`表示
2. 其中，使用`<dt></dt>`表示标题，使用`<dd></dd>`表示描述
3. 一个标题可以有多个描述

```html
<!--无序表--> <!--使用较少-->
<ul>
    <li>coffee</li>
    <li>milk</li>
</ul>

<!--有序表-->
<h3>有序表</h3>
<ol>
    <li>coffee</li>
    <li>milk</li>
</ol>

<!--定义列表-->
<h2>定义列表</h2>
<dl>
    <dt>标题</dt>
        <dd>描述1</dd>
        <dd>描述2</dd>
    <dt>牛奶(示例)</dt>
        <dd>品牌：蒙牛</dd>
        <dd>生产日期：2020/8/3</dd>
</dl>
```

## HTML iframe(页面嵌套)

1. 一个页面嵌套另一个页面
2. 使用`<iframe src="网页地址"></iframe>`
3. `frameborder="0"`表示删除边框
4. `name`对其进行命名

```html
<ul>
    <li><a href="http://www.baidu.com" target="iframe1">百度</a> </li>
    <li><a href="http://www.jd.com" target="iframe1">京东</a> </li>
</ul>
<iframe src="http://www.baidu.com" width="100%" height="400px"
        frameborder="0"
        name="iframe1"></iframe>
```

## HTML form(表单)

1. `action=""`引号中填写***服务器端地址，一段java代码，用来处理表单数据(value属性)***
2. `method=""`引号中填写***post/get 表单数据提交到服务器的方式方法***

### form中input类型

1. 表单元素一定要放在form中，否则用户输入的数据无法读取
2. `text`表示文本
3. `password`表示密码
4. `radio`表示单选按钮，同一组单选按钮name属性保持一致
5. `checkbox`表示多选按钮，同一组多选按钮name属性保持一致
6. `submit`提交按钮
7. `button`默认无用处，需要编写代码(js)，给它一个指定任务
8. `reset` 重置按钮，清空我们输入元素里的内容

```html
<form action="服务器端地址，一段java代码，用来处理表单数据(value属性)"
      method="post/get 表单数据提交到服务器的方式方法">
    <p>将数据存储到value中，将value发送给服务器端</p>
    用户名：<input type="text" name="username" value="默认值"/>
    <br/>

    密码：<input type="password" name="password"/>
    <br/>

    <p>多选一：同一组的单选按钮name属性保持一致</p>
  <p>checked 将某一属性值设置为默认</p>
    性别：<input type="radio" name="sex" value="male" checked/>男
         <input type="radio" name="sex" value="female"/> 女
    <br/>

    <p>多选：同一组的多选按钮name属性也要保持一致</p>
    兴趣(多选)：
    <input type="checkbox" name="fav" value=""/>球类
    <input type="checkbox" name="fav" value=""/>阅读
    <input type="checkbox" name="fav" value=""/>影视
    <br/>
    <input type="submit" value="按钮显示的文本" />
    <input type="button" value="默认无用处，需要编写代码(js)，给它一个指定任务"/>
  	<input type="reset" value="重置，将所有元素状态恢复到默认值">
</form>
```

## HTML fieldset(组合表单中相关数据)

1. filedset 组合表单中的相关数据
2. legend 元素为 fieldset 元素定义标题。

```html
<form>
    <fieldset>
        <legend>Personal information:</legend>
        First name:<br>
        <input type="text" name="firstname" value="Mickey">
        <br>
        Last name:<br>
        <input type="text" name="lastname" value="Mouse">
        <br><br>
        <input type="submit" value="Submit">
    </fieldset>
</form>
```

## HTML select(下拉列表)

1. 使用`<select></select>`表示
2. 使用`<option></option>`来增加select的选项
3. `<option>` 中使用`selected`来定义预定义选项，即一开始的默认选项

### select中属性

1. size: 页面中同时显示多少个选项
2. multiple: 默认select是多选一的，加上multiple，就可以多选(需要配合command(mac)/ctrl(windows)键)

```html
<form>
<select name="cars" size="5" multiple>
<option value="volvo">Volvo</option>
<option value="saab">Saab</option>
<option value="fiat" selected>Fiat</option>
<option value="audi">Audi</option>
</select>
<br><br>
<input type="submit">
</form>
```

## HTML textarea(文本域)

1. 使用`<textarea></textarea>`表示
2. 和文本框的区别是：多行输入的，文本框只能是一行
3. `rows=""`表示行数
4. `cols=""`表示列数

```html
<textarea name="message" rows="10" cols="30">
The cat was playing in the garden.
</textarea>
```

## HTML 表单属性

1. readonly 属性规定输入字段为只读属性
2. disabled 属性规定输入字段是禁用的
   1. 被禁用的元素是不可用和不可点击的。
   2. 被禁用的元素不会被提交。
3. *size* 属性规定输入字段的尺寸（以字符计）
4. *maxlength* 属性规定输入字段允许的最大长度(以字符计)

