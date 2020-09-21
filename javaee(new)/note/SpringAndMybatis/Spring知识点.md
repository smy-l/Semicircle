# Spring知识点

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

   



applicationContext.xml配置文件示例

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

  <!-- class后面写全限定类名 -->
  <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
    <property name="driverClass" value="com.mysql.cj.jdbc.Driver"/>
    <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/hrms?useSSL=false"/>
    <property name="user" value="root"/>
    <property name="password" value="banyuan"/>
  </bean>

  <bean id="queryRunner" class="org.apache.commons.dbutils.QueryRunner">
    <!-- 调用已有的bean -->
    <constructor-arg ref="dataSource"/>
  </bean>

  <bean id="adminDaoDbUtilsImpl" class="club.banyuan.admin.dao.impl.AdminDaoDbUtilsImpl">
    <constructor-arg ref="queryRunner"/>
  </bean>

  <bean id="adminServiceImpl" class="club.banyuan.admin.service.impl.AdminServiceImpl">
    <property name="adminDao" ref="adminDaoDbUtilsImpl"/>
  </bean>

  <bean id="adminServiceOtherImpl" class="club.banyuan.admin.service.impl.AdminServiceOtherImpl" primary="true" >
    <property name="adminDao" ref="adminDaoDbUtilsImpl"/>
  </bean>

</beans>
```

