下载地址：
***https://tomcat.apache.org/download-90.cgi***

下载完成后，解压其到一个正常的文件夹(无中文，无空格)下
windows运行startup.bat
Mac,linux运行startup.sh

运行成功后，在浏览器中输入
***http://localhost:8080/***
若运行成功，则会显示界面



解决win10使用tomcat时，控制台出现`淇℃伅`乱码问题

1. 找到tomcat所在位置，打开`conf`文件夹，找到`logging.properties`文件

2. 将`java.util.logging.ConsoleHandler.encoding = UTF-8`修改为

   `java.util.logging.ConsoleHandler.encoding = GBK`

3. 重启idea即可