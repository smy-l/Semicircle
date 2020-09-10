package club.banyuan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// SOURCE 表示作用于编译阶段，编译后不会写入到class文件
// 主要用于给与编译器更多的提示信息

// CLASS 编译后会保存到class中，但是不会被反射获取到，在运行的时候无效

// RUNTIME 在程序运行期间，可以通过反射获取注解对象
@Retention(RetentionPolicy.RUNTIME)
// 限定注解能出现在类的什么位置
@Target({
    ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER
})
public @interface MyAnnotation {

  // default 给定默认值，给定了默认值的注解属性不强制要求在类中填写这个属性值
  String test() default "";

  // 叫做value，如果只需要传入名为value的值，则不需要给定value属性=
  int value();

  String other();
}
