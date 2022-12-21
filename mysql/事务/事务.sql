DROP TABLE IF EXISTS account;

-- 创建账户表
CREATE TABLE account(
	id INT PRIMARY KEY auto_increment,
	name VARCHAR(10),
	money DOUBLE(10,2)
);

-- 添加数据
INSERT INTO account(name,money) VALUES ('张三',1000),('李四',1000);
UPDATE account set money=1000;
SELECT * FROM account;

-- 转账操作
-- 开启事务
BEGIN;

-- 1.查询李四的金额
SELECT * FROM account WHERE name='李四';

-- 2.李四金额-500
UPDATE account SET money=money-500 WHERE name='李四';

-- 3.张三金额+500
UPDATE account SET money=money+500 WHERE name='张三';

-- 提交事务
COMMIT;	

-- 回滚事务
ROLLBACK;


-- 查询事务的默认提交方式
SELECT @@autocommit;

-- 修改事务的提交方式 手动提交
SET @@autocommit = 0;
