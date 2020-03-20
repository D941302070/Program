DESC stu;
USE db1;
INSERT INTO stu(id,NAME,age) VALUES(1,'张无忌',18); 
INSERT INTO stu VALUES(2,'赵敏',17,99.9,NULL,NULL);
INSERT INTO stu VALUES(3,'张三丰',17,99.9,"1893-11-11",NULL);

SELECT * FROM stu;

DELETE FROM stu WHERE id=1;

TRUNCATE TABLE STU; -- 删除表，然后再创建一个一模一样的表

UPDATE stu SET age=117 WHERE id = 3;
UPDATE stu SET age=18,score = 100 WHERE id = 2;

CREATE TABLE student (
	id INT,-- 编号 
	name varchar(20), -- 姓名
	age INT,-- 年龄
	sex VARCHAR ( 5 ),-- 性别
	address VARCHAR ( 100 ),-- 地址
	math INT,-- 数学
	english INT -- 英语
	
);
DESC student;
INSERT INTO student ( id, NAME, age, sex, address, math, english )
VALUES
	( 1, '马云', 55, '男', ' 杭州', 66, 78 ),
	( 2, '马化腾', 45, '女', '深圳', 98, 87 ),
	( 3, '马景涛', 55, '男', '香港', 56, 77 ),
	( 4, '柳岩 ', 20, '女', '湖南', 76, 65 ),
	( 5, '柳青', 20, '男', '湖南', 86, NULL ),
	( 6, '刘德华', 57, '男', '香港 ', 99, 99 ),
	( 7, '马德', 22, '女', '香港', 99, 99 ),
	( 8, '德玛西亚', 18, '男', '南京', 56, 65 );
SHOW TABLE student;
SELECT * FROM student;
	
-- 查询姓名和年龄
SELECT name,age FROM student;

-- 取出重复的结果集
SELECT DISTINCT address FROM student;

UPDATE student set address = '杭州' WHERE id = 1;

SELECT name,address FROM student;

-- 计算 math 和 english 分数之和

SELECT name, math, english, math+ english FROM student;
-- 如果有NULL 参与的运算，计算结果为null

SELECT name, math, english, math+ IFNULL(english,0) FROM student;

-- 起别名
SELECT name, math, english, math+ IFNULL(english,0) AS 总分 FROM student;
SELECT name, math 数学, english 英语, math+ IFNULL(english,0) 总分 FROM student;

SELECT * FROM student;

-- 查询年龄大于20岁
SELECT * FROM student WHERE age > 20;
SELECT * FROM student WHERE age >= 20;

-- 查询年龄为20的人
SELECT * FROM student WHERE age = 20;

-- 查询年龄不为20的人
SELECT * FROM student WHERE age <> 20;

-- 查询年龄大于等于20，小于等于30
SELECT * FROM student WHERE age >= 20 AND age <= 30;
SELECT * FROM student WHERE age BETWEEN 20 AND 30;

-- 查询22岁的人
SELECT * FROM student WHERE age = 22 OR age = 18 OR age = 25;
SELECT * FROM student WHERE age IN (22,18,25);

-- 查询英语成绩为null
SELECT * FROM student WHERE english IS NULL;

-- 查询英语成绩不为null
SELECT * FROM student WHERE english IS NOT NULL;

-- 查询姓马的有哪些？
SELECT * FROM student WHERE NAME LIKE '马%';
-- 查询第二个字为化的人
SELECT * FROM student WHERE NAME LIKE '_化%';
-- 查询姓名是三个字的人
SELECT * FROM student WHERE NAME LIKE '___';
-- 查询姓名中包含马的人
SELECT * FROM student WHERE NAME LIKE '%马%';
-- 查询姓名中包含德的人
SELECT * FROM student WHERE NAME LIKE '%德%';



SELECT * FROM student ORDER BY math ASC;
SELECT * FROM student ORDER BY math DESC;

-- 按照数学成绩排名，若数学成绩一样，则按照英语成绩排名
SELECT * FROM student ORDER BY math ASC, english ASC;



SELECT COUNT(name) FROM student;

SELECT COUNT(english) FROM student; -- 排除null

SELECT COUNT(IFNULL(english,0)) FROM student;

SELECT COUNT(*) FROM student;

SELECT MAX(math) FROM student;

-- 按照性别分组，分别查询男女平均分人数
SELECT sex, AVG(math),COUNT(id) FROM student GROUP BY sex;

-- 按照性别分组，分别查询男女平均分人数,分数低于70分的不参与分组
SELECT sex, AVG(math),COUNT(id) FROM student WHERE math > 70 GROUP BY sex;

-- 按照性别分组，分别查询男女平均分人数,分数低于70分的不参与分组,分组之后人数大于2人
SELECT sex, AVG(math),COUNT(id) FROM student WHERE math > 70 GROUP BY sex HAVING COUNT(id) > 2;
SELECT sex, AVG(math),COUNT(id) 人数 FROM student WHERE math > 70 GROUP BY sex HAVING 人数 > 2;



-- 每页三条记录
SELECT * FROM student LIMIT 0,3; -- 第1页
SELECT * FROM student LIMIT 3,3; -- 第2页

-- 公式：开始的索引 = (当前的页码 - 1) * 每页显示的条数