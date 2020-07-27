## 练习

### 创建数据库
创建一个名称为 `db_company` 的数据库

### 创建数据表
创建一个名称为 `depart` 的表

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| deptNo | int | 部门序号 主键 |
| deptName | varchar | 部门名称 |
| city | varchar | 城市名称 |

创建一个名称为 `emyloyee` 的表

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| empNo | int | 员工序号 主键 |
| empName | varchar | 员工姓名 |
| job | varchar | 职位 |
| salary | int | 薪水 |
| deptNo | int | 部门序号 |

### 插入数据
要求 depart 表要有多条城市名称的数据，同一个城市名称下有多个部门

### 查询数据

#### 查询 depart 表中 deptName 和 city 列的所有数据

#### 查询 depart 表所有城市名称，需要去重

#### 查询 depart 表城市名称为 南京 的所有部门数据

#### 查询员工姓名姓张的员工数据

#### 查询薪水小于 3000 的所有员工数据

#### 查询薪水 在 5000 到 8000 之间的所有员工数据

#### 查询名称为 开发部 的部门平均薪水

#### 按照薪水降序排序查询员工数据

#### 按照薪水降序，姓名升序查询员工数据

#### 查询职位是 经理 的员工数量

#### 查询员工序号 员工姓名 和所在部门的名称

#### 查询城市在 南京 的员工数量

```
CREATE TABLE `depart` (
  `deptNo` int(20) NOT NULL COMMENT '部门序号',
  `deptName` varchar(20) NOT NULL COMMENT '部门名称',
  `city` varchar(20) NOT NULL COMMENT '城市名称',
  PRIMARY KEY (`deptNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `emyloyee` (
	empNo INT NOT NULL COMMENT '员工序号',
	empName VARCHAR(20) NOT NULL COMMENT '员工姓名',
	job VARCHAR(20) NOT NULL COMMENT '职位',
	salary INT NOT NULL COMMENT '薪水',
	deptNo INT NOT NULL COMMENT '部门序号',
	PRIMARY KEY (`empNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO depart(deptNo, deptName, city) VALUES (101, '销售部', '北京');
INSERT INTO depart(deptNo, deptName, city) VALUES (102, '客服部', '北京');
INSERT INTO depart(deptNo, deptName, city) VALUES (103, '开发部', '北京');
INSERT INTO depart(deptNo, deptName, city) VALUES (104, '测试部', '北京');
INSERT INTO depart(deptNo, deptName, city) VALUES (105, '运营部', '北京');

INSERT INTO depart(deptNo, deptName, city) VALUES (201, '销售部', '南京');
INSERT INTO depart(deptNo, deptName, city) VALUES (202, '客服部', '南京');
INSERT INTO depart(deptNo, deptName, city) VALUES (203, '开发部', '南京');
INSERT INTO depart(deptNo, deptName, city) VALUES (204, '测试部', '南京');
INSERT INTO depart(deptNo, deptName, city) VALUES (205, '运营部', '南京');

INSERT INTO depart(deptNo, deptName, city) VALUES (301, '销售部', '长沙');
INSERT INTO depart(deptNo, deptName, city) VALUES (302, '客服部', '长沙');
INSERT INTO depart(deptNo, deptName, city) VALUES (303, '开发部', '长沙');
INSERT INTO depart(deptNo, deptName, city) VALUES (304, '测试部', '长沙');
INSERT INTO depart(deptNo, deptName, city) VALUES (305, '运营部', '长沙');


INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10001, '张三', '员工', 5000, 101);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10002, '李四', '员工', 2000, 102);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10003, '王五', '经理', 10000, 103);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10004, '赵六', '员工', 5500, 104);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10005, '王二麻子', '员工', 7500, 105);

INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10006, '张一', '员工', 5500, 201);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10007, '张麻子', '经理', 10000, 202);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10008, '和二', '员工', 2500, 203);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10009, '老纪', '员工', 5500, 204);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10010, '金三', '员工', 5500, 205);

INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10011, '张章', '员工', 6000, 301);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10012, '李丽', '经理', 10000, 302);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10013, '和合', '员工', 2600, 303);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10014, '纪月', '员工', 8000, 304);
INSERT INTO emyloyee(empNo, empName, job, salary, deptNo) VALUES (10015, '金罗', '员工', 7000, 305);

#查询 depart 表中 deptName 和 city 列的所有数据
SELECT deptName, city
FROM depart;

#查询 depart 表所有城市名称，需要去重
SELECT DISTINCT city
FROM depart;

#查询 depart 表城市名称为 南京 的所有部门数据
SELECT * FROM depart
WHERE city = '南京';

#查询员工姓名姓张的员工数据
SELECT * from emyloyee
WHERE empName LIKE '张%';

#查询薪水小于 3000 的所有员工数据
SELECT * FROM emyloyee
WHERE salary < 3000;

#查询薪水 在 5000 到 8000 之间的所有员工数据
SELECT * FROM emyloyee
WHERE salary BETWEEN 5000 AND 8000;

# 查询名称为 开发部 的部门平均薪水
SELECT AVG(salary)
FROM emyloyee
WHERE deptNo = 103 or deptNo = 203 or deptNo = 303;

# 按照薪水降序排序查询员工数据
SELECT * FROM emyloyee
ORDER BY salary DESC;

# 按照薪水降序，姓名升序查询员工数据
SELECT * FROM emyloyee
ORDER BY salary DESC, empName ASC;

# 查询职位是 经理 的员工数量
SELECT COUNT(1) AS num
FROM emyloyee
WHERE job = '经理';

# 查询员工序号 员工姓名 和所在部门的名称
SELECT emp.empNo, emp.empName, dept.deptName
FROM emyloyee emp
	INNER JOIN depart dept ON emp.deptNo = dept.deptNo;

# 查询城市在 南京 的员工数量
SELECT COUNT(1) AS num
FROM emyloyee emp
	INNER JOIN depart dept ON emp.deptNo = dept.deptNo AND dept.city = '南京';
#	INNER JOIN depart dept ON dept.city = '南京';



```

