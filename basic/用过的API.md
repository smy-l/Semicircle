# 用过的API(目光短浅ing)

## 1、toString
```
Arrays.toString(数组名)
	效果：将数组转换成字符串数组
	int a = {1,2,3,4,5}
	System.out.println(Arrays.toString(a));
	打印出来效果为  [1,2,3,4,5]
```

## 2、
```
Math.sqrt(16);  16开平方
Math.pow(2,3);  2的3次方
```

## List（数组）

### Iterator

```
//接口通用的遍历方式
Iterator<Integer> iterator = list.iterator();

 while (iterator.hasNext()) {
      System.out.println(iterator.next());
 }
```

### 对象.contains(变量)

```
查看对象是否包含变量，返回true
```

### A.removeif(条件)

```
按照要求删除A元素
```

### A.removeall(B)

```
取A中和B不同的元素
```

### A.retains(B)

```
取A和B交集
返回boolean值,有内容变化返回true，
```

