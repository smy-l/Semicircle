# 6.9
## 复习
1. JDK>JRE>JVM
2. 环境变量是指命令行命令搜索到路径。`echo $PATH`
3. 选择JDK 8 及其以上版本，尽量选择LTS版本
4. 可以使用JAVA 处理网络数据的服务端，负责数据处理、保存、检索、统计。数据来源APP、Browser、Web等。
5. 编写Java代码需要 JDK环境
6. 详见basic/jdk.md
7. 可以使用`jshell`编写一些简单的命令(`/exit`退出)；<br>
   float型最大为3.4e38(可以存储那么大，但是只能保证6～7位准确)<br>
   double型最大为1.7e308(只能保证15～16位准确)

## 数据运算
1. 自增自减运算符
   例子：
   int a = 5; <br>
   a+++a;<br>
   相当于(a++)+a = 5 + 6 = 11;<br>
2. 浮点运算舍入误差
3. char可以作为数据进行运算(0~65535)
4. 运算符|说明
   :-:|:-:
   `^`|异或 //相同false，不同true
   `&`| 与
   `|`| 或
   `~`| 非/取反
   `>>>`| 无符号右移动
   `&&` | 左右两边只能是boolean
   `&` | 两边可以是boolean也可以是数值
5. `&&`存在短路现象，例如 false && (++b > 1)，++b将不会运算(不建议使用)<br>
   `&`不存在短路现象<br>
   `||`存在短路现象，例如 true || (++b > 1)，++b将不会运算<br>
   `|`不存在短路现象<br>
6. 三目运算符

## 数据类型转换
### 可以转换
byte -> short -> int -> long<br>
int -> double<br>
float -> double<br>
char -> int
### 精度缺失
int -> float<br>
long -> float<br>
long -> double<br>

### 规则
有一个数是double，则全部会转换为double；<br>
否则，有一个数是float，则全部转换为float；<br>
否则，有一个数是long，则全部转换为long；<br>
否则，全部数转换为int；<br>
两个short型进行计算会变成int型，不能在赋值给short型。如
```
 short Num1 = 1; 
 short Num2 = 2;
 short result = Num1 + Num2; //编译报错
 Num1 += Num2; //编译成功，相当于 Num1 = (short)(Num1 + Num2)
```

### 强制类型转换
(类型)数字/变量名

## 字符串拼接
```
String[] a = 123 + 213 + ""; //转换为字符串
```

## 程序流程控制

### 顺序结构

### 分支结构
```
if(){

}else if{

}else{

}
```
```
switch(choice){
    case()

        break;

    default:
        break;
}
```
### 循环结构
```
while(){

}
```
```
do{

}while()
```

## 方法/函数
方法传递的是值，对函数外部没有影响
```
int a = 5;
int b = 10;
swap(a,b);
System.out.printlf(a);
System.out.printlf(b);//输出仍然是5和10

int[] arr;
arr[0] = 5;
arr[1] = 10;
swap(arr[0],arr[1]);
System.out.printlf(arr[0]);
System.out.printlf(arr[1]);//输出仍然是5和10
```
传递引用数据类型可以更改
```
swap(int[] arr){
    int temp = arr[0];
    arr[0] = arr[1];
    arr[1] = temp;
}
```

### 方法重载
名称一致，传入的参数或者参数数量不同

### 局部变量
在一个函数下，不允许创建一个相同的变量

