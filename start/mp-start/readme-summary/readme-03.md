# 完成了?
## 03-01
完成 BaseMapper查询 的例子, 直接运行 com.dsf.mp.start.dao.Mp03SelectTest.selectById/selectBatchIds/selectByMap 就能看到这个例子的效果.

## 03-02
完成 BaseMapper查询 的其他例子(基于 selectList), 直接运行 com.dsf.mp.start.dao.Mp03SelectTest.selectList_like_lt/selectList_between_isNotNull/selectList_or_orderByDesc_orderByAsc 就能看到这个例子的效果.
对应 查询需求例题.docx 的 1,2,3 三个查询需求

## 03-03
完成 BaseMapper查询 的其他例子(基于 selectList), 直接运行 com.dsf.mp.start.dao.Mp03SelectTest.selectList_apply_inSql/selectList_and_lambda/selectList_or_lambda 就能看到这个例子的效果.
对应 查询需求例题.docx 的 4,5,6 三个查询需求

## 03-04
完成 BaseMapper查询 的其他例子(基于 selectList), 直接运行 com.dsf.mp.start.dao.Mp03SelectTest.selectList_nested/selectList_in/selectList_last 就能看到这个例子的效果.
对应 查询需求例题.docx 的 7,8,9 三个查询需求




# 想说明的点?
## 自我观察
```
注意数量不匹配时会有异常 selectOne
查询数量 selectCount
selectMaps, selectObjs(是只有一列吗), selectMaps2(??)


lambda lambdaQueryWrapper1, lambdaQueryWrapper2, lambdaQueryChainWrapper


查询指定列 , selectList_select_include, selectList_select_exclude
子查询 selectList_apply_inSql
各种查询条件 selectList_between_isNotNull, selectList_like_lt, selectList_in, selectList_allEq?
selectList_condition
selectList_and_lambda, selectList_or_lambda
selectList_entity
selectList_nested
selectList_or_orderByDesc_orderByAsc
```
## 03-02
BaseMapper 的其他查询方法, 都会传入一个条件构造器( Wrapper 及其子类, 知道的有 AbstractWrapper, 常用的有 QueryWrapper 和 LambdaQueryWrapper )
* 未分页的方法
```
    T selectOne(@Param("ew") Wrapper<T> queryWrapper);
    Integer selectCount(@Param("ew") Wrapper<T> queryWrapper);
    List<T> selectList(@Param("ew") Wrapper<T> queryWrapper);
    List<Map<String, Object>> selectMaps(@Param("ew") Wrapper<T> queryWrapper);
    List<Object> selectObjs(@Param("ew") Wrapper<T> queryWrapper);
```

* 分页的方法
```
    IPage<T> selectPage(IPage<T> page, @Param("ew") Wrapper<T> queryWrapper);
    IPage<Map<String, Object>> selectMapsPage(IPage<T> page, @Param("ew") Wrapper<T> queryWrapper);
```

## 03-03看完后的自我总结
默认 Wrapper 里的各个方法(like, lt, between, isNotNull, in, apply, inSql), 默认都是用and进行连接的.
如果想使用or, 就得用or()方法
想使用大括号, 那就放在and()或or()或 nested()这个方法的参数中. (nested()应该是用在where条件中最开始就是大括号的情况)

# 采坑点?