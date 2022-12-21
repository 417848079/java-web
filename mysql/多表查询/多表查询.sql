
DROP TABLE IF EXISTS emp2;
DROP TABLE IF EXISTS dept2;

-- 传教部门表
CREATE TABLE dept2(
	did INT PRIMARY KEY auto_increment,
	dname VARCHAR(20)
);


-- 创建员工表
CREATE TABLE emp2(
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(10),
	gender CHAR(1),
	salary DOUBLE,
	join_date DATE,
	dep_id INT,
	-- 添加外键
	CONSTRAINT fk_emp2_dept2 FOREIGN KEY(dep_id) REFERENCES dept2(did)
);

INSERT INTO emp2(name,gender,salary,join_date,dep_id) VALUES
('小白龙','男',5000,'2022-02-01',1),
('孙悟空','男',6000,'2022-01-20',1),
('孙尚香','女',4000,'2020-10-01',2),
('唐僧','男',5500,'2022-02-01',2),
('王昭君','女',6000,'2022-02-01',3),
('吕布','男',6000,'2022-02-01',3),
('小乔','女',5000,'2022-02-01',4),
('大乔','女',5000,'2022-02-1',4);

INSERT INTO dept2(dname) VALUES('研发部'),('销售部'),('财务部'),('系统部');

SELECT * FROM dept2;

SELECT * from emp2;


-- 多表查询

-- 隐式内连接
SELECT * FROM emp2,dept2 WHERE emp2.dep_id = dept2.did;

-- 查询emp2的name，gender， dept2表的dname
SELECT emp2.name,emp2.gender,dept2.dname	FROM emp2,dept2 WHERE emp2.dep_id=dept2.did;

-- 给表起别名
SELECT e2.name,e2.gender,d2.dname	FROM emp2 e2,dept2 d2 WHERE e2.dep_id=d2.did;

-- 显式内连接
SELECT * FROM emp2 INNER JOIN dept2 ON emp2.dep_id=dept2.did;
SELECT * FROM emp2 JOIN dept2 ON emp2.dep_id=dept2.did;


-- 左外连接
-- 查询emp2表所有数据和对应的部门信息
SELECT * FROM emp2 LEFT JOIN dept2 ON emp2.dep_id=dept2.did;

-- 右外连接
-- 查询dept2表所有数据和对应的员工信息
SELECT * FROM emp2 RIGHT JOIN dept2 on emp2.dep_id = dept2.did;



-- 子查询
-- 查询王昭君的工资	
SELECT salary FROM emp2 WHERE name='王昭君';

-- 查询工资高于王昭君的员工信息
SELECT * FROM emp2 WHERE salary >(SELECT salary FROM emp2 WHERE name='王昭君');

-- 查询研发部和销售部的所有员工信息
SELECT * FROM emp2 WHERE dep_id in (SELECT did FROM dept2 WHERE dname = '研发部' or dname='销售部');


-- 查询入职日期是'2020-10-01'之后的
SELECT * FROM (SELECT * FROM emp2 WHERE join_date > '2020-10-01') t1,dept2 WHERE t1.dep_id=dept2.did;



