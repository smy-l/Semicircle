# SpringMVC

## 三层架构

1. 表现层（web层）

   也就是我们常说的web层。它负责接收客户端请求，向客户端响应结果，通常客户端使用http协议请求 web 层，web 需要接收 http 请求，完成 http 响应。 

2. 业务层（service层）

   负责业务逻辑处理，和我们开发项目的需求息息相关。web 层依赖业 务层，但是业务层不依赖 web 层。 

3. 持久层（dao层）

   数据持久化，包括数据层即数据库和数据访问层，数据库是对数据进 行持久化的载体，数据访问层是业务层和持久层交互的接口，业务层需要通过数据访问层将数据持久化到数据库中。通俗的讲，持久层就是和数据库交互，对数据库表进行曾删改查的。

## MVC模型

MVC（Model View Controller）是模型(model)－视图(view)－控制器(controller)的缩写， 是一种用于设计创建 Web 应用程序表现层的模式。MVC 中每个部分各司其职： 

model（模型）：数据模型，即具体的类

view（视图）：jsp或者html，作用为显示数据，即页面

controller（控制器）：处理程序逻辑，一般为servlet

## SpringMVC

简介：基于java实现mvc设计模型的请求驱动类的轻量级web框架。

### 配置步骤(流程)

1. 创建maven工程

2. 在`pom.xml`中导入相关jar包，并且把打包方式改成war，导入tomcat插件

3. 在main目录下创建`webapp/WEB-INF`目录，在该目录下创建`web.xml`

4. 在`web.xml`中添加springmvc核心控制器的配置 

   ```xml
   <!DOCTYPE web-app PUBLIC
    "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
    "http://java.sun.com/dtd/web-app_2_3.dtd" >
   
   <web-app>
   		<!-- 过滤器，配置编码格式 -->
       <filter>
           <filter-name>characterEncoding</filter-name>
           <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
           <init-param>
               <param-name>encoding</param-name>
               <param-value>utf-8</param-value>
           </init-param>
       </filter>
       <filter-mapping>
         	<!-- 配置过滤的路径 -->
           <filter-name>characterEncoding</filter-name>
           <url-pattern>/*</url-pattern>
       </filter-mapping>
   
   		<!-- 配置前端控制器 SpringMVC的核心控制器 -->
       <servlet>
           <servlet-name>SpringMVCDispatcherServlet</servlet-name>
           <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
         	<!-- 配置初始化参数，用于读取SpringMVC的配置文件 -->
           <init-param>
               <param-name>contextConfigLocation</param-name>
               <param-value>classpath:SpringMVC.xml</param-value>
           </init-param>
         	<!-- 配置servlet的对象创建的时间点：应用加载时创建。取值只能是非0的正整数，表示顺序启动 -->
           <load-on-startup>1</load-on-startup>
       </servlet>
       <servlet-mapping>
           <servlet-name>SpringMVCDispatcherServlet</servlet-name>
           <url-pattern>/</url-pattern>
       </servlet-mapping>
   </web-app>
   
   ```

5. 在resources目录中添加SpringMVC配置文件 --- `SpringMVC.xml`，并且在该配置文件中，添加扫描路径

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:mvc="http://www.springframework.org/schema/mvc"
          xmlns:context="http://www.springframework.org/schema/context"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
              http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/mvc
           http://www.springframework.org/schema/mvc/spring-mvc.xsd
            http://www.springframework.org/schema/context
            http://www.springframework.org/schema/context/spring-context.xsd">
   
       <!-- 配置创建 spring 容器要扫描的包 -->
       <context:component-scan base-package="club.banyuan"></context:component-scan>
   
       <bean id="myConvert"
             class="org.springframework.context.support.ConversionServiceFactoryBean">
           <property name="converters">
               <array>
                   <bean class="club.banyuan.convert.DateConverter"></bean>
               </array>
           </property>
       </bean>
   
       <mvc:annotation-driven conversion-service="myConvert"></mvc:annotation-driven>
   
       <!-- 配置视图解析器 -->
       <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
         	<!-- 路径 -->
           <property name="prefix" value="/"></property>
         	<!-- 添加文件的后缀 -->
           <property name="suffix" value=".jsp"></property>
       </bean>
   
       <!--
         静态资源，不需要经过controller
         location : 静态资源的在服务器上的物理路径
         mapping ：浏览器访问静态资源的请求路径
     	-->
       <mvc:resources location="images/" mapping="images/**"/>
   		<!-- <mvc:resources location="css/" mapping="css/**"/> -->
       <mvc:resources location="js/" mapping="js/**"/>
   
       <!-- 配置文件上传解析器 -->
       <bean id="multipartResolver"
             class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
           <!-- 设置上传文件的最大尺寸为 5MB -->
           <property name="maxUploadSize">
               <value>5242880</value>
           </property>
       </bean>
       
       <mvc:interceptors>
           <mvc:interceptor>
               <mvc:mapping path="/**"/>
               <bean class="club.banyuan.interceptor.MyInterceptor1"/>
           </mvc:interceptor>
           <mvc:interceptor>
               <mvc:mapping path="/**"/>
               <bean class="club.banyuan.interceptor.MyInterceptor2"/>
           </mvc:interceptor>
       </mvc:interceptors>
   </beans>
   
   ```

6. 在webapp目录下添加页面

7. 添加控制器

   在路径下创建`controller`类，如`club/banyuan/controller`路径下创建`TestController.java`控制器

   ```java
   package club.banyuan.controller;
   
   import club.banyuan.pojo.User;
   import org.springframework.stereotype.Controller;
   import org.springframework.web.bind.annotation.CookieValue;
   import org.springframework.web.bind.annotation.PathVariable;
   import org.springframework.web.bind.annotation.RequestMapping;
   import org.springframework.web.bind.annotation.RequestParam;
   
   import java.util.Date;
   
   // 控制器的注解
   @Controller
   // URL注解
   @RequestMapping("/parent")
   public class TestController {
       @RequestMapping("/test")
       public String test(@RequestParam(name = "param",required = true,defaultValue = "默认值") String paramName){
           System.out.println("TestController --- test");
           System.out.println(paramName);
           return "result";
       }
   
   //<a href="parent/test4/value">
       @RequestMapping("/test4/{param}")
       public String test4(@PathVariable("param") String param){
           System.out.println(param);
           return "result";
       }
   
       @RequestMapping("/test2")
       public String test2(String username, String password, Integer userId, Date birth){
           System.out.println(userId+"   "+username+"   "+password);
           System.out.println(birth);
           return "result";
       }
   
       @RequestMapping("/test3")
       public String test3(User user){
           System.out.println(user);
           return "result";
       }
   
       @RequestMapping("/test5")
       public String test5(@CookieValue("JSESSIONID") String cookieValue){
           System.out.println(cookieValue);
           return "result";
       }
   }
   
   ```

   ```jsp
   <!-- 与@RequestMapping对应的前端代码 -->
   <a href = "parent/test">示例1</a>
   ```

   

### 执行流程

1. 服务器启动，应用被加载。读取web.xml中配置，创建spring容器，并初始化容器中的对象
2. 浏览器发送请求，被DispatherServlet捕获，将请求转发出去。根据请求URL确认路径，匹配`@RequestMapping`中的内容
3. 找到方法后，执行对应方法，方法中应含有返回值
4. 根据返回值，借助`InternalResourceViewResolver`找到对应视图
5. 渲染结果视图，响应浏览器。(返回界面)