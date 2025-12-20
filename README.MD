## 人事管理系统

## V1.2

员工管理基本功能已实现

部门管理基本功能已实现


#### 数据库序列（Sequence）不同步问题：
SQL自动检测deptno的最大值或者emono的最大值，使用
`SELECT setval('dept_id_seq', (SELECT MAX(deptno) FROM dept));`
后会重置序列。
