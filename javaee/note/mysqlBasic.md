# mySql在终端的操作

## 在终端进入mysql

1. 进入`/usr/local/mysql/bin`目录下
2. 输入`./mysql -u root -p`

## 在终端对数据库进行操作

1. 查看当前已有的数据库
   `show databases;` 
2.  创建数据库
   `create database 数据库名;`
3. 判断是否存在，如果不存在则创建数据库
   `create database if not exists 数据库名;`
4. 删除数据库
   `drop database数据库名`
5. 使用数据库
   - 查看正在使用的数据库
     `select database();`
   - 改变要使用的数据库
     `use 数据库名;`

## 在终端创建表

1. 创建表 `create table 表名(列名 属性, 列名 属性);`
   例：`create table student(id int, name varchar(20), birthday date);`

2. 查看表 `desc 表名;`
   例：`desc student;`

3. 删除表 `drop table 表名;`
   `drop table student;`

4. 修改表结构

   1. 增加字段`alter table 表名 add 列名 属性;`

      例：`alter table student add remark varchar(20);`

   2. 修改列属性 `alter table 表名 modify 列名 属性;`

      例：`alter table student modify remark varchar(100);`

   3. 修改列名 `alter table 表名 change 旧列名 新列名 属性;`
      例 ：`alter table student change remark intro varchar(30);`

   4. 删除列`alter table 表名 drop 列名;`
      例：`alter table student drop intro;`