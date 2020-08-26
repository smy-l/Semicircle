# maven

## 下载maven

网址 ***https://maven.apache.org/***

下载maven的压缩文件

将maven压缩文件解压，放到指定目录下即可

## maven配置环境变量

### window下

1. 找到环境变量，点击新建，配置`JAVA_HOMW`,`M2_HOME`和`MAVEN_HOME`三个环境变量
   如：

   ```
   JAVA_HOME    C:\Program Files\Java\jdk1.8.0_202
   M2_HOME      D:\Program Files\apache-maven-3.6.3
   MAVEN_HOME   D:\Program Files\apache-maven-3.6.3
   ```

2. 找到PATH，点击编辑，在末尾添加`%M2_HOME%\bin` 和 `%MAVEN_HOME%\bin`

3. 检验配置是否正确，在cmd中输入`mvn -v`，如果出现maven信息，则配置成功，否则，配置失败

### mac下

1. 编辑.bash_profile 文件：`vim~/.bash_profile`

2. 配置 maven 文件地址： 

   ```
   exportM2_HOME=/Users/xxx/Documents/maven/apache-maven-3.6.1 exportPATH=$PATH:$M2_HOME/bin
   ```

3. 保存文件，执行如下命令使配置生效： `source~/.bash_profile`

4. 检验配置是否正确，在终端中输入`mvn -v`，如果出现maven信息，则配置成功，否则，配置失败