## 简介
MySQL 是最流行的关系型数据库管理系统

## 特点

1. 数据以表格的形式出现
2. 每行为各种记录名称
3. 每列为记录名称所对应的数据域
4. 许多的行和列组成一张表
5. 若干的表组成数据库

## 术语

+ 数据库: 数据库是一些关联表的集合。
+ 数据表: 表是数据的矩阵。在一个数据库中的表看起来像一个简单的电子表格。
+ 列: 一列(数据元素) 包含了相同类型的数据, 例如邮政编码的数据。
+ 行：一行（=元组，或记录）是一组相关的数据，例如一条用户订阅的数据。
+ 主键：主键是唯一的。一个数据表中只能包含一个主键。你可以使用主键来查询数据。

## 01.基础语法以及CRUD操作
### 创建数据库
```sql
create database <数据库名>;
```

### 删除数据库
```sql
drop database <数据库名>;
```

### 数据类型
#### 数值类型
| 类型 | 大小 (bytes)| 用途 |
| --- | --- | --- |
| **`TINYINT`** | 1 | 小整数值 |
| SMALLINT | 2 | 大整数值 |
| MEDIUMINT | 3 | 大整数值 |
| **`INT`** | 4 | 大整数值 |
| **`BIGINT`** | 8 | 极大整数值 |
| FLOAT | 4 | 单精度浮点数值 |
| DOUBLE | 8 | 双精度浮点数值 |
| DECIMAL | 对DECIMAL(M,D) ，如果M>D，为M+2否则为D+2 | 小数值 |

#### 日期和时间类型
| 类型 | 大小 (bytes)| 格式 | 用途 |
| --- | --- | --- | --- |
| DATE | 3 | `YYYY-MM-DD` | 日期值 |
| TIME | 3 | `HH:MM:SS` | 时间值或持续时间 |
| YEAR | 1 | `YYYY` | 年份值 |
| **`DATETIME`** | 8 | `YYYY-MM-DD HH:MM:SS` | 混合日期和时间值 |
| TIMESTAMP | 4 | `YYYYMMDD HHMMSS` | 混合日期和时间值，时间戳 |

#### 字符串类型
| 类型 | 用途 |
| --- | --- |
| CHAR | 定长字符串 |
| **`VARCHAR`** | 变长字符串 |
| TINYBLOB | 不超过 255 个字符的二进制字符串 |
| TINYTEXT | 短文本字符串 |
| BLOB | 二进制形式的长文本数据 |
| **`TEXT`** | 长文本数据 |
| MEDIUMBLOB | 二进制形式的中等长度文本数据 |
| MEDIUMTEXT | 中等长度文本数据 |
| LONGBLOB | 二进制形式的极大文本数据 |
| LONGTEXT | 极大文本数据 |

### 创建数据表
```sql
create table table_name (column_name column_type);
```

### 删除数据表
```sql
drop table table_name;
```

### 插入数据
```sql
insert into table_name ( field1, field2,...fieldN ) values ( value1, value2,...valueN );
```

### 查询数据
```sql
select column_name, column_name
from table_name
[where Clause]
[limit N][ OFFSET M]
```

### 修改数据
```sql
update table_name set field1=new-value1, field2=new-value2
[where Clause]
```

### 删除数据
```sql
delete from table_name [where Clause]
```

### 别名

```sql
 select id as 编号, name as 姓名, age as 年龄 from student3 as stu;
```

### 查询结果参与运算

```sql
select math,english, math + english as 总成绩 from student3;
```

### WHERE 子句

```sql
select field1, field2,...fieldN from table_name1, table_name2...
[where condition1 [and [or]] condition2.....
```

#### 操作符
| 操作符 | 描述 |
| --- | --- |
| = | 等号，检测两个值是否相等 |
| <>, != | 不等于，检测两个值是否相等 |
| > | 大于号，检测左边的值是否大于右边的值 |
| < | 小于号，检测左边的值是否小于右边的值 |
| >= | 大于等于号，检测左边的值是否大于或等于右边的值 |
| <= | 小于等于号，检测左边的值是否小于或等于右边的值 |

#### 逻辑运算符

| 运算符 | 描述 |
| :----: | :--: |
|  and   |  与  |
|   or   |  或  |
|  not   |  非  |

### 范围查询

#### in关键字

```sql
-- 查询id是1，3，5的学生信息
select * from student3 where id in (1,3,5);

-- 查询id不是1，3，5的学生信息
select * from student3 where id not in (1,3,5);
```

#### between and关键字

```sql
-- 查询年龄在 30 到 50 之间的学生信息
select * from student3 where age between 30 and 50;
```

### 模糊查询(仅仅存在于字符串当中)

#### LIKE 子句

```sql
select field1, field2,...fieldN 
from table_name
where field1 like condition1 [and [or]] filed2 = 'somevalue'
```

#### 通配符

| 通配符 | 说明                     |
| ------ | ------------------------ |
| %      | 匹配任意多个字符串 (0,n) |
| _      | 匹配一个字符             |

```sql
-- 查询姓名第一个字是马的学生
select * from student3 where name like '马%';

-- 查询名字中包含德的学生
select * from student3 where name like '%德%';

-- 查询姓名第一个字是马，并且后面只有一个字的学生
select * from student3 where name like '马_';
```

### NULL 值处理

+ column_name IS NULL
+ column_name IS NOT NULL

### 排序

```sql
select field1, field2,...fieldN from table_name1, table_name2...
order by field1 [asc [desc][默认 asc]], [field2...] [asc [desc][默认 asc]]
```

```sql
-- 默认情况下从小到大(升序)
select * from student3 order by age;

-- 升序
select * from student3 order by age asc;

-- 降序
select * from student3 order by age desc;

-- 多个列排序
select * from student3 order by age, math desc;

-- 组合查询
select * from student3 where sex='男' order by age desc;
```

### 分组

```sql
select column_name, function(column_name)
from table_name
where column_name operator value
group by column_name;
```

### 聚合函数

​	**注：聚合函数不能和列放一起查询**

```sql
select max(math),name from student3;
```

1. max(列名)

   ```sql
   -- 查询数学成绩最高分
   select max(math) 最高分 from student3; 
   ```

2. min(列名)

   ```sql
   -- 查询数学成绩最低分
   select min(math) 最低分 from student;
   ```

3. avg(列名)

   ```sql
   -- 查询数学成绩平均分
   select avg(math) 平均分 from student; 
   ```

4. count(列名)  统计这一列有多少条记录

   ```sql
   -- 查询所有记录，总共有多少条
   select count(*) from student3;
   
   -- 查询english有多少条记录
   -- 如果english有一条记录为null，则记录会比查找*的记录少一条
   select count(english) from student3;
   ```

5. sum(列名)

   ```sql
   -- 查询数学成绩总分
   select sum(math) 总分 from student; 
   ```

- IFNULL

  ```sql
  -- ifnull(列名,默认值)
  select avg(ifnull(english,0)) from student3 where id = 4 or id = 5;
  ```

### 分组查询

1. **group by**

   ```sql
   -- 聚合函数可以和分组条件列(group by 列名)放在一起的
   select count(*),sex from student3 group by sex;
   
   -- 添加条件，年龄大于25岁
   select count(*),sex from student3 where age > 25 group by sex;
   ```

2. **having** 

   和where的区别

   having 不能单独使用，它必须使用在 group by 语句中

   where 针对于整张表的数据筛选，在分组之前，缩小分组的数据范围

   ```sql
   -- 对分组查询的结果，做数据筛选
   select count(*),sex from student3 where age > 25 group by sex having count(*) > 2;
   ```

### limit语句

```sql
-- limit 起始数据，需要几条记录
select * from student3 limit 0,4;
select * from student3 limit 4,4;
```

### 约束

#### 主键约束

用来唯一标识数据库中的每一条记录

```sql
-- 创建表 指定主键，并令其自增长
create table 表名(
列名 int primary key auto_increment
)auto_increment = 起始值;

-- 创建好后修改起始值
alter table 表名 auto_increment = 起始值;
```

#### 唯一约束

```sql
-- 格式
字段名 字段类型 unique

-- 示例
create tabel st7(
	id int,
	name varchar(20) unique
)
```

#### 非空约束

```sql
-- 格式
字段名 字段类型 not null

-- 示例
create tabel st8(
	id int,
	name varchar(20) not null,
	gender char(1)
)
```

***默认值***

```sql
-- 格式
字段名 字段类型 default 默认值

-- 示例
create table st9 (
id int,
name varchar(20),
address varchar(20) default '广州'
)

-- 添加一条记录，使用默认地址
insert into st9 values(1, '李四', default);
```

#### 外键约束

外键必须有一个和他关联的主键，并且其值一定在主键中存在

**添加外键约束**

```sql
-- 新建表是增加外键
constraint 外键约束名 foreign key

--已有表增加外键
alter table 从表 add constraint 外键约束名 foreign key (外键字段名) references 主表(主键字段名)；
注：外键名一般命名规范  主表_从表_字段名_FK 


-- 示例
create table employee(
id int primary key auto_increment, name varchar(20),
age int,
dep_id int, -- 外键对应主表的主键 
  -- 创建外键约束
constraint emp_depid_fk foreign key (dep_id) references department(id) 
);

-- 在 employee 表情存在的情况下添加外键
alter table employee add constraint emp_depid_fk foreign key (dep_id) references department(id);
```

**删除外键约束**

alter table 从表 drop foreign key 外键名称;

```sql
-- 示例
alter table employee drop foreign key emp_depid_fk;
```

**注：要先删除外键值，才能删除主键**



## 02.表间关系与多表查询

1. 一对多
   
2. 多对多
   
3. 一对一

   

### 表连接的使用

+ inner join（内连接,或等值连接）：获取两个表中字段匹配关系的记录。
+ left join（左连接）：获取左表所有记录，即使右表没有对应匹配的记录。
+ right join（右连接）： 与 LEFT JOIN 相反，用于获取右表所有记录，即使左表没有对应匹配的记录。

#### 内连接

1. 隐式内连接

   隐式内连接:看不到 join 关键字，条件使用 WHERE 指定

     select 字段名 from 左表, 右表 where 条件

   ```sql
   select * from emp,dept where emp.`dept_id` = dept.`id`;
   ```

2. 显式内连接

   显示内连接:使用 inner join ... on 语句, 可以省略 inner

   select 字段名 from 左表 inner join 右表 on 条件

   ```sql
   select * from emp e inner join dept d on e.`dept_id` = d.`id`;
   ```

**注：内连查询查询结果需要在主外键都存在数据的情况下使用**

### 外连接
1. 左外连接：使用 left outer join ... on，outer 可以省略

   select 字段名 from 左表 left [out] join 右表 on 条件

   ```sql
   -- 使用内连接查询
   select * from dept d inner join emp e on d.`id` = e.`dept_id`;
   
   -- 使用左外连接查询
   select * from dept d left join emp e on d.`id` = e.`dept_id`;
   ```

   注：会将左边表中的所有数据都显现出来，如果右表有对应信息，显示相应信息，没有则显示null

   ​	   左表一般放主键主表

   ​	   习惯用左外连

2. 右外连接：使用 RIGHT OUTER JOIN ... ON，OUTER 可以省略

   select 字段名 from 左表 left [out] join 右表 on 条件

   ```sql
   -- 使用内连接查询
   select * from dept d inner join emp e on d.`id` = e.`dept_id`;
   
   -- 使用右外连接查询
   select * from dept d right join emp e on d.`id` = e.`dept_id`;
   ```

   同左外连

### 事务

#### 手动提交事务

| 功能     | sql语句           |
| -------- | ----------------- |
| 开启事务 | start transaction |
| 提交事务 | commit            |
| 回滚事务 | rollback          |

开启事务 -> 执行语句 -> 成功则提交事务，失败则回滚事务

#### 自动提交事务

mysql每一条增删改语句默认是一个事务

**取消自动提交事务**(了解)

```sql
select @@autocommit;
```

#### 事务的四大特性

| 事务特性            | 含义                                                         |
| ------------------- | ------------------------------------------------------------ |
| 原子性(Atomicity)   | 每个事务都是一个整体，不可再拆分，事务中所有的 SQL 语 句要么都执行成功， 要么都失败。 |
| 一致性(Consistency) | 事务在执行前数据库的状态与执行后数据库的状态保持一致。 如:转账前 2 个人的 总金额是 2000，转账后 2 个人总金 额也是 2000 |
| 隔离性(Isolation)   | 事务与事务之间不应该相互影响，执行时保持隔离的状态           |
| 持久性(Durability)  | 一旦事务执行成功，对数据库的修改是持久的。就算关机，也是保存下来的 |

#### 事务隔离级别

| 并发访问的问题 | 含义                                                         |
| -------------- | ------------------------------------------------------------ |
| 脏读           | 一个事务读取到了另一个事务中尚未提交的数据                   |
| 不可重复读     | 一个事务中两次读取的数据内容不一致，要求的是一个事务中多次 读取时数据是一致的，这是事务 update 时引发的问题 |
| 幻读           | 一个事务中两次读取的数据的数量不一致，要求在一个事务多次读取的数据的数量是一致的，这是 insert 或 delete 时引发的问题 |

### 索引

1. 什么是索引

   相当于目录，让你快速定位所需信息的位置









## 遇到的一些问题

1. 出现问题：一个数字 + null 结果为null。
   解决方法：使用ifnull函数
   注：ifnull是在MySQL中的函数，其他数据库不一定是这个函数

```sql
-- ifnull(列名, 替换值)
sal + ifnull(comm, 0) from emp;
```



## 取消MySQL安全模式

```sql
set sql_safe_updates = 0;
```

