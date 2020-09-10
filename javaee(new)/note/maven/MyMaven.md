# Maven知识点

## pom.xml文件配置

1. `provided`参与编译代码，但是不会被打包到构建中，表示该依赖包由外部提供
   `<scope>provided<scope>`
2. 默认`scope` 为`compile`，表示依赖包参与编译，并且会被打包到构件中
   `<scope>compile<scope>`
3. `runtime`表示不参与编译，不提供也可以编译生成字节码文件，但是必须在运行的时候提供，runtime标记的依赖包会被打包到构件中
   `<scope>compile<scope>`

```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>club.banyuan</groupId>
  <artifactId>webapp-maven-project</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <name>webapp-maven-project Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  // 解决字符编码以及版本号问题
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
  </properties>


  <!--  provided 参与编译代码，但是不会被打包到构建中，表示该依赖包由外部提供-->
  <dependencies>
    
    <!-- jdbc的工具集，封装了查询和组装对象的方法 -->
    <!-- https://mvnrepository.com/artifact/commons-dbutils/commons-dbutils -->
    <dependency>
      <groupId>commons-dbutils</groupId>
      <artifactId>commons-dbutils</artifactId>
      <version>1.7</version>
    </dependency>
    
    <!--    工具集合，使用其中的Hash算法工具 -->
    <!-- https://mvnrepository.com/artifact/cn.hutool/hutool-all -->
    <dependency>
      <groupId>cn.hutool</groupId>
      <artifactId>hutool-all</artifactId>
      <version>5.4.1</version>
    </dependency>

    <!-- 管理数据源连接池的包 -->
    <!-- https://mvnrepository.com/artifact/com.mchange/c3p0 -->
    <dependency>
      <groupId>com.mchange</groupId>
      <artifactId>c3p0</artifactId>
      <version>0.9.5.5</version>
    </dependency>
    
    <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>

    <!--    默认scope 为compile， 表示依赖包参与编译，并且会被打包到构件中-->
    <dependency>
      <groupId>dom4j</groupId>
      <artifactId>dom4j</artifactId>
      <version>1.6.1</version>
    </dependency>

    <!--    runtime 表示不参与编译，不提供也可以编译生成字节码文件，但是必须在运行的时候提供，runtime标记的依赖包会被打包到构件中-->
    <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.21</version>
      <scope>runtime</scope>
    </dependency>

    <!--    scope test 表示依赖包仅作用于测试阶段，用于执行测试用例-->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <finalName>webapp-maven-project</finalName>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.1.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.8.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.22.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
      </plugins>
    </pluginManagement>
  </build>
</project>
```

