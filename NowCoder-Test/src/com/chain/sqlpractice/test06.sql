#准备
DROP DATABASE IF EXISTS d_nowcoder;
CREATE DATABASE d_nowcoder;
USE d_nowcoder;

#题目
# 查找所有员工入职时候的薪水情况，给出emp_no以及salary， 并按照emp_no进行逆序
CREATE TABLE `employees` (
  `emp_no`     INT(11)     NOT NULL,
  `birth_date` DATE        NOT NULL,
  `first_name` VARCHAR(14) NOT NULL,
  `last_name`  VARCHAR(16) NOT NULL,
  `gender`     CHAR(1)     NOT NULL,
  `hire_date`  DATE        NOT NULL,
  PRIMARY KEY (`emp_no`)
);
CREATE TABLE `salaries` (
  `emp_no`    INT(11) NOT NULL,
  `salary`    INT(11) NOT NULL,
  `from_date` DATE    NOT NULL,
  `to_date`   DATE    NOT NULL,
  PRIMARY KEY (`emp_no`, `from_date`)
);

#解答
SELECT
  e.emp_no,
  s.salary
FROM employees e LEFT JOIN salaries s
    ON e.emp_no = s.emp_no
       AND e.hire_date = s.from_date
ORDER BY e.emp_no DESC;