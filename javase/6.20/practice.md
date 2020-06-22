# 6.20

## practice

### 以下程序的输出结果是

要加上注释说明程序运行结果的原因。题目先自己想答案，然后运行代码查看结果和自己想的是否一致，然后记录注释


#### 1.

```
class A
{
    {
        System.out.println(1);
    }
}
 
class B extends A
{
    {
        System.out.println(2);
    }
}
 
class C extends B
{
    {
        System.out.println(3);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}
```

```
答：
1 
2 
3
```

#### 2.

```
class A
{
    public A()
    {
        System.out.println("Class A Constructor");
    }
}
 
class B extends A
{
    public B()
    {
        System.out.println("Class B Constructor");
    }
}
 
class C extends B
{
    public C()
    {
        System.out.println("Class C Constructor");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}
```

```
答: 
Class A Constructor	
Class B Constructor
Class C Constructor
```

#### 3.

```
class X
{
    public X(int i)
    {
        System.out.println(1);
    }
}
 
class Y extends X
{
    public Y()
    {
        System.out.println(2);
    }
}
```

```
答：编译报错，父类X没有无参的构造方法
```

#### 4. 

```
public class A
{
    public A()
    {
        System.out.println(1);
 
        super();
 
        System.out.println(2);
    }
}
```

```
答：编译报错，super()应该放在第一句
```

#### 5. 

```
public class A
{
    public A(int i)
    {
 
    }
}
 
class B extends A
{
 
}
```

```
答：编译报错，A中没有无参的构造方法，B类也没有指定调用A类的构造方法
```

#### 6. 

```
public class A
{
    public A()
    {
        super();
 
        this(10);
    }
 
    public A(int i)
    {
        System.out.println(i);
    }
}
```

```
答：this和super不能公用，应该是放在第一句
```

#### 7. 

```
class M
{
    int i;
 
    public M(int i)
    {
        this.i = i--;
    }
}
 
class N extends M
{
    public N(int i)
    {
        super(++i);
 
        System.out.println(i);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N(26);
    }
}
```

```
答：27 父类中的i没有被使用
```

#### 8. 

```
class M
{
    int i = 51;
 
    public M(int j)
    {
        System.out.println(i);     //2  i = 51
 
        this.i = j * 10;           //3  i = 260(不打印)
    }
}
 
class N extends M
{
    public N(int j)
    {
        super(j);                 //1
 
        System.out.println(i);    //4  i =  260
 
        this.i = j * 20;          //5  i = j(26) * 20
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N(26);
 
        System.out.println(n.i);  //6   520
    }
}
```

```
答：
51 
260 
520
```

#### 9. 

```
class X
{
    private int m = 48;
}
 
class Y extends X
{
    void methodOfY()
    {
        System.out.println(m);
    }
}
```

```
答：编译报错 m是X类中私有变量
```

#### 10. 

```
class X
{
    int m = 1111;
 
    {
        m = m++;                     //1
 
        System.out.println(m);       //2
    }
}
 
class Y extends X
{
    {
        System.out.println(methodOfY()); //4
    }
 
    int methodOfY()
    {
        return m-- + --m;             //3
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        Y y = new Y();
    }
}
```

```
答：
1111 
2220
```

#### 11. 

```
class A
{
	void A()
	{
		System.out.println(1);
	}
}

class B extends A
{
	void B()
	{
		A();
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		new B().B();
	}
}
```

```
答：1
```

#### 12. 

```
class A
{
	int i = 1212;
}

class B extends A
{
	A a;

	public B(A a)
	{
		this.a = a;
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		A a = new A();

		B b = new B(a);

		System.out.println(a.i);

		System.out.println(b.i);

		System.out.println(b.a.i);

		b.a.i = 2121;

		System.out.println("--------");

		System.out.println(a.i);

		System.out.println(b.i);
	}
}
```

```
答：
1212         1212
1212         1212
1212         1212
--------     --------
1212         2121       ????
1212		 1212
```

#### 13. 

```
class A
{
	int methodOfA(int i)
	{
		i /= 10;				    //3
 
		return i;                   //4
	}
}

class B extends A
{
	int methodOfB(int i)
	{
		i *= 20;					//1

		return methodOfA(i);        //2
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		B b = new B();

		System.out.println(b.methodOfB(100));
	}
}
```

```
答：200
```

#### 14. 

```
class One
{
	int x = 2121;
}

class Two
{
	int x = 1212;
	
	{
		System.out.println(x); //只运行该行代码
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Two two = new Two();
	}
}
```

```
答：1212
```

#### 15.

```
class Clidder  
{ 
    private final void flipper()  
    { 
        System.out.println("Clidder"); 
    } 
} 
  
public class Clidlet extends Clidder  
{ 
    public final void flipper()  
    { 
        System.out.println("Clidlet"); 
    } 
    public static void main(String[] args)  
    { 
        new Clidlet().flipper(); 
    } 
} 
```

```
答：编译报错，final修饰的方法无法重构
```

#### 16.

```
class Alpha  
{ 
    static String s = " "; 
    protected Alpha()  //1  父类构造方法，创建子类一定会调用
    { 
        s += "alpha "; 
    } 
} 
class SubAlpha extends Alpha  
{ 
    private SubAlpha()  
    { 
        s += "sub "; 
    } 
} 
  
public class SubSubAlpha extends Alpha  
{ 
    private SubSubAlpha()  
    { 
        s += "subsub "; //2
    } 
    public static void main(String[] args)  
    { 
        new SubSubAlpha(); 
        System.out.println(s); 
    } 
} 
```

```
答： alpha subsub 
```

#### 17.

```
class Grandparent  
{ 
    public void Print()  
    { 
        System.out.println("Grandparent's Print()");  
    }  
} 
  
class Parent extends Grandparent  
{ 
    public void Print()  
    { 
        System.out.println("Parent's Print()");  
    }  
} 
  
class Child extends Parent  
{ 
    public void Print()    
    { 
        super.super.Print(); 
        System.out.println("Child's Print()");  
    }  
} 
  
public class Main  
{ 
    public static void main(String[] args)  
    { 
        Child c = new Child(); 
        c.Print();  
    } 
} 
```

```
答：错误，super.super错误使用
```

#### 18.

```
final class Complex {
 
    private final double re;
    private final double im;
 
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
 
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}
 
class Main {
  public static void main(String args[])
  {
       Complex c = new Complex(10, 15);
       System.out.println("Complex number is " + c);
  }         
}
```

```
答：Complex number is (10.0 + 15.0i)
```

#### 19.

```
class A
{
    String s = "Class A";
}
 
class B extends A
{
    String s = "Class B";
 	
 	//构造代码块
    {
        System.out.println(super.s);
    }
}
 
class C extends B
{
    String s = "Class C";
 	
 	//构造代码块
    {
        System.out.println(super.s);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
 
        System.out.println(c.s);
    }
}
```

```
答:
Class A
Class B
Class C
```

#### 20.

```
class A
{
    static //静态代码块
    {
        System.out.println("THIRD");
    }
}
 
class B extends A
{
    static //静态代码块
    {
        System.out.println("SECOND");
    }
}
 
class C extends B
{
    static //静态代码块
    {
        System.out.println("FIRST");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        C c = new C();
    }
}
```

```
答：
THIRD
SECOND
FIRST
```

#### 21.

```
class X
{
    static void staticMethod() //静态方法
    {
        System.out.println("Class X");
    }
}
 
class Y extends X
{
    static void staticMethod() //静态方法
    {
        System.out.println("Class Y");
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        Y.staticMethod();
    }
}
```

```
答：Class Y
```

#### 22.

```
class M
{
    static   //父类静态代码块   1
    {
        System.out.println('A');
    }
 			//父类构造代码块    3
    {
        System.out.println('B');
    }
 
    public M()
    {      //构造方法 4
        System.out.println('C');
    }
}
 
class N extends M
{
    static  //子类静态代码块   2
    {
        System.out.println('D');
    }
 
    {     //子类构造代码块  5
        System.out.println('E');
    }
 
    public N()
    {    //子类构造方法  6
        System.out.println('F');
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        N n = new N();
    }
}
```

```
答：
A
D
B
C
E
F
```

#### 23.

```
class A
{
	static String s = "AAA";

	static   //父类静态代码块   1
	{
		s = s + "BBB";
	}

	{        //父类构造代码块   3
		s = "AAABBB";
	}
}

class B extends A
{
	static   //子类静态代码块   2
	{
		s = s + "BBBAAA";
	}
             //子类构造代码块   4
	{
		System.out.println(s);
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		B b = new B();
	}
}
```

```
答：AAABBB
```

#### 24.

```
class X
{
	int i = 101010;

	public X()
	{
		i = i++ + i-- - i;   //101010 + 101011 - 101010
	}

	static int staticMethod(int i)
	{
		return --i;
	}
}

class Y extends X
{
	public Y()
	{
		System.out.println(staticMethod(i));
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Y y = new Y();
	}
}
```

```
答：101010
```

#### 25.

```
class ClassOne
{
     static int i, j = 191919;   //i = 0， i = 191919
 
     {//构造代码块，没有构造方法，不会调用
         --i;
     }
 
     {
         j++;
     }
}
 
public class ClassTwo extends ClassOne
{
    static
    {
        i++;
    }
 
    static
    {
        --j;
    }
 
    public static void main(String[] args)
    {
        System.out.println(i);
 
        System.out.println(j);
    }
}
```

```
答：
1
191918
```

#### 26.

```
class A
{
	int[] a = new int[5];

	{
		a[0] = 10;
	}
}

public class MainClass extends A
{
	{
		a = new int[5];
	}

	{
		System.out.println(a[0]);
	}

	public static void main(String[] args)
	{
		MainClass main = new MainClass();
	}
}
```

```
答：0
```

#### 27.

```
class A
{
	static int i;

	static  //静态代码块
	{
		i++;
	}

	{       //构造代码块
		++i;
	}
}

class B extends A
{
	static  //静态代码块
	{
		--i;
	}

	{       //构造代码块
		i--;
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		System.out.println(new B().i);
	}
}
```

```
答：0
```

#### 28.

```
public class MainClass
{
	public MainClass(int i, int j)
	{
		System.out.println(method(i, j));
	}
	
	int method(int i, int j)
	{
		return i++ + ++j;
	}
	
	public static void main(String[] args) 
	{
		MainClass main = new MainClass(10, 20);
	}
}
```

```
答：31
```

#### 29.

```
class X
{
	static
	{
		Y.methodOfY();
	}
}

class Y extends X
{
	static void methodOfY()
	{
		System.out.println("Hi....");
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Y.methodOfY();
	}
}
```

```
答：
Hi....
Hi....
```

#### 30.

```
class ClassOne {

  static int i = 111;

  int j = 222;

  { //构造代码块
    i = i++ - ++j;    //1  111 - 223 = -112
    					   j = 223
  }
}

class ClassTwo extends ClassOne {

  { //构造代码块
    i = -113;        //2  -113
    j = i-- + --j;   //3  -113 + 222 = 109
    				 //4  i = -114
  }
}

class Main {

  public static void main(String args[]) {
    ClassTwo clsTwo = new ClassTwo();
    System.out.println(clsTwo.i);
    System.out.println(clsTwo.j);
  }
}
```

```
答：
-114
109
```