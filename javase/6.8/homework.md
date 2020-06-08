# 作业
## 上午
1. 抄写一份Hello.java放到当前路径下，编译运行Hello.java，请记录打开终端开始到程序运行期间所有输入的终端命令
    1. cd Semicircle/javase/6.8/
    1. javac Hello.java
    1. java Hello

2. 将编译生成的Hello.class文件删除，编辑Hello.java将class后面的名称修改为test，然后编译Hello.java文件
    - 生成的class文件名是什么<br>
        答：test.class
    - 请尝试使用java运行编译后的文件，应该输入什么命令<br>
        答：java test
3. 保持上一题的状态，编辑Hello.java将class后面的名称修改为Test，然后编译Hello.java
    - 是否生成新的class文件<br>
        答：未生成新的文件。
    - 请尝试使用java运行编译后的文件，应该输入什么命令<br>
        答：java Test
    - 将test.class 重命名为test1.class后尝试运行，是否可以运行成功，如果不成功记录错误<br>
        答：无法运行，显示无法加载主类
    - 将test.class 重命名为TEST.class尝试运行，是否可以运行成功，如果不成功记录错误<br>
        答：java Test
4. 仿照Hello.java写一个HelloWorld.java, 其中class声明为HelloWorld，向屏幕输出Hello World!
    ```
    class HelloWorld{
	    public static void main(String[] args) {
		    System.out.println("Hello World!");
	    }
    }
    ```