-- 删除tb_user表
DROP TABLE IF EXISTS tb_user;

-- 创建tb_user表
CREATE TABLE tb_user(
	id INT PRIMARY KEY auto_increment,
	username VARCHAR(20),
	password VARCHAR(32)
);

-- 添加数据
INSERT INTO tb_user(username,password) VALUES('张三','qwer'),('lisi','qwera');

SELECT * FROM tb_user;