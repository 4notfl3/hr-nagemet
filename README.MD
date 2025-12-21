## 人事管理系统

## V1.4

员工管理基本功能已实现

部门管理基本功能已实现

添加了日志记录功能 ：[项目运行日志](logs/logs.log)

接口规范化：统一返回类


#### 数据库序列（Sequence）不同步问题：
SQL自动检测deptno的最大值或者emono的最大值，使用

重置部门表序列:
`SELECT setval('dept_id_seq', (SELECT COALESCE(MAX(deptno), 1) FROM dept));`

重置员工表序列:
`SELECT setval('emp_id_seq', (SELECT COALESCE(MAX(empno), 1) FROM emp));`
