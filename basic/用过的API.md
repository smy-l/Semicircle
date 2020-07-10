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

## 2. System.

### arraycopy

```
System.arraycopy(原数组, 起始位置, 要复制到的数组, 起始位置, 复制几个);
```

### currentTimeMillis();

```
System.currentTimeMillis(); //获取当前时间到1970年1月1日的毫秒值，返回Long类型的数字。
```

## 3. String

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

### A.ToCharArray()

```
将A字符串转换成char数组
```

### A.subString(int begin);

```
// 截取字符串，从begin位置开始截取

A.subString(int begin, int end)
// 从begin开始到end结束
```

### A.lastIndexOf(String s);

```
// 返回最后一次出现s的第一个字符的下标
```

A.IndexOf(String s);

```
// 返回第一次出现s的第一个字符的下标
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

### forEach();

```

```



### Iterator

```
//接口通用的遍历方式
Iterator<Integer> iterator = list.iterator();

 while (iterator.hasNext()) {
 //一定要调用一次iterator.next();
      System.out.println(iterator.next());  //打印
 }
 
 //使用for循环的方式删除set元素，会出现问题
 //删除元素
 iterator.next().remove();
```



## 4. Map

### A.entrySet

```
返回的是一个set
有getKey();和getValue();
```

### A.keySet

```
返回的是一个set
拿到保存的所有的key
```

### A.values

```
返回的是Collection
拿到的是value的集合
```

## 5. Thread(多线程)

```
// Thread.currentThread()  返回的是一个main(进程)
// 静态
// 以下代码中Thread.currentThread()可以替换为一个Thread类的实例对象
```

### getName()

```
// 获取名字
Thread.currentThread().getName();
```

### getPriority()

```
// 设置/获取优先级（优先级最小为1，最大为10）
Thread.currentThread().getPriority();
```

### getId()

```
// 获取id
Thread.currentThread().getId();
```

### isAlive()

```
// 是否存活
Thread.currentThread().isAlive();
```

### isDeamon()

```
// 判断进程是否为守护线程
Thread.currentThread().isDeamon();
```

### isInterrupted()

```
// 是否中断
Thread.currentThread().isInterrupted();
```

### 对象.join()

```
// 使得main进程暂停，先将之前进程运行结束，再去执行之后其他进程
thread.join(); // thread是Thread的实例化对象
// 需要捕获异常try/catch
```

```
try{
	thread.join();
}catch(){

}
```

### 对象.setPriority()

```
设置优先级
```

### synchronized(成员属性名)

```
// 同步代码块
// 对代码进行加锁
synchronized(成员属性名){
	// 成员属性名一定都是相同的对象（相同类创建的同一个对象 或者 静态对象）
	// do something
}
```

注：// do something代码块成为***临界区***

### 等待 wait();

```
wait();
// 可以使用 this.wait();
// 需要使用try/catch捕获异常
```

### 通知 

```
notify();   // 把一个等待的线程唤醒
notifyAll(); // 把全部等待的线程唤醒
// 可以使用 this.wait();
// 通知所有线程启动
```

### Lock

```
private Lock lock = new ReentrantLock(); //创建锁
private Condition prodCondition = lock.newCondition(); // 解锁的必须步骤
private Condition consumeCondition = lock.newCondition(); // 解锁的必须步骤

lock.lock(); // 加锁
lock.unlock(); // 解锁，可以使用try/catch/finally，将其添加在finally代码块里
lock.trylock(); // 尝试着去拿锁，

//前面的对象名不同，看自己的创建对象
prodCondition.singalAll(); // 解锁

//wait方式
consumeCondition.await(); // 等待，后面可以加时间，毫秒或者分钟等

```

**注：在此方法中wait方法也方法改变**

## Thread的静态API

### Thread.sleep(millis); （用的比较多）

```
Thread.sleep(millis); // millis休眠的毫秒数
// 需要捕获异常try/catch
```

```
try{
	Thread.sleep(millis);
}catch(){

}
```

### Thread.yield();

```
Thread.yield(); // 通知cpu可以转到其他进程（优先级不低于当前进程）上
```

## Thread的构造方法

```
String
Runnalbe,String // 线程类，线程名称
()
Runnable
```

