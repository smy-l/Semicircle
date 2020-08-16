package club.banyuan.test;

import club.banyuan.pojo.Product;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TestReflect {
    @Test
    public void testReflectObject() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        通过class文件  ---> java类型的信息
//                --->得到java类（实例化，属性赋值，调用方法）

        Product product = new Product(); //前提：事先知道实例化哪个类
//        反射是用在，你编写代码的时候，你是不知道实例化哪个类，不知道类的信息
//        运行的时候，动态的获取你所要实例化的类型的信息
//        怎么获取接下来要实例化的对象的类型信息 --- 读取类的class文件
        Class clazz = Class.forName("club.banyuan.pojo.Product");
        Field[] fields = clazz.getFields();
        System.out.println(fields.length);
        for (Field field : fields) {
            field.getAnnotations();
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            method.getAnnotations();
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for(Parameter parameter : parameters){
                System.out.println(parameter.getName());
            }
        }
        clazz.getAnnotations();

        Product product1 = (Product)clazz.newInstance();
//        System.out.println(product1);

        product1.setId(10);
//        System.out.println(product1);

        Method method1 = clazz.getMethod("toString");
        method1.invoke(product1,null);
    }

}
