-- 1. 切换到MySQL数据库
USE mysql;
-- 2. 查询user表
SELECT * FROM `user`;

-- 创建用户
CREATE USER 'dxy0909'@'localhost' IDENTIFIED BY '582648316';

-- 删除用户
DROP USER 'dxy0909'@'localhost';


CREATE USER 'dxy0909'@'%' IDENTIFIED BY '123456';

-- 修改密码
UPDATE USER SET PASSWORD = PASSWORD('123') WHERE USER = 'dxy0909';

SET PASSWORD FOR 'dxy0909'@'%' = PASSWORD('asd'); -- 第二种


-- 查询权限
SHOW GRANTS FOR 'dxy0909'@'%';
-- 授予权限
GRANT SELECT,DELETE,UPDATE ON db3.account TO 'dxy0909'@'%';
-- 撤销权限
REVOKE UPDATE ON db3.account FROM 'dxy0909'@'%';