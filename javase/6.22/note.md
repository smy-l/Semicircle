# 6.22

## 多态

1. 将父类作为总的类，其下任意子类都可以通过父类类名来创建

   例：

   ```
   public class Animal{
   	
   }
   
   public class Elephant extends Animal{
   
   }
   
   publci class Lion extends Animal{
   
   }
   
   public class Main{
   	public static void main(String[] args){
   		Animal elephant = new Elephant();
   		Animal lion = new Lion();
   	}
   }
   ```

### 抽象类 abstract

1. 抽象类不能够被实例化
2. 抽象类可以有构造方法，目的是让子类对其变量能够初始化
3. 抽象类可以创建抽象方法，该抽象方法必须强制要求子类对抽象方法进行重写
4. 创建数组不算实例化

### 抽象类(父类)和子类之间的关系

#### 向上转型

有父类对象接受子类对象，系统自动转换

#### instanceof(向下转型)

1. 子类中定义的新方法，如果没有在抽象类中定义，那么该新方法无法调用，被隐藏起来，如果想要调用，需要强行将其进行类型转换，使用`instanceof`

2. 使用方法

   ```
   父类对象(实例化对象) instanceof 子类类名
   ```

   如果该父类对象是子类类型，则返回true，否则返回false

将父类对象转换成子类对象；

```
public class A{

}

public class B extends A{
	public void method(){
		System.out.println(1);
	}
}

public class C extends A{

}

public class Main{
	public static void main(String[] args){
		A b = new B();
		A c = new C();
		
		//b.method();  //编译报错，b是A类对象，无法调用B类中的方法，若要使用，进行转换
		
		if(b instanceof B){    //转换
			B b1 = (B)b;
			b1.method();         //可以使用B类的method()方法，
		}
		
		System.out.println(b instanceof C); //打印false，因为b为B子类，不是C子类
		
	}
}
```

