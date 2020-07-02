# 完成了?
## 04-01
完成 BaseMapper查询 的2个例子(使用条件构造器的自定义sql, 1个写在注解中, 一个写在xml中), 直接运行 com.dsf.mp.start.dao.Mp04SelectTest.selectMyCustomer0101/selectMyCustomer0102 就能看到这个例子的效果.

## 03-02


# 小结
## selectMyCustomer0101
注意写法

## selectMyCustomer0102
需要修改的点:
1. dao中先写方法
2. xml中写对应的sql
3. application.yml中mybatis-plus.mapper-locations


# 采坑点?
这个配置中冒号后面不需要空格!!
```yaml
- classpath*:mapper*/*.xml
```