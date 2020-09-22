# Spring知识点

## 代码问题

1. 返回状态码

   方法的返回类型为`ResponseEntity`，返回的语句为

   ```java
   return new ResponseEntity(HttpStatus."状态码")
   ```

   

## Spring注解

1. `@Component`
2. `@Repository` （持久层）
3. `@Service`（用户层）
4. `@Controller`（控制层）

注：四个注释一样，都是给 mvc 提示，但是不同名字的原因是为了给程序员更好的注释，四个中任意一个都可以

1. `@ControllerAdvice` 实现全局异常处理
2. `@ResponseEntity` 设置返回的状态码

### dao层的注解

1. `@Repository`

   (在dao接口类的实现类)

   让 mvc 知道这个类是用来操作数据库的

   内部封装了数据查询和存储的逻辑

2. `@Primary`

   (在dao接口中使用)

   当有自动填充的时候，如果发生冲突，优先使用 @Primary 注释的累

### service层的注解

1. `@Autowired`

   自动注入实现类（注入的类要在spring配置文件中配置好）

### controller层的注解

1. `@RequestMapping`

   后面接前端返回的路径

2. `@ResponseBody`

   使得后端返回的结果转换为json格式

3. `@RequestBody`

   使得后端的方法知道前端返回的数据是json格式的数据

   注：`@RequestBody(required = false)`表明前端可能不返回数据，也可能返回数据

### test测试类

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring配置文件")
@WebAppConfiguration
```

在测试类上方添加这三个注解，让springMVC能在测试类中运行



## 配置文件

1. `ApplicationContext`为容器，用来管理`Bean`和`Bean`之间的依赖关系

   ```java
   ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
   ```

2. `QueryRunner`(增强JDBC类)

   ```java
   QueryRunner qr;
   ```

   pom.xml中配置代码

   ```xml
   		<dependency>
         <groupId>commons-dbutils</groupId>
         <artifactId>commons-dbutils</artifactId>
         <version>1.7</version>
       </dependency>
   ```

3. 将返回的对象转换为json格式

   ```xml
   <jackson.version>2.9.1</jackson.version>
   <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
           <dependency>
               <groupId>com.fasterxml.jackson.core</groupId>
               <artifactId>jackson-core</artifactId>
               <version>${jackson.version}</version>
           </dependency>
           <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
           <dependency>
               <groupId>com.fasterxml.jackson.core</groupId>
               <artifactId>jackson-databind</artifactId>
               <version>${jackson.version}</version>
           </dependency>
           <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations -->
           <dependency>
               <groupId>com.fasterxml.jackson.core</groupId>
               <artifactId>jackson-annotations</artifactId>
               <version>${jackson.version}</version>
           </dependency>
   ```

4. jdbc的工具集，封装了查询和组装对象的方法

   ```xml
   <dbutils.version>1.7</dbutils.version>
   <!-- https://mvnrepository.com/artifact/commons-dbutils/commons-dbutils -->
           <dependency>
               <groupId>commons-dbutils</groupId>
               <artifactId>commons-dbutils</artifactId>
               <version>${dbutils.version}</version>
           </dependency>
   ```

5. 工具集合，使用其中的Hash算法工具

   ```xml
   <hutool.version>5.4.1</hutool.version>
   <!-- https://mvnrepository.com/artifact/cn.hutool/hutool-all -->
           <dependency>
               <groupId>cn.hutool</groupId>
               <artifactId>hutool-all</artifactId>
               <version>${hutool.version}</version>
           </dependency>
   ```

6. 管理数据源连接池的包

   ```xml
   <c3p0.version>0.9.5.5</c3p0.version>
   <!-- https://mvnrepository.com/artifact/com.mchange/c3p0 -->
           <dependency>
               <groupId>com.mchange</groupId>
               <artifactId>c3p0</artifactId>
               <version>${c3p0.version}</version>
           </dependency>
   ```

7. 连接mySql的类

   ```xml
   <mysql.connector.version>8.0.11</mysql.connector.version>
   <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
               <version>${mysql.connector.version}</version>
           </dependency>
   ```

   



applicationContext.xml配置文件示例

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc" xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
  http://www.springframework.org/schema/beans/spring-beans.xsd
  http://www.springframework.org/schema/context
  https://www.springframework.org/schema/context/spring-context.xsd
  http://www.springframework.org/schema/mvc
  https://www.springframework.org/schema/mvc/spring-mvc.xsd
  http://mybatis.org/schema/mybatis-spring
  http://mybatis.org/schema/mybatis-spring.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">

    <context:property-placeholder location="classpath:supermarket.properties"/>
    <!--  配置注解扫描，让spring容器在初始化的时候，扫描指定包路径下的所有类，管理被注解标记的bean-->
    <context:component-scan base-package="club.banyuan"/>

    <!--  扫描requestMapping 让处理url的路径配置生效 -->
    <mvc:annotation-driven/>

    <!--  重新映射静态资源路径，使得浏览器的url不需要在路径上增加pages即可访问页面-->
    <mvc:resources mapping="/**" location="/pages/"/>

    <mvc:interceptors>
        <mvc:interceptor>
            <!--  /**/*.html =>  /home_page.html  /abc/home_page.html    -->
            <!--  /*/*.html =>  /abc/home_page.html  无法匹配/home_page.html -->
            <!-- /server/user/login -->
            <mvc:mapping path="/*/*.html"/>
            <mvc:mapping path="/server/*/*"/>
            <mvc:exclude-mapping path="/user/login.html"/>
            <mvc:exclude-mapping path="/server/user/login"/>
            <bean class="club.banyuan.common.AuthInterceptor"/>
        </mvc:interceptor>
    </mvc:interceptors>

    <!-- mybatis -->

    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${driver}"/>
        <property name="jdbcUrl" value="${url}"/>
        <property name="user" value="${name}"/>
        <property name="password" value="${password}"/>
    </bean>

    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="mapperLocations" value="classpath*:mapper/*.xml"/>
        <property name="configLocation" value="classpath:mybatis/mybatis-config.xml"/>
    </bean>

    <!-- 使 spring 能够获得 dao -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--    多个包路径使用,隔开-->
        <property name="basePackage"
                  value="
                  club.banyuan.user.dao
                  club.banyuan.provider.dao
                  club.banyuan.bill.dao
                  "/>
    </bean>

<!--    <aop:aspectj-autoproxy proxy-target-class="true"/>-->

</beans>
```

pom.xml配置文件示例

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>club.banyuan</groupId>
    <artifactId>hrms-spring-aop</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <spring.version>5.2.3.RELEASE</spring.version>
        <jackson.version>2.9.1</jackson.version>
        <dbutils.version>1.7</dbutils.version>
        <hutool.version>5.4.1</hutool.version>
        <c3p0.version>0.9.5.5</c3p0.version>
        <servlet.version>4.0.1</servlet.version>
        <mysql.connector.version>8.0.11</mysql.connector.version>
        <mybatis.version>3.5.5</mybatis.version>
    </properties>

    <dependencies>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>

        <!--    spring mybatis集成  SqlSessionFactoryBean -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.5</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!--    org.springframework.web.servlet.DispatcherServlet -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!--   用来将返回的对象转换为json格式  -->
        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>${jackson.version}</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>${jackson.version}</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>${jackson.version}</version>
        </dependency>

        <!-- jdbc的工具集，封装了查询和组装对象的方法 -->
        <!-- https://mvnrepository.com/artifact/commons-dbutils/commons-dbutils -->
        <dependency>
            <groupId>commons-dbutils</groupId>
            <artifactId>commons-dbutils</artifactId>
            <version>${dbutils.version}</version>
        </dependency>

        <!--    工具集合，使用其中的Hash算法工具 -->
        <!-- https://mvnrepository.com/artifact/cn.hutool/hutool-all -->
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>${hutool.version}</version>
        </dependency>

        <!-- 管理数据源连接池的包 -->
        <!-- https://mvnrepository.com/artifact/com.mchange/c3p0 -->
        <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>${c3p0.version}</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>${servlet.version}</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.connector.version}</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.73</version>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>

                <configuration>
                    <path>/supermarket</path> <!-- 项目访问路径 本例：localhost:9090, 如果配置的aa，则访问路径为localhost:9090/aa -->
                    <port>8080</port>
                    <!--                     <uriEncoding>UTF-8</uriEncoding>&lt;!&ndash; 非必需项 &ndash;&gt;-->
                </configuration>
            </plugin>
            <plugin>
                <!-- https://mvnrepository.com/artifact/org.eclipse.jetty/jetty-maven-plugin -->
                <groupId>org.eclipse.jetty</groupId>
                <artifactId>jetty-maven-plugin</artifactId>
                <version>9.4.31.v20200723</version>
                <configuration>
                    <scanIntervalSeconds>1</scanIntervalSeconds>
                    <httpConnector>
                        <port>8080</port>
                    </httpConnector>
                    <webAppConfig>
                        <contextPath>/supermarket</contextPath>
                    </webAppConfig>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```

