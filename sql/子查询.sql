USE db2;

-- 查询工资最高的员工
-- 1. 查询最高的工资是多少 9000
SELECT MAX(salary) FROM emp;

-- 查询员工信息，并且工资等于9000
SELECT * FROM emp WHERE emp.salary = 9000;

-- 一条sql完成操作
SELECT * FROM emp WHERE emp.salary =(SELECT MAX(salary) FROM emp);


-- 查询员工工资小于平均工资的人

SELECT * FROM emp WHERE emp.salary < (SELECT AVG(emp.salary) FROM emp);

-- 查询财务部的所有员工信息
SELECT * FROM emp WHERE emp.dept_id IN (SELECT id FROM dept WHERE dept.`NAME` = '财务部');


-- 查询员工入职日期是2011-11-11日之后的员工信息和部门信息
SELECT * FROM dept t1,(SELECT * FROM emp WHERE emp.join_date > '2011-11-11')  t2 WHERE t1.id = t2.dept_id;
