USE sb1;
DESC stu;
DROP TABLE stu;

-- 创建表添加非空约束
CREATE TABLE stu ( 
id INT, 
NAME VARCHAR ( 20 ) NOT NULL-- NAME为非空
);
-- 删除name的非空约束
ALTER TABLE stu MODIFY NAME VARCHAR(20);

DELETE FROM stu WHERE id = 2;

-- 创建表完后添加非空约束 
ALTER TABLE stu MODIFY NAME VARCHAR(20) NOT NULL;


SELECT * FROM stu;

INSERT INTO stu VALUES(1, '张三丰');
INSERT INTO stu VALUES(2, NULL);

DROP TABLE stu;
-- 创建表添加唯一约束
CREATE TABLE stu ( 
id INT, 
phone_number VARCHAR ( 20 ) UNIQUE -- 添加了唯一约束
);
-- MySQL中，唯一约束限定的值可以有多个null


-- 删除唯一约束
ALTER TABLE stu DROP INDEX phone_number;

DELETE FROM stu WHERE id = 5;

-- 在创建标后，添加唯一约束
ALTER TABLE stu MODIFY phone_number VARCHAR(20) UNIQUE;

SELECT * FROM stu;

INSERT INTO stu VALUES(1, '1111');
INSERT INTO stu VALUES(2, '1112');
INSERT INTO stu VALUES(3, NULL);
INSERT INTO stu VALUES(4, NULL);
INSERT INTO stu VALUES(5, '1111');

DROP TABLE stu;

CREATE TABLE stu ( 
        id INT PRIMARY KEY, -- 给id添加主键约束
        NAME VARCHAR ( 20 )
        );

-- 删除主键
ALTER TABLE stu DROP PRIMARY KEY;

-- 创建完表后添加主键约束
ALTER TABLE stu MODIFY id INT PRIMARY KEY;

SELECT * FROM stu;


INSERT INTO stu VALUES(1, 'aaa');
INSERT INTO stu VALUES(2, 'bbb');
INSERT INTO stu VALUES(null, 'ccc');-- 主键不能非空


DROP TABLE stu;
CREATE TABLE stu ( 
            id INT PRIMARY KEY AUTO_INCREMENT, -- 给id添加主键约束
            NAME VARCHAR ( 20 )
            );

-- 删除自动增长
ALTER TABLE stu MODIFY id INT;
-- 添加自动增长
ALTER TABLE stu MODIFY id INT AUTO_INCREMENT;


INSERT INTO stu VALUES(1, 'aaa');
INSERT INTO stu VALUES(null, 'bbb');