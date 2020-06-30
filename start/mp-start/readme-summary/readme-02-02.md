# 完成了?
完成 BaseMapper插入 的例子, 直接运行 com.dsf.mp.start.dao.Mp0202InsertTest.insert 就能看到这个例子的效果.

# 想说明的点?
1.常用注解
    1. 代码中是没有设置id的, 但数据库中id是有的, 默认是雪花算法生成的id;==>@TableId, 指定该字段是主键, 会默认用雪花算法来生成值填充.
    2. 代码中是设置manageId, 但数据库中是manage_id, 默认是驼峰的;==> @TableField
    3. 代码中是User对象, 但数据库中是user表, 默认是这样转换的;==>如果数据库中改为mp_user表 或者 我用了 User0202 这个类, 就会报错;==> @TableName

# 采坑点?
我试了下面这种写法, 不行, @TableId会生成雪花id, @TableField会修改映射的名字, 但是两个合在一起用不行!!
## 步骤一
```
    @TableId()
    @TableField("id")
    private Long userId;

报错如下, 不管这两个注解谁先谁后:
DEBUG==>  Preparing: INSERT INTO user ( user_id, name, age, manager_id, create_time ) VALUES ( ?, ?, ?, ?, ? ) 
DEBUG==> Parameters: 1277999004418912258(Long), 刘明强(String), 31(Integer), 1088248166370832385(Long), 2020-07-01T00:14:41.013(LocalDateTime)
org.springframework.jdbc.BadSqlGrammarException: 
### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column 'user_id' in 'field list'
```
## 步骤二
```
    @TableId()
    private Long userId;

报错如下:
DEBUG==>  Preparing: INSERT INTO user ( user_id, name, age, manager_id, create_time ) VALUES ( ?, ?, ?, ?, ? ) 
DEBUG==> Parameters: 1277998181123125250(Long), 刘明强(String), 31(Integer), 1088248166370832385(Long), 2020-07-01T00:11:24.685(LocalDateTime)
org.springframework.jdbc.BadSqlGrammarException: 
### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column 'user_id' in 'field list'
```
## 步骤三
```
    @TableField("id")
    private Long userId;
报错如下:
DEBUG==>  Preparing: INSERT INTO user ( name, age, manager_id, create_time ) VALUES ( ?, ?, ?, ? ) 
DEBUG==> Parameters: 刘明强(String), 31(Integer), 1088248166370832385(Long), 2020-07-01T00:13:30.192(LocalDateTime)
org.springframework.dao.DataIntegrityViolationException: 
### Error updating database.  Cause: java.sql.SQLException: Field 'id' doesn't have a default value
```
## 步骤四
使用这种方式完全没问题
```
    @TableId("id")
```