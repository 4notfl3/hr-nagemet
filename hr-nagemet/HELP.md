# 记忆本
### 1：实体类
单实体类更适合数据的修改，单独查询可以将多表的数据写到同一个实体类中。

### 2：接口
#### Dao层
@Insert：
把 Java 方法转换成一条 SQL 插入语句， 类似
`@Insert("INSERT INTO emp (ename, status, job, mgr, hiredate, sal, comm, deptno) " +
"VALUES (#{ename}, #{status}, #{job}, #{mgr}, #{hiredate}, #{sal}, #{comm}, #{deptno})")`

数据插入成功后，PostgreSQl自动生成empon员工编号，@Optins将empno传回Employee的对象中
`@Options(useGeneratedKeys = true, keyProperty = "empno")`

#### Service 层
 要写一个Service实体类 和 Service接口,放在一个包下最好

 Service接口：

 获取Deartmen类中的对象
`List<Departmen> getAllDepartmen();`

 根据 Integer depton 查询dname
`Departmen getDepartmenById (Integer depton);`


#### Controller层
员工入职
```
@Override
public Employee recruit(String emp) {
//填写数据
        //获取当前时间
        emp.setHiredate(java.time.LocalDate.now());

        //将空白表的数据传给employeeDao，然后employeeDao写入数据库
        employeeDao.insertEmp(emp);
        //返回emp中的数据
        return emp;
    }