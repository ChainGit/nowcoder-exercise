#准备
DROP DATABASE IF EXISTS d_nowcoder;
CREATE DATABASE d_nowcoder;
USE d_nowcoder;

#题目
# 查找薪水涨幅超过15次的员工号emp_no以及其对应的涨幅次数t
CREATE TABLE `salaries` (
  `emp_no`    INT(11) NOT NULL,
  `salary`    INT(11) NOT NULL,
  `from_date` DATE    NOT NULL,
  `to_date`   DATE    NOT NULL,
  PRIMARY KEY (`emp_no`, `from_date`)
);

#解答
# 分组后每组只显示一行记录，一般配合sum、count、min、max等统计函数。
# 如果只是按分组顺序列出清单，没必要使用group by，直接order by group就可以了。
# WHERE语句在GROUP BY语句之前；SQL会在分组之前计算WHERE语句。
# HAVING语句在GROUP BY语句之后；SQL会在分组之后计算HAVING语句。
SELECT
  s.emp_no,
  count(*) t
FROM salaries s
GROUP BY s.emp_no
HAVING t > 15;