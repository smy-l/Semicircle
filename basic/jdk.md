# JDK相关
## 安装jdk、切换jdk
### jdk版本
Oracle JDK  学习免费,商用收费 网址:*www.oracle.com/technetwork/java/javase/downloads/*<br>
Open JDK  开源,免费 网址*http://jdk.java.net/*<br>
国内Oracle镜像文件   *https://repo.huaweicloud.com/java/jdk*

### 环境变量
显示java安装路径  `java -verbose`<br>
echo $PATH  *显示路径*<br>
export PATH=$PATH:路径  *添加路径* <br>
例如:<br>
`export PATH=$PATH:~/Desktop`  *在最后加上路径*<br>
`export PATH=~/Desktop:$PATH`  *在最前面加上路径*<br>
但是每次仅限当前终端，并未完全修改，若要完全修改，则需要更改.bash_profile<br>

mac对Java有一定支持，在bash终端下可以在.bash_profile文件中使用一下命令<br>
`export JAVA_HOME=$(/usr/libexec/java_home -v 11)`


**具体步骤**
在终端中使用以下命令(仅限mac)
1. vi ~/.bash_profile
2. 在文件中粘贴`export JAVA_HOME=$(/usr/libexec/java_home -v 11)`
3. source .bash_profile

在终端中使用以下命令(linux、mac)
1. vi ~/.bash_profile
2. 在文件中粘贴java路径,例如`export PATH=$PATH:~/Desktop`
3. source .bash_profile


## 其他
JVM为java虚拟机，JRE为运行环境，JDK包含JRE，运行一定要安装JDK<br>
java不需要自己释放空间，有程序自动完成，这个机制被称为垃圾回收