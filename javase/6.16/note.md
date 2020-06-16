# 6.16

1. str.toCharArray(); //将String str变为char[]
2. str.split(" "); //将str拆分，使用' '拆分

## jar

### jar压缩

1. jar cd main.jar .
   1. main.jar 是命名的jar包名
   2. 将当前文件夹下所有文件压缩到jar包中
2. jar cf main.jar out
   1. 将out文件下，包括out路径
3. jar cf main.jar -C out club
   1. 将out文件夹下，但是不包括out，club包下所有
4. jar cfe jar包名 文件名 路径
   1. 将文件添加到jar包

### 使用

1. javac -cp jar包名 方法名
2. java -c p jar包名 方法名

### 解压

1. jar tf jar包名
2. jar xf jar包名    --解压到当前文件夹
3. jar uf jar包名 -C out --追加文件，将其添加到jar包下
4. jar 



### 删除

1. zip -d jar包名 删除的文件名



