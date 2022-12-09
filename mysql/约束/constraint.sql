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