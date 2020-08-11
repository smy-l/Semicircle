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

## 语法
### 创建数据库
```sql
CREATE DATABASE <数据库名>;
```

### 删除数据库
```sql
DROP DATABASE <数据库名>;
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
CREATE TABLE table_name (column_name column_type);
```

### 删除数据表
```sql
DROP TABLE table_name;
```

### 插入数据
```sql
INSERT INTO table_name ( field1, field2,...fieldN ) VALUES ( value1, value2,...valueN );
```

### 查询数据
```sql
SELECT column_name, column_name
FROM table_name
[WHERE Clause]
[LIMIT N][ OFFSET M]
```

### 修改数据
```sql
UPDATE table_name SET field1=new-value1, field2=new-value2
[WHERE Clause]
```

### 删除数据
```sql
DELETE FROM table_name [WHERE Clause]
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
SELECT field1, field2,...fieldN FROM table_name1, table_name2...
[WHERE condition1 [AND [OR]] condition2.....
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
SELECT field1, field2,...fieldN 
FROM table_name
WHERE field1 LIKE condition1 [AND [OR]] filed2 = 'somevalue'
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
SELECT field1, field2,...fieldN FROM table_name1, table_name2...
ORDER BY field1 [ASC [DESC][默认 ASC]], [field2...] [ASC [DESC][默认 ASC]]
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
SELECT column_name, function(column_name)
FROM table_name
WHERE column_name operator value
GROUP BY column_name;
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

### 表连接的使用

+ INNER JOIN（内连接,或等值连接）：获取两个表中字段匹配关系的记录。
+ LEFT JOIN（左连接）：获取左表所有记录，即使右表没有对应匹配的记录。
+ RIGHT JOIN（右连接）： 与 LEFT JOIN 相反，用于获取右表所有记录，即使左表没有对应匹配的记录。

### 约束

#### 主键约束

用来唯一标识数据库中的每一条记录

