# 6.12
只需保证多个文件package路径相同就可以运行，与原文件路径无关

## 静态(static)
通过static修饰的变量可以使用类名调用
```
public class Elephant{
    static int getTotal;
}
//调用(可以直接使用类名调用)
Elephant.getTotal
```

静态类只允许使用静态成员变量，不能使用非静态变量

局部变量和静态变量区别<br>
生存周期不同

## 构造方法
方法名和类名一致，没有返回值，
```
public class Elephant{
    private int heightInCM;

    public Elephant(int height){    //构造方法
        heightInCM = height;
    }

}
```
创建构造方法(有参数)后，不能再使用无参构造方法(可以重载无参数方法)；

## this
1. 区分方法变量和成员变量
方法变量和成员变量重名，需使用`this.`来区分<br>
例如:`this.成员变量`

2. 作为返回值，进行链式调用
返回的是一个类对象
```
public class B{
    
    private String prop;

    public B setPorp(String prop){
        this.prop = prop;
        renturn this;   //this 返回的是一个B类对象
    }
    
    //链式调用
    //例如 b.setprop(one).setprop(two).setprop(three)····
}
```

3. this做构造方法(第一句，不能递归调用)
```
public class C{
    private String prop;
    private String title;

    public C(){
        this("default","default"); //this 在这里当作构造方法
    }

    public C(String prop){
        this(prpo,"default");// 在构造器中调用构造方法必须是第一句话，即只能有一句
    }

    public C(String prop,String title){
        this.prop = prop;
        this.title = title;
    }

}


```
## 构造代码块
1. 构造代码块会被放入到所有构造方法当中，放到构造方法语句之前
2. 不能写到成员变量之前，要放到成员变量之后
3. 若有多个代码块，会依次放到构造方法当中
4. 之前如果有static修饰，则为静态代码块，只要程序运行，会最先调用，无论是否使用构造方法，且只会被执行1次
```
public class C{
    private String prop;
    private String title;

    {
        //构造代码块,例如
        System.out.println(1);
    }
    
    //相当于
    public C(){
        System.out.println(1);
        this("default","default");
    }


    public C(){
        this("default","default"); //this 在这里当作构造方法
    }

    public C(String prop){
        this(prpo,"default");// 在构造器中调用构造方法必须是第一句话，即只能有一句
    }

    public C(String prop,String title){
        this.prop = prop;
        this.title = title;
    }

}
```



