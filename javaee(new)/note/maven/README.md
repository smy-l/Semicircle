
```
mvn archetype:generate
```

```
mvn archetype:generate -DgroupId=club.banyuan -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

解决编译版本问题
```
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
  </properties>

```

## 使用maven直接运行main方法
```
mvn exec:java -Dexec.mainClass="club.banyuan.RandomStudentsRefine"
```


## poms
### pom1
打包的时候不添加 maven的说明文件到jar包

### pom2
single jar

### pom3
dependency assembly

