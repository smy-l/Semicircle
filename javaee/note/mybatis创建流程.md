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

## 各种文件配置

###    SqlMapConfig.xml文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE configuration     PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-config.dtd">
<!--    作用：可以让mapper文件中(Dao)type只写类名不用写包名-->
<!-- 注：只可以让resultType不写包名 -->
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

###    Mapper文件

   示例：UserDao.xml

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE mapper     PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   
   <!-- Mapper文件 dao接口-->
   <!-- mapper中的namespace属性：填写dao接口-->
   <mapper namespace="club.banyuan.dao.UserDao">
     <!-- select：针对select的sql语句 -->
     		<!-- id: dao接口中方法名 -->
     		<!-- resultType: 查询结果每一行的封装后的Java类型 -->
       <select id="getAll" resultType="club.banyuan.pojo.User">
           select * from user;
       </select>
   </mapper>
   ```

###    Test文件

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

