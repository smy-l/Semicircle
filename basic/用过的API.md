# 用过的API和一些方法

## 1. Math
```
Math.sqrt(16);  16开平方
Math.pow(2,3);  2的3次方
Math.max
Math.min
Math.abs (绝对值)
Math.ceil (向上取整)
Math.floor (向下取整)
Math.round (四舍五入)
Math.random (取随机数)
```

## 2. String

### toStirng

```
Arrays.toString(数组名)
	效果：将数组转换成字符串数组
	int a = {1,2,3,4,5}
	System.out.println(Arrays.toString(a));
	打印出来效果为  [1,2,3,4,5]
```

### A.compareTo(B)

1. 比较A和B，返回值为***数字***，是A和B的差值；
2. 只能比较***引用数据类型***，不能比较基本数据类型
3. 比较字符串的时候，如果短的字符串包含在长的字符串里，返回的是两个字符串的长度的差值
4. 如果不一致，则找到第一个不同的字符，返回其差值

### A.contains(B)

```
查看对象是否包含变量，返回boolean值，包含为true，否则为false
```

## 3. 集合(Set)

要求，A和B都是Set

### A.removeif(条件)

作用：按照要求删除A元素

```
比较复杂，一般使用lambda表达式
```

### A.removeall(B)

作用：取A中和B不同的元素,即取差集

```
将不同的元素赋值给A（会改变A中的元素）
返回值为boolean类型
如果A中的元素发生变化，返回true，没有变换则返回false
```

### A.retains(B)

作用：取A和B交集

```
将不同的元素赋值给A（会改变A中的元素）
返回值为boolean类型
如果A中的元素发生变化，返回true，没有变换则返回false
```

### A.contains(elem)

作用：判断A中是否包含elem元素

```
elem为集合A的一个类型的变量，如果A中包含elem，则返回true
```

### A.containsAll(B)

作用：判断集合A中是否包含集合B中所有元素

```
如果A包含B，则返回true，否则返回false
不会改变A中的元素
```

## Iterator

```
//接口通用的遍历方式
Iterator<Integer> iterator = list.iterator();

 while (iterator.hasNext()) {
      System.out.println(iterator.next());
 }
```

