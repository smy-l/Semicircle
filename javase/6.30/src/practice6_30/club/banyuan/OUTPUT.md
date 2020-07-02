#### 1.
```
class Main {
   public static void main(String args[]) {
      try {
         throw 10;    // 编译报错，必须爆出Throwable的子类
      }
      catch(int e) {
         System.out.println("Got the  Exception " + e);
      }
  }
}
```

```
编译报错，应该为错误类型，不是基本类型
```

#### 2.
```
class Test extends Exception { }
  
class Main {
   public static void main(String args[]) { 
      try {
         throw new Test();
      }
      catch(Test t) {
         System.out.println("Got the Test Exception");
      }
      finally {
         System.out.println("Inside finally block ");
      }
  }
}
```
```
Got the Test Exception
Inside finally block 
```

#### 3.
```
class Main {
   public static void main(String args[]) {
      int x = 0;
      int y = 10;
      int z = y/x;
  }
}
```
```
运行报错，分母不能为零
```

#### 4.
```
class Base extends Exception {}
class Derived extends Base  {}
 
public class Main {
  public static void main(String args[]) {
   // some other stuff
   try {
       // Some monitored code
       throw new Derived();
    }
    catch(Base b)     { 
       System.out.println("Caught base class exception"); 
    }
    catch(Derived d)  { 
       System.out.println("Caught derived class exception"); 
    }
  }
} 
```
```
编译报错，子类的异常包含在父类当中，删除或将其提前
```

#### 5.
```
class Test
{
    public static void main (String[] args)
    {
        try
        {
            int a = 0;
            System.out.println ("a = " + a);
            int b = 20 / a;
            System.out.println ("b = " + b);
        }
 
        catch(ArithmeticException e)
        {
            System.out.println ("Divide by zero error");
        }
 
        finally
        {
            System.out.println ("inside the finally block");
        }
    }
}
```
```
a = 0;
Divide by zero error
inside the finally block
```

#### 6.
```
class Test
{
    public static void main(String[] args)
    {
        try
        {
            int a[]= {1, 2, 3, 4};
            for (int i = 1; i <= 4; i++)
            {
                System.out.println ("a[" + i + "]=" + a[i] + "n");
            }
        }
         
        catch (Exception e)
        {
            System.out.println ("error = " + e);
        }
         
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println ("ArrayIndexOutOfBoundsException");
        }
    }
}
```
```
要把子类放到父类上面
```

#### 7.
```
class Test
{
    String str = "a";   // 1
 
    void A()
    {
        try
        {
            str +="b";   // 2
            B();
        }
        catch (Exception e)  //7
        {
            str += "c";   //8
        }
    }
 
    void B() throws Exception
    {
        try
        {
            str += "d";   //3
            C();
        }
        catch(Exception e)
        {
            throw new Exception();  //6
        }
        finally
        {
            str += "e";   //5
        }
 
        str += "f";
 
    }
     
    void C() throws Exception
    {
        throw new Exception();   //4
    }
 
    void display()
    {
        System.out.println(str);  //9
    }
 
    public static void main(String[] args)
    {
        Test object = new Test();
        object.A();
        object.display();
    }
 
}

```
```
abdec
```

#### 8.
```
class Test
{   int count = 0;
 
    void A() throws Exception
    {
        try
        {
            count++;   // 1
             
            try
            {
                count++;  // 2
 
                try
                {
                    count++;  // 3
                    throw new Exception();
 
                }
                 
                catch(Exception ex)
                {
                    count++;  // 4
                    throw new Exception();  // 5
                }
            }
             
            catch(Exception ex)
            {
                count++;  / 6
            }
        }
         
        catch(Exception ex)
        {
            count++;
        }
 
    }
 
    void display()
    {
        System.out.println(count);  // 7
    }
 
    public static void main(String[] args) throws Exception
    {
        Test obj = new Test();
        obj.A();
        obj.display();
    }
}
```

```
5
```

#### 9.方法返回值是
```
public int myMethod(){

  try {

  return 1;

  }

  Catch (Exception e){

  return 2;

  }

  finally{

  return 3;

 }

}
```
```
3
```

#### 10.

```
 try {

      File file = new File("filename.txt");

      Scanner sc = new Scanner(file); // 抛出异常

      throw new IOException();
    }

    catch (FileNotFoundException e) {

      System.out.println("FileNotFoundException called!!!");

    }

    catch (IOException e) {

      System.out.println("IOException called!!!");

    } 

```
```
FileNotFoundException called!!!
```

#### 11.

```
try {

      File file = new File("filename.txt");

      Scanner sc = new Scanner(file); // 抛出异常

      throw new IOException();
    }

    catch (IOException e) {

      System.out.println("IOException called!!!");

    } 
```

```
IOException called!!!
```

#### 12.
```
public class Test {
 
    private static String result = "";
 
    public static void main(String[] args) {
        test(1);
        result += "*";  // 5
        test(0);
        System.out.println(result);
    }
 
    public static void test(int i) {
        result += "1"; // 1   // 6
        try {
            if (i == 0) {
                throw new RuntimeException("");
            }
            result += "2";  // 2
        } catch (Exception e) {
            result += "3";  // 7
            return;
        } finally {
            result += "4";  // 3  // 8
        }
        result += "5";  // 4
    }
}
```

```
1245*134
```

