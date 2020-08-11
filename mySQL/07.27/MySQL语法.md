```sql
# 学生表
create table student (
	sno int not null AUTO_INCREMENT,
	sname varchar(10) not null,
	ssex varchar(2) not null,
	classNo int,
	PRIMARY	KEY (`sno`)
);
	
# 老师表
create table teacher (
	tno int not null AUTO_INCREMENT,
	tname varchar(10) not null,
	tsex varchar(2) not null,
	depart varchar(10) not null,
	PRIMARY KEY (`tno`)
);
	
# 课程表
create table course (
  cno int not null,
	cname varchar(20) not null,
	tno int not null,
	PRIMARY KEY (`cno`,`tno`)
);
	
# 成绩表
create table score (
	sno int not null,
	cno int not null,
	degree int not null,
	PRIMARY KEY (`sno`,`cno`)
);

# 插入数据
insert into student(sno, sname, ssex, classNO) values (101, '李华', '男', 90301);
insert into student(sno, sname, ssex, classNO) values (102, '孙蓉', '女', 90301);
insert into student(sno, sname, ssex, classNO) values (103, '赵明', '男', 90301);
insert into student(sno, sname, ssex, classNO) values (104, '李鹏', '男', 90302);
insert into student(sno, sname, ssex, classNO) values (105, '吴天', '男', 90302);
insert into student(sno, sname, ssex, classNO) values (106, '沈月', '女', 90302);

insert into teacher(tno, tname, tsex, depart) values (9011, '钱程', '男', '计算机');
insert into teacher(tno, tname, tsex, depart) values (9012, '周路', '男', '计算机');
insert into teacher(tno, tname, tsex, depart) values (9013, '王欢', '女', '经济学');
insert into teacher(tno, tname, tsex, depart) values (9014, '张铁', '男', '机械');

insert into course(cno, cname, tno) values (3102, '计算机导论', 9011);
insert into course(cno, cname, tno) values (3103, '数据库', 9012);
insert into course(cno, cname, tno) values (4101, '经济法', 9013);

insert into score(sno, cno, degree) values(101, 3102, 89);
insert into score(sno, cno, degree) values(102, 3102, 90);
insert into score(sno, cno, degree) values(103, 3102, 95);
insert into score(sno, cno, degree) values(101, 3103, 79);
insert into score(sno, cno, degree) values(102, 3103, 88);
insert into score(sno, cno, degree) values(103, 3103, 92);
insert into score(sno, cno, degree) values(104, 4101, 78);
insert into score(sno, cno, degree) values(105, 4101, 85);
insert into score(sno, cno, degree) values(106, 4101, 89);

# 筛选student表中的sname, ssex, classNo属性
select sname, ssex, classNo
from student;

# 查询teacher表中所有学院名称，distinct去重
select distinct depart
from teacher;

# 查询teacher表中所有数据
select * from  teacher;

# 查询score表中80到90之间的数据
select * from score
where degree between 80 and 90;

# 查询score表中88, 90, 92的数据
SELECT * FROM score
WHERE degree IN(88, 90, 92);

# 查询score表中班级为90301或者性别为女的数据
SELECT * from student
WHERE classNo = 90301 or ssex = '女';	

# 按班级序号查询student表中的所有记录
SELECT * FROM student
ORDER BY classNo desc;

# 按照sno升序，degree降序 查询score表的所有记录
SELECT * FROM score 
ORDER BY sno ASC, degree DESC;

# 查询 90301 班级学生人数，count为统计 `(1)`括号中的数字随便写
SELECT COUNT(1) AS num
FROM student
WHERE classNo = 90301;

# 统计学生表男女比例
SELECT ssex, COUNT(1) AS num
from student 
GROUP BY ssex;

# 查询 score 表最高分的学生序号和课程序号及成绩
SELECT sno, cno, degree
FROM score
ORDER BY degree DESC LIMIT 1;

# 查询课程序号 4101 的平均分
SELECT AVG(degree)
FROM score
WHERE cno = 4101;

# 查询 score 表最低分大于 80 最高分小于 90 的学生序号
SELECT sno
FROM score
GROUP BY sno
HAVING MAX(degree) < 90 AND MIN(degree) > 80;

# 查询有课程的老师姓名，所在学院名称及所上课程名称
SELECT t.tname, t.depart, c.cname
FROM teacher t
inner join course c on t.tno = c.tno

# 查询学生序号，学生姓名，课程名称，课程成绩
select s.sno, s.sname, c.cname, sc.degree 
from student s
    inner join score sc on s.sno = sc.sno
    inner join course c on sc.cno = c.cno;

# 查询 90302 班级学生所选课程的平均分
SELECT sc.cno, AVG(degree)
from student s 
	INNER JOIN score sc ON ( s.sno = sc.sno)
WHERE classNo = '90301'
GROUP BY sc.cno;
```

