-- 基础查询  ==========

USE study;

SELECT * FROM stu2;



-- 查询name,age 两列
SELECT name,age FROM stu2; 


-- 查询地址信息
SELECT address FROM stu2;


-- 去除重复记录 
SELECT DISTINCT address FROM stu2;


-- 查询姓名,数学成绩，英语成绩
SELECT  name, math 数学, english as 英语 FROM stu2;




-- 条件查询 =======================

-- 1.查询年龄大于20岁的学员信息；

SELECT id,name,age,sex,address,math,english,hire_date FROM stu2 WHERE age > 20;


-- 2.查询年龄大于等于20岁的学员信息

SELECT * FROM stu2 WHERE age >= 20;


-- 3.查询年龄大于等于20岁 并且年龄小于等于30岁的学员

SELECT * FROM stu2 WHERE age >= 20 && age < =30;
SELECT * FROM stu2 WHERE age >= 20 and age < =30; -- 建议使用and 不使用&&
SELECT * FROM stu2 WHERE age BETWEEN 20 and 30;


-- 4.查询入学日期在1998-01-01到1999-01-01之间的学员

SELECT * FROM stu2 WHERE hire_date BETWEEN '1998-01-01' and '1999-01-01';


-- 5.查询年龄等于18岁的学员信息

SELECT * FROM stu2 WHERE age =18; 


-- 6.查询年龄不等于18岁的学员信息;

SELECT * FROM stu2 WHERE age !=18;
SELECT * FROM stu2 WHERE age <> 18;


-- 7.查询年龄等于18岁 或者 年龄等于20岁 或者 年龄等于 22岁的学员信息

SELECT * FROM stu2 WHERE age = 18 or age =20 or age = 22;
SELECT * FROM stu2 WHERE age IN (18,20,22);


-- 8. 查询英语成绩为null的学员信息；

SELECT * FROM stu2 WHERE english is null;
SELECT * FROM stu2 WHERE english is not null;




-- 模糊查询=================================================================
/*
通配符：
（1）_ :代表单个任意字符
（2）% ：代表任意个数字符
*/

-- 1.查询姓马的学员
SELECT * FROM stu2 WHERE name LIKE '马%';


-- 2.查询第二个字市‘化’的学员
SELECT * FROM stu2 WHERE name LIKE '_化%';


-- 3.查询名字中包含'德'的学员
SELECT * FROM stu2 WHERE name LIKE '%德%';



-- 排序=============================================

-- 1.查询学生信息，按照年龄升序排列
SELECT * FROM stu2 ORDER BY age;

 
-- 2. 查询学生信息，按照数学成绩降序排列
SELECT * FROM stu2 ORDER BY math DESC;


-- 3.查询学生信息，按照数学成绩降序排列，如果数学成绩一样，在按照英语成绩升序排列

SELECT * FROM stu2 ORDER BY math DESC , english ASC;




-- 聚合函数=========================================

-- 1.统计班级一共有多少个学员

SELECT COUNT(id) FROM stu2;			-- count 统计的列名不能为null
SELECT COUNT(english) FROM stu2;
SELECT COUNT(*) FROM stu2;



-- 2.查询数学成绩的最高分

SELECT MAX(math) FROM stu2;


-- 3.查询数学成绩的最低分

SELECT min(math) FROM stu2;


-- 4.查询数学成绩的总分

SELECT SUM(math) FROM stu2;


-- 5.查询数学成绩的平均分
SELECT AVG(math) FROM stu2;

-- 6.查询英语成绩的最低分
SELECT MIN(english) FROM stu2;




-- 分组查询=======================================
