-- 删除tb_brand表
DROP TABLE IF EXISTS tb_brand;

-- 创建tb_brand表
CREATE TABLE tb_brand(
	id INT PRIMARY KEY auto_increment,	-- id 主键
	brand_name VARCHAR(20),		-- 品牌名称
	company_name VARCHAR(20),		-- 企业名称
	ordered INT,		-- 排序字段
	description VARCHAR(100), -- 描述信息
	status INT  -- 状态：0：禁用  1：启用
);

-- 添加数据
INSERT INTO tb_brand(brand_name,company_name,ordered,description,status) VALUES('三只松鼠','三只松鼠股份有限公司',5,'好吃不上火',0),
('华为','华为技术有限公司',100,'华为给你增智慧 4g手机卖5000',1),
('小米','小米技术有限公司',50,'are you ok',1);

SELECT * FROM tb_brand;