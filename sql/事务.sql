-- 创建数据表 
CREATE TABLE account ( 
		id INT PRIMARY KEY AUTO_INCREMENT, 
		NAME VARCHAR ( 10 ), 
		balance DOUBLE 
);
-- 添加数据 
INSERT INTO account (NAME, balance) VALUES ('zhangsan', 1000), ('lisi', 1000);
UPDATE account SET balance = 1000;

SELECT * FROM account;

-- 张三给李四转账 500 元
-- 0. 开启事务
START TRANSACTION;
-- 1. 张三账户 -500
UPDATE account SET balance = balance - 500 WHERE NAME = 'zhangsan';
-- 2. 李四账户 +500 
UPDATE account SET balance = balance + 500 WHERE NAME = 'lisi';

-- 执行没有问题，提交
COMMIT;

-- 发现问题，回滚事务
ROLLBACK;

SELECT @@autocommit; -- 1 代表自动提交，2 代表手动提交

-- SET @@autocommit = 1;

select @@tx_isolation;