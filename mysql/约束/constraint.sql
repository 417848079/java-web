-- 约束======================
DROP TABLE
IF
	EXISTS emp;
	
-- 1. 员工表
	
	
CREATE TABLE emp (
	id INT PRIMARY KEY auto_increment,-- 员工id，主键且自增长
	ename VARCHAR ( 50 ) NOT NULL UNIQUE,-- 非空且唯一
	joindate DATE NOT NULL,-- 入职日期 非空
	salary DOUBLE ( 7, 2 ) NOT NULL,-- 工资 非空
	bonus DOUBLE ( 7, 2 ) DEFAULT 0 -- 奖金，如果没有奖金默认为0
);

INSERT INTO emp(id,ename,joindate,salary,bonus) VALUES(1,'张三','1999-11-11',8800,5000);

-- 演示主键约束：非空且唯一

INSERT INTO emp(id,ename,joindate,salary,bonus) VALUES(NULL,'张三','1999-11-11',8800,5000);
INSERT INTO emp(id,ename,joindate,salary,bonus) VALUES(1,'张三','1999-11-11',8800,5000);
INSERT INTO emp(id,ename,joindate,salary,bonus) VALUES(2,'李四','1999-11-11',8800,5000);

-- 演示非空约束

INSERT INTO emp(id,ename,joindate,salary,bonus) VALUES(3,NULL,'1999-11-11',8800,5000);


-- 演示唯一约束

INSERT INTO emp(id,ename,joindate,salary,bonus) VALUES(3,'李四','1999-11-11',8800,5000);


-- 演示默认约束

INSERT INTO emp(id,ename,joindate,salary) VALUES(3,'王五','1999-11-11',8800);
INSERT INTO emp(id,ename,joindate,salary,bonus) VALUES(4,'赵六','1999-11-11',8800,NULL);

-- 演示自动增长：auto_increment: 当列是数字类型并且 唯一约束

INSERT INTO emp(ename,joindate,salary,bonus) VALUES('赵六','1999-11-11',8800,NULL);
INSERT INTO emp(id,ename,joindate,salary,bonus) VALUES(NULL,'赵六1','1999-11-11',8800,NULL);
INSERT INTO emp(id,ename,joindate,salary,bonus) VALUES(NULL,'赵六2','1999-11-11',8800,NULL);



SELECT * FROM emp;






-- 外键约束=======================
DROP TABLE IF EXISTS emp1;
DROP TABLE IF EXISTS dept;

-- 部门表
CREATE TABLE dept(
	id INT PRIMARY KEY auto_increment,
	dep_name VARCHAR(20),
	address VARCHAR(20)
);

-- 员工表
CREATE TABLE emp1(
id int PRIMARY KEY auto_increment,
name VARCHAR(20),
age INT,
dep_id INT,

 -- 添加外键 dep_id,关联dept表的id主键
CONSTRAINT fk_emp1_dept FOREIGN KEY(dep_id) REFERENCES dept(id)
 
);

-- 添加部门

INSERT into dept(dep_name,address) VALUES ('研发部','广州'),('销售部','深圳');


-- 添加员工,dep_id 表示员工所在的部门

INSERT into emp1(name,age,dep_id) VALUES
 ('张三',20,1),
 ('李四',20,1),
 ('王五',20,1),
 ('赵六',20,2),
 ('孙柒',18,2),
 ('周八',22,2);
 
 -- 删除外键
 alter TABLE emp1 DROP FOREIGN KEY fk_emp1_dept;
 
 -- 添加外键
 ALTER TABLE emp1 ADD CONSISTENT fk_emp1_dept FOREIGN key(dep_id) REFERENCES dept(id);
 
 
 
 SELECT * FROM emp1;
 
 SELECT * FROM dept;

