-- 查找入职员工时间排名倒数第三的员工所有信息
CREATE TABLE `employees` (
  `emp_no`     INT(11)     NOT NULL,
  `birth_date` DATE        NOT NULL,
  `first_name` VARCHAR(14) NOT NULL,
  `last_name`  VARCHAR(16) NOT NULL,
  `gender`     CHAR(1)     NOT NULL,
  `hire_date`  DATE        NOT NULL,
  PRIMARY KEY (`emp_no`)
);

# 解答
SELECT *
FROM employees
ORDER BY hire_date DESC
LIMIT 2, 1;