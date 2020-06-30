# 6.15
## 常用类(都是静态，使用类名加方法名即可调用)
util包不会默认导包，lang默认导包；

### System

1. System.currentTimeMilis();
(计算从1970年到1月1日到现在到毫秒值)

2. System.arraycopy(arr1,i,arr2,j,k);
(将数组arr1从i位置开始,复制到数组arr2从j位置开始,赋值k个元素)

3. Syetem.exit();

### Math
1. Math.max
2. Math.min
3. Math.abs
4. Math.ceil(向上取整)
5. Math.floor(向下取整)
6. Math.round(四舍五入)
7. Math.random(取随机数)

### String
1. "a bc  ".toLowerCase();//

2. valueOf(123)//将字符串转变为数字;

3. charAt(i);//获取字符串第i个元素;

4. subString(i,j);//从第i个字符开始分隔，第j个字符结束
   
   subString(i);//从第i个字符串开始分隔，直到最后
   
5. toLowerCase();//大写转小写

   toUpperCase();//小写转大写

### Random

1. Random random1  = new Random(10);//10为种子，指定之后生成的数是一定的（伪随机数）
2. nextInt(i);//生成[0,i)的数;

### java.util包

1. java.util.Scanner

   ```
   Scanner scanner = new Scanner(System.in);
   String userInput = scanner.next();
   System.out.println("用户输入：" + userInput);
   ```

### 包装类



