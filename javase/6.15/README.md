## 6.15

### note

1. 常用类
   1. System
   2. Math
   3. String
   4. Random
   5. java.util包

### practice

#### 1.设计一个方法，可以实现获取任意范围内的随机数。包括负数，例如输入randomInt(-10,5)

```
int randomInt(int from, int to){
}
```

链接：https://github.com/smy-l/Semicircle/blob/master/javase/6.15/src/practice6_15/club/banyuan/myRandom

#### 2.定义一个StringBuffer类对象, 对外提供方法接收字符串或字符，通过一个方法将之前接收到的字符拼接到一起返回

```
/**
    接收字符串
*/
void append(String str)
```

```
/**
    接收字符
*/
void append(Char str)
```

```
/**
将之前接收到的字符拼接到一起返回
*/
String toString()
```

```
/**
清除之前的而输入内容
*/
void clear()
```

```
/**
将之前的输入内容反转
*/
String reverse()
```

```
/**
将指定位置的字符串反转
from 从0起始
to 不包含在内
即[from,to)
例如 abcdefg => reverse(1,3) => acbdefg
*/
String reverse(int from, int to)
```

#### 3. 编写一个程序，将下面的一段文本中的各个单词的字母顺序翻转，

“To be or not to be"，将变成"oT eb ro ton ot eb."。

链接：https://github.com/smy-l/Semicircle/tree/master/javase/6.15/src/practice6_15/club/banyuan/stringBuffer