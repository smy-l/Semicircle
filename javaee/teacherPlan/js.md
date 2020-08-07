js代码位置	

​		在<head>或者<body>中使用<script>

​		在独立js文件中，在html中使用<script src="js文件位置"></script>

​	案例：js1.html  js2.html js3.html



```
与Java区别：
1、 变量声明 var 变量名; 不考虑变量的类型
2、值得类型没有java的复杂：
    原始类型：数值，字符串，布尔，数组
    对象：Object 用{属性名1:值,属性名2:值}定义对象
3、undefined代表的是变量没有赋值的状态
4、函数定义
    function 函数名(参数列表){
        函数体;
        return 值
    }
    js中函数定义的时候，是没有返回值类型
    参数列表，也不需要写类型，只写参数名
    函数有返回值的时候，写return，否则不写
```

实例：js4.html

事件：

​	事件源，事件名，事件响应函数

​	常用事件：

​		onclick 鼠标单击事件---常见html元素

​		onmouseover\onmouseout : 鼠标移动元素上/鼠标从元素上移开 --- div image 块状元素

​		onchange ：元素状态发生改变  --- select 、checkbox、radio

​		onkeydown：键盘按键被按下  --- text

​		onload ： 页面加载完成  --- body

案例：js5.html



日期类型：

​	获取当前系统时间 new Date()

​	获取年月日时分秒

​	案例：js4.html



数组：js中数组类似于java中Map

​	初始化

​	push

​	循环遍历

案例：js6.html



js操作DOM（文档对象模型）

## HTML DOM（文档对象模型）

当网页被加载时，浏览器会创建页面的文档对象模型（*D*ocument *O*bject *M*odel）。

*HTML DOM* 模型被结构化为*对象树*：



## 查找 HTML 元素

| 方法                                    | 描述                   |
| :-------------------------------------- | :--------------------- |
| document.getElementById(*id*)           | 通过元素 id 来查找元素 |
| document.getElementsByTagName(*name*)   | 通过标签名来查找元素   |
| document.getElementsByClassName(*name*) | 通过类名来查找元素     |

document.getElementsByName 通过name属性来查找元素

案例：dom1.html dom2.html



## 改变 HTML 元素

| 方法                                       | 描述                   |
| :----------------------------------------- | :--------------------- |
| element.innerHTML = *new html content*     | 改变元素的 inner HTML  |
| element.attribute = *new value*            | 改变 HTML 元素的属性值 |
| element.setAttribute(*attribute*, *value*) | 改变 HTML 元素的属性值 |
| element.style.property = *new style*       | 改变 HTML 元素的样式   |

案例：dom1.html  dom3.html



## 添加和删除元素

| 方法                              | 描述             |
| :-------------------------------- | :--------------- |
| document.createElement(*element*) | 创建 HTML 元素   |
| document.removeChild(*element*)   | 删除 HTML 元素   |
| document.appendChild(*element*)   | 添加 HTML 元素   |
| document.replaceChild(*element*)  | 替换 HTML 元素   |
| document.write(*text*)            | 写入 HTML 输出流 |



## 添加事件处理程序

| 方法                                                     | 描述                            |
| :------------------------------------------------------- | :------------------------------ |
| document.getElementById(id).onclick = function(){*code*} | 向 onclick 事件添加事件处理程序 |

案例：dom4.html



BOM

location.href   案例bom1.html

setTimeout  案例：bom2.html

setInterval  案例：bom3.html



正则表达

/正则表达式/修饰符.test(zi字符串)

案例：regex.html

