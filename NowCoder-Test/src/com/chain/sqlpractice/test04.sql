#准备
DROP DATABASE IF EXISTS d_nowcoder;
CREATE DATABASE d_nowcoder;
USE d_nowcoder;

#题目
# 查找所有已经分配部门的员工的last_name和first_name
CREATE TABLE `dept_emp` (
  `emp_no`    INT(11) NOT NULL,
  `dept_no`   CHAR(4) NOT NULL,
  `from_date` DATE    NOT NULL,
  `to_date`   DATE    NOT NULL,
  PRIMARY KEY (`emp_no`, `dept_no`)
);
CREATE TABLE `employees` (
  `emp_no`     INT(11)     NOT NULL,
  `birth_date` DATE        NOT NULL,
  `first_name` VARCHAR(14) NOT NULL,
  `last_name`  VARCHAR(16) NOT NULL,
  `gender`     CHAR(1)     NOT NULL,
  `hire_date`  DATE        NOT NULL,
  PRIMARY KEY (`emp_no`)
);

#解答
SELECT
  e.last_name,
  e.first_name,
  d.dept_no
FROM employees e INNER JOIN dept_emp d
    ON d.emp_no = e.emp_no;
