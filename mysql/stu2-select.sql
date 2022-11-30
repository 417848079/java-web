-- 创建stu2表
CREATE TABLE stu2 (
	id INT,	-- 编号
	name VARCHAR, -- 姓名
	age INT, -- 年龄
	sex VARCHAR, -- 性别
	address VARCHAR(100), -- 地址
	math DOUBLE(5,2), -- 数学成绩
	english DOUBLE(5,2), -- 英语成绩
	hire_date date, -- 入学时间
)


-- 添加数据
INSERT INTO sty2(id,NAME,age,sex,address,math,english,hire_date) VALUES
(1,'马云',55,'男','杭州',66,78,'1998-01-01')
(2,'马化腾',45,'女','深圳',98,99,'1999-09-01')
(3,'马斯克',55,'男','香港',56,77,'2000-01-01')
(4,'留白',33,'女','广东',62,75,'2008-01-01')
(5,'柳青',20,'女','云南',66,78,'1998-01-01')


