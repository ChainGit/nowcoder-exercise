#准备
DROP DATABASE IF EXISTS d_nowcoder;
CREATE DATABASE d_nowcoder;
USE d_nowcoder;

#题目
-- 查找各个部门当前(to_date='9999-01-01')领导当前薪水详情以及其对应部门编号dept_no
CREATE TABLE `dept_manager` (
  `dept_no`   CHAR(4) NOT NULL,
  `emp_no`    INT(11) NOT NULL,
  `from_date` DATE    NOT NULL,
  `to_date`   DATE    NOT NULL,
  PRIMARY KEY (`emp_no`, `dept_no`)
);
CREATE TABLE `salaries` (
  `emp_no`    INT(11) NOT NULL,
  `salary`    INT(11) NOT NULL,
  `from_date` DATE    NOT NULL,
  `to_date`   DATE    NOT NULL,
  PRIMARY KEY (`emp_no`, `from_date`)
);

# 解答
SELECT
  s.emp_no,
  s.salary,
  s.from_date,
  s.to_date,
  d.dept_no
FROM salaries s LEFT JOIN dept_manager d
    ON d.emp_no = s.emp_no
WHERE s.to_date = '9999-01-01' AND d.to_date = s.to_date;