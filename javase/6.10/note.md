# 6.10
## 面向对象
C语言 -> 汇编语言 -> 机器码<br>
Java语言 -> 字节码(JVM) -> 机器码<br>

C和Java面形对象差异在于封装<br>
C语言无法对对象数据进行保护，java有保护措施--封装<br>

类 class<br>
对象 object<br>

引用数据类默认初始化为null<br>
boolean默认初始化为false<br>


## package(包路径)(让jvm找到)
package + 包名(一定是第一句话)<br>
类名变为 包名.类名<br>
声明类在哪个个包路径下。<br>

## import(优化类的录入)
import<br>
一定要放在package下面,作用是引入不同包路径下的类。<br>
例如：
```
Asia.Elephant

有import后
可以直接写成
Elephant
```

## .class和.java分开
```
javac -d out 文件名.java

切换到out文件夹下，使用
java 文件名  //系统默认的classpath为当前文件夹

如果不切换到out文件夹下，需使用
java  -classpath  out(class文件所在路径)  文件名
java  -classpath  out:out1(不在一个文件夹下使用:分割)  文件名

-classpath 可以简写为 -cp 如：
java  -cp  out:out1(不在一个文件夹下使用:分割)  文件名(若有包路径，需要添加包路径，中间使用.分隔)
```

## 几种访问权限
权限修饰符|任何类 | 子类 | 同包的类 | 类的内部
:-:|:-:|:-:|:-:|:-:
public | ☑️ | ☑️ | ☑️ | ☑️
protect|   | ☑️ | ☑️ | ☑️
不写|  |  | ☑️ | ☑️
private|  |  | | ☑️


