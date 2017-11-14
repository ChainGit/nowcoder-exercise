# 题目01
# 查找最晚入职员工的所有信息
CREATE TABLE `employees` (
  `emp_no`     INT(11)     NOT NULL,
  `birth_date` DATE        NOT NULL,
  `first_name` VARCHAR(14) NOT NULL,
  `last_name`  VARCHAR(16) NOT NULL,
  `gender`     CHAR(1)     NOT NULL,
  `hire_date`  DATE        NOT NULL,
  PRIMARY KEY (`emp_no`)
);

# 解答1
SELECT *
FROM employees
ORDER BY hire_date DESC
LIMIT 1;
