SHOW TABLES;

-- 查询所有数据
SELECT
	* 
FROM
	stu;


-- 给指定列添加数据
INSERT INTO stu(id,name) VALUES (3,'张三');


-- 给所有列添加数据 (批量添加)
INSERT INTO stu
(id	-- 编号	
,name,gender,birthday,score,email,tel,status) VALUES(5,'李四','男','1999-11-11','88.88','testfja@qq.com','111000',1);

INSERT INTO stu VALUES(2,'李四','男','1999-11-11','88.88','testfja@qq.com','111000',1);


-- 修改数据
UPDATE stu set gender ='男' WHERE id = 1;

UPDATE stu set birthday = '1999-12-12', score = 99.99 WHERE id = 1;


-- 删除数据
DELETE FROM stu WHERE id = '5';
