完成了?
完成一个小例子, 直接运行 com.dsf.mp.start.dao.Mp0201InsertTest.insert 就能看到这个例子的效果.

想说明的点?
1.配置日志的 level 和 pattern
2.BaseMapper 其他方法(insert)的使用
3.注意生成的sql中, email 字段是没有生成的, 因为默认策略就是null的情况下, 不会生成.
```
DEBUG==>  Preparing: INSERT INTO user ( id, name, age, manager_id, create_time ) VALUES ( ?, ?, ?, ?, ? ) 
DEBUG==> Parameters: 1277989641583083522(Long), 刘明强(String), 31(Integer), 1088248166370832385(Long), 2020-06-30T23:37:28.694(LocalDateTime)
DEBUG<==    Updates: 1
```

采坑点?
如果 application.yml 里的 logging.pattern 写错了, 写成
```$xslt
console: %p%m%n
``` 
则会报下面的错误:
```
Caused by: java.lang.IllegalStateException: Failed to load property source from location 'classpath:/application.yml'
```

但如果 logging.level 路径写错了, 写成 com.dsf.mp.dao, 则没有错误, 只是不生效(不会打印出sql语句).