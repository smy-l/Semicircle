# IO流

## 文件

```
File file = new File("绝对路径"); // 直接写文件名，代表当前文件夹下的文件，也是路径

// 获取文件长度(大小，不是名字长度)
file.length(); // 返回long值

// 获取文件名字
file.getName(); // 返回String类型

// 判断是否是文件夹
file.isDirectory(); // 返回boolean值

// 判断文件是否存在
file.exists(); // 返回boolean
```

## 文件夹

```
File directory = new File("绝对路径");

// 获取文件夹大小(仅仅是文件夹大小，不包含文件夹下所有文件的大小)
file.length(); // 返回long值

// 获取文件夹名字
file.getName(); // 返回String类型

// 判断是否是文件夹
file.isDirectory(); // 返回boolean值

// 判断文件夹是否存在
file.exists(); // 返回boolean
```

### 遍历文件夹下所有文件，返回名称，和`ls`相似

```
// 返回文件夹下所有文件名称
File[] files = directory.listFiles();
for (File one : files) {
  System.out.println(one.getName());
}
```



## NewFile

```
File file = new File(""); // "" 代表相对路径，标识当前第一级目录

//获取相对路径
file.getCanonicalPath();

//构造方法
File file = new File("父路径", "子路径"); // 最终文件路径为父路径+子路径

// 创建文件夹  
file.mkdirs(); // 如果路径已经存在，返回false，如果不存在，依次创建路径，返回ture
```



## 字节输入流（inputStream）

1. 输入流最后一定要关闭否则浪费资源

```
private static void readFile() {
    File file = new File("demo.txt");
    InputStream is = null;  // 创建输入流
    try {
      is = new FileInputStream(file);  // 给输入流赋值
      byte[] bytes = is.readAllBytes(); // readAllBytess(); 返回byte[]数组
      System.out.println(new String(bytes)); // 将bytes转换问字符串
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (is != null) {     //最后一定会关闭输入流
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
```

### 常用API

```
is 为输入流实例对象

// 读取文件
is.read(); // 返回int值，代表读取了多少个字符

// 读取文件，将其装换为字节数组
is.readAllBytes(); // 返回btye[]数组
```



## 字节输出流（outputStream）

1. ```
   OutputStream os = new FileOutputSteram(file);
   // 输出流，如果文件中包含要添加的字段，则不会再次添加
   ```

2. ```
   OutputStream os = new FileOutputSteram(file);
   // 输入流，即使文件中包含要添加的字段，仍会（换行）添加
   ```

   

```
String words = "to be or not to be!";
    System.out.println(words);

    File file = new File("demo.txt");
    OutputStream os = null;
    try {
      os = new FileOutputStream(file, true);
      os.write("\n".getBytes());
      os.write(words.getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (os != null) {
        try {
          os.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
```



## 字符输入流（reader）

```
File demo = new File("demo.txt");

try (Reader reader = new FileReader(demo)) {
      char[] buf = new char[1024];
      int read = reader.read(buf);
      StringBuilder builder = new StringBuilder();
      while (read > 0) {
        builder.append(buf, 0, read);
        // System.out.println(new String(buf, 0, read));
        read = reader.read(buf);
      }
```



## 字节输出流（writer）

```
File demo = new File("demo.txt");

try (Writer writer = new FileWriter(demo)) {
  writer.write("你好");
} catch (IOException e) {
  e.printStackTrace();
}
```



## Buffered

```
BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(demo))
BufferedReader reader = new BufferedReader(new FileReader(demo))
```



## 字符流和字节流转换

```
BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("")));
    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("")));
```



