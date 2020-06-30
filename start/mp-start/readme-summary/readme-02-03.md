# 完成了?
基于 BaseMapper插入 的例子, 讲排除非表字段的三种方式(其实还是讲解 @TabelFeild 这个注解), 直接运行 com.dsf.mp.start.dao.Mp0203InsertTest.insert 就能看到这个例子的效果.

# 想说明的点?
## 步骤一: 增加 remark 字段后, 啥都不干, 会报下面的错
```
DEBUG==>  Preparing: INSERT INTO user ( id, name, age, manager_id, create_time, remark ) VALUES ( ?, ?, ?, ?, ?, ? ) 
DEBUG==> Parameters: 1278004343658795009(Long), 刘明强(String), 31(Integer), 1088248166370832385(Long), 2020-07-01T00:35:53.987(LocalDateTime), 我是一个备注!!(String)

org.springframework.jdbc.BadSqlGrammarException: 
### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column 'remark' in 'field list'
### The error may exist in com/dsf/mp/start/dao/UserMapper0203.java (best guess)
```
## 步骤二: 排除remark字段
1.使用 transaction 标识字段, 但是会影响其他序列化的场景;
2.使用 static, 将字段弄成静态变量, 但可能实际静态不满足业务场景;
3.使用 @TabelFeild

# 采坑点?
lombok不会为静态变量生成get/set等方法!