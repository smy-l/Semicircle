# 6.8
## 安装jdk、切换jdk
### jdk版本
Oracle JDK  学习免费,商用收费 网址:*www.oracle.com/technetwork/java/javase/downloads/*<br>
Open JDK  开源,免费 网址*http://jdk.java.net/*<br>
国内Oracle镜像文件   *https://repo.huaweicloud.com/java/jdk*

### 环境变量
显示java安装路径  `java -verbose`<br>
echo $PATH  *显示路径*<br>
export PATH=$PATH:路径  *添加路径* <br>
例如:<br>
`export PATH=$PATH:~/Desktop`  *在最后加上路径*<br>
`export PATH=~/Desktop:$PATH`  *在最前面加上路径*<br>
但是每次仅限当前终端，并未完全修改，若要完全修改，则需要更改.bash_profile<br>

mac对Java有一定支持，在bash终端下可以在.bash_profile文件中使用一下命令<br>
`export JAVA_HOME=$(/usr/libexec/java_home -v 11)`

如果环境变量出现异常,使用命令<br>
```
export PATH=/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin
```

**具体步骤**
在终端中使用以下命令(仅限mac)
1. vi ~/.bash_profile
2. 在文件中粘贴`export JAVA_HOME=$(/usr/libexec/java_home -v 11)`
3. source .bash_profile

在终端中使用以下命令(linux、mac)
1. vi ~/.bash_profile
2. 在文件中粘贴java路径,例如`export PATH=$PATH:~/Desktop`
3. source .bash_profile


### 其他
JVM为java虚拟机，JRE为运行环境，JDK包含JRE，运行一定要安装JDK<br>
java不需要自己释放空间，有程序自动完成，这个机制被称为垃圾回收

## 数据类型
### 变量命名
变量名称允许使用中文，但是尽量不用<br>

好的命名：驼峰式命名<br>
***变量***<br>
一个单词，全部小写<br>
多个单词，第一个单词小写，其余单词首字母大写<br>
***类名***<br>
单词首字母全部大写

声明变量后，如果不初始化，java编译器不会通过

### 定义常量
使用final修饰；<br>
如果被赋值后，再次赋值会报错；即只能赋值一次

null只能对引用数据类型使用，不能对固定数据类型使用。

## 数组
### 数组创建
必须使用new来分配存储空间。<br>
new出来的区域都是初始化过的。

### 数组初始化
```
int[] arr = new int[]{1,2,3,4,5};
int arr[] = {1,2,3,4,5};
```
注：
```
int [] a = null;
a = new int[0];
```
malloc对分配的空间不进行初始化<br>
calloc对分配的空间进行初始化，全部置0

### 获取数组长度`.length`

arr.length

### 遍历数组
增强型for循环(不需要使用下标情况下使用)
```
for(int one : a){//one除a以外都可命名
    //one前一定要有数据类型
    System.out.println(one);
}
```

## 二维数组
创建二维数组
```
int[][] a = new int[3][];
```
可以将一个数组放到二维数组中，例如：<br>
```
a[2] = new int[20];
```
## 其他

数据默认类型为int

打印`System.out.println();`