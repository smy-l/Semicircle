# mybatis创建流程

1. 创建maven工程，groupId，artifactId，version，packaging (jar)
2. 在pom.xml添加MyBatis框架坐标，JDBC坐标
3. 编写Mybatis的核心文件配置文件(SqlMapConfig.xml)，在resources目录下连接数据库信息 (4个参数dirver、url、username、password) Mapper文件路径
4. 编写实体类，dao接口
5. 编写Mapper文件，文件的路径配置到SqlMapConfig.xml中，放在resources目录下，路径和dao接口路径一致，文件名和接口一致
   示例：
   UserDao  --> UserMapper
   配置sql语句
6. 测试

## 持久层接口(UserDao)

```java
package club.banyuan.dao;

import club.banyuan.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
  List<User> getAll();
  User getUserByNameAndPwd(@Param("loginname") String loginname, @Param("password") String password);
  User getUserAndOrder(int userId);
}

```

## 持久成接口映射文件(UserDao.xml)

###    Mapper文件

   示例：UserDao.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE mapper     PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   
   <!-- Mapper文件 dao接口-->
   <!-- mapper中的namespace属性：填写dao接口-->
   <mapper namespace="club.banyuan.dao.UserDao">
     <!-- select：针对select的sql语句
        		id: dao接口中方法名
     				resultType: 查询结果每一行的封装后的Java类型 -->
      <select id="getAll" resultType="club.banyuan.pojo.User">
        select * from user;
     	</select>
     
     <!-- insert: 针对sql中的insert语句 -->
<!--  	返回值都是int类型，不需要再配置resultType，对数据表操作了多少行
    		parameterType：
					如果参数只有一个，是实体类类型，保持和方法的参数类型一致
   			sql语句中的参数值是从ParameterType中的getXXX方法中得到的
            sql中的参数名要和类型的属性一致，#{类型属性名，注意大小写}
-->     
     	<insert id="addUser" parameterType="User">
        insert into User values(
                                null,
                                #{loginName},
                                #{userName},
                                #{password},
                                #{sex},
                                #{identityCode},
                                #{email},
                                #{mobile},
                                #{type}
                             );
     	</insert>

    	<update id="updateUser" parameterType="User">
      	update user set loginName = #{loginName},
                        userName = #{userName},
                        password = #{password},
                        sex = #{sex},
                        identityCode = #{identityCode},
                        email = #{email},
                        mobile = #{mobile},
                        type = #{type}
                    where id = #{id}
    	</update>

     <!-- parameterType：
 				如果参数只有一个，是基本数据类型+String，保持和方法的参数类型一致
     			sql语句中的参数值是从方法的参数中获取
              sql中的参数名可以随便，但是一般写方法的参数名  
							即：#{方法的参数名}
-->
    	<delete id="delUser" parameterType="int">
        	delete from user where id=#{id}
    	</delete>
   </mapper>
   ```

##    SqlMapConfig.xml文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE configuration     PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--    作用：可以让mapper文件中(Dao)type只写类名不用写包名-->
<!-- 注：只可以让resultType -->
    <typeAliases>
        <package name="club.banyuan.pojo"/>
    </typeAliases>

   <configuration>
     <!-- 
		environments: 可以包含多个数据库配置信息
    	default：默认情况下，使用哪个数据库配置，内容是environment的id属性
    environment: 配置一个数据库信息，id属性就是这个数据库配置的标识
    	transactionManger: 数据库事务管理器交个JDBC处理数据库事务，默认把自动提交事务关闭了，手动提交和回滚
     	dataSource: 配置数据源，数据库连接信息
     		type: POOLED，使用的数据库连接管理工具是采用MyBatis自带的数据库连接池 			-->
     
       <environments default="mysql">
           <environment id="mysql">
               <transactionManager type="JDBC"></transactionManager>
               <dataSource type="POOLED">
                   <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                   <property name="url" value="jdbc:mysql://localhost:3306/db_shoppingStreet?&amp;useSSL=false&amp;serverTimezone=UTC"/>
                   <property name="username" value="root"/>
                   <property name="password" value="12345678"/>
               </dataSource>
           </environment>
       </environments>
   
       <mappers>
           <mapper resource="club/banyuan/dao/UserDao.xml"/>
       </mappers>
   
   </configuration>
   
   
   ```

##    Test文件

   示例：TestUserDao.java

```java
import club.banyuan.pojo.User;
import club.banyuan.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestUserDao {
    @Test
    public void testGetAll() throws IOException {
//        获取连接信息（配置在SqlMapConfig.xml）,所以读取配置文件
//        在classpath下找SqlMapConfig.xml，并读取到InputStream流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactory创建管理连接，实例化Factory，将数据库信息传递给它
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
//        创建Session对象：
//                类似Connection，强大
        SqlSession session = sqlSessionFactory.openSession();

//        获取dao接口的实现类对象
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> userList = userDao.getAll();

        System.out.println(userList.size());

        for(User user : userList){
            System.out.println(user);
        }

        //事务提交
        session.commit();
//        资源关闭
        session.close();
    }
}

```

## 总结

- 持久层接口和持久层接口的映射配置必须在相同的包下
- 持久层映射配置中 mapper 标签的 namespace 属性取值必须是持久层接口的全限

定类名

- SQL 语句的配置标签\<select\>,\<insert\>,\<delete\>,\<update\>的 id 属性必须和持久层接口的 方法名相同。

## parameterType：

1. 方法的参数是多个，但已经封装在类中 (都是来源于一个类)  parameterType = 类名 sql中参数就是#{属性名}
2. 方法的参数是一个 (基本数据类型 + String)  parameterType = 方法的参数类型，sql中的参数${方法的参数名}
3. 方法的参数是多个，但不是来源于一个类
   1. 将这些参数封装到一个map集合 parameterType = map sql中的参数 #{map的key}
   2. 定义一个VO类，将参数放到对应的VO类的属性中 paramterType = VO类，sql中的参数#{VO类的属性}
4. 方法的参数是多个，但已经封装到一个数组/List中，只出现在in查询

## resultType：

1. 查询结果中的每一行都可以封装到某个类的对象中 (多行/一行 多列)，resultType为类的类型
2. 查询结果是一行一列和多行一列，resultType为对应的java类型
3. 查询结果中的每一行不能封装到某个类的对象中 (多行/一行 多列)
       定义一个vo类，将查询结果中的写入到vo类中的属性
4. 增删改sql的返回值都是int，所以不用写resultType

## 查询结果封装的时候，列名和java中的属性名不一致

1. 将列名取别名，让别名与类名的属性名保持一致

2. 定义ResultMap，让列名和类的属性名对应上，

   注意：在select中，把resultType换成resultMap

## sql 语句中使用#{}字符

它代表占位符，相当于原来 jdbc 部分所学的?, 用于执行语句是替换实际的数据

**#{}中的内容的写法**：由于数据类型是基本类型，所以此处可以随意写

