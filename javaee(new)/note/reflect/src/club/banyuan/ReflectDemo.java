package club.banyuan;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectDemo {

  public static void main(String[] args) throws Exception {
    // 类名
    // 类的访问权限

    // 构造方法
    // 方法名字
    // 方法的参数，参数的名字，参数的数据类型
    // 访问权限

    // 成员变量
    // 数据类型、变量名、访问权限

    // 方法
    // 方法名、方法返回值数据类型、方法入参，参数名、参数数据类型，方法权限

    Class<MyObject> cls = MyObject.class;

    // getDeclared 获取所有当前类中定义的，包含私有的 方法、构造方法、成员
    Method[] declaredMethods = cls.getDeclaredMethods();
    Method[] methods = cls.getMethods();
    System.out.println(Arrays.toString(declaredMethods));
    System.out.println(Arrays.toString(methods));

    MyObject object = new MyObject("12");

    Method getField = cls.getDeclaredMethod("getField");
    // 对象.方法名(参数列表)
    object.getField();

    // 方法对象.invoke(对象,参数列表)
    getField.invoke(object);

    // 调用静态方法，传入一个null
    Method staticMethod = cls.getDeclaredMethod("staticMethod");
    staticMethod.invoke(null);

    // 获取带有参数的方法，需要给定方法名和方法的参数列表对应的数据类型
    Method setField = cls.getDeclaredMethod("setField", String.class);
    setField.invoke(object, "abcde");

    System.out.println(object);

    Method method = cls.getDeclaredMethod("method");
    // 私有方法如果直接调用，会抛出异常，需要将访问权限设置为true，之后可以调用
    method.setAccessible(true);
    method.invoke(object);

    // 构造方法获取的时候，必须和定义的方法的参数列表匹配
    Constructor<MyObject> constructor = cls.getConstructor(String.class);
    // 使用构造方法可以创建对象，调用newInstance的参数列表要和构造方法的参数列表的数据一致
    MyObject instance = constructor.newInstance("123");

    Field[] declaredFields = cls.getDeclaredFields();

    Field field = cls.getDeclaredField("field");
    field.setAccessible(true);
    field.set(object, "1234");
    System.out.println(object);

    Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
    System.out.println(Arrays.toString(declaredAnnotations));
    MyAnnotation declaredAnnotation = field.getDeclaredAnnotation(MyAnnotation.class);
    System.out.println(declaredAnnotation.other());

    Field staticField = cls.getDeclaredField("staticField");
    staticField.set(null, "2222");
    System.out.println(MyObject.staticField);


  }

}
