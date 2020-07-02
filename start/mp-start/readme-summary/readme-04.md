# 完成了?
## 04-01
完成 BaseMapper查询 的2个例子(使用条件构造器的自定义sql, 1个写在注解中, 一个写在xml中), 直接运行 com.dsf.mp.start.dao.Mp04SelectTest.selectMyCustomer0101/selectMyCustomer0102 就能看到这个例子的效果.

## 04-02
完成 BaseMapper查询 的2个例子(2个分页查询+1个多表分页查询), 直接运行 com.dsf.mp.start.dao.Mp04SelectTest.selectMyCustomer0201/selectMyCustomer0202 就能看到这个例子的效果.



# 小结
## selectMyCustomer0101
注意写法

## selectMyCustomer0102
需要修改的点:
1. dao中先写方法
2. xml中写对应的sql
3. application.yml中mybatis-plus.mapper-locations

## 04-02
最开始, 提到了mybatis的分页(rowBounds分页, 不是物理分页, 是逻辑分页或者叫内存分页), Mybatis-plus的分页插件(物理分页);

配置mp分页插件的方法->注入一个PaginationInterceptor类, 详见MybatisPlusConfig.java

BaseMapper 中的 selectPage 和 selectMapsPage, 主要的一个区别就是getRecords方法返回的时候, 一个是实体的list, 一个是map的list.

## selectMyCustomer0201
完成了 selectPage 和 selectMapsPage 这2个分页查询的方法(单表的分页查询, 是用自带方法实现)


## selectMyCustomer0202
完成了 单表的分页查询, 是用自定义xml实现



# 采坑点?
# Failed to load ApplicationContext
```
java.lang.IllegalStateException: Failed to load ApplicationContext

	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:123)
	at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:190)
	at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:132)
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:244)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:227)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:289)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:291)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:246)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:97)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:190)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:230)
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:58)
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'userMapper' defined in file [D:\git\mybatisPlus\start\mp-start\target\classes\com\dsf\mp\start\dao\UserMapper.class]: Unsatisfied dependency expressed through bean property 'sqlSessionFactory'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'mybatis-plus-com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties': Could not bind properties to 'MybatisPlusProperties' : prefix=mybatis-plus, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'mybatis-plus.mapper-locations' to java.lang.String[]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireByType(AbstractAutowireCapableBeanFactory.java:1526)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1406)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:594)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:517)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:323)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:321)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:860)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:878)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:550)
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:747)
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315)
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:125)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
	... 24 more
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration': Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'mybatis-plus-com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties': Could not bind properties to 'MybatisPlusProperties' : prefix=mybatis-plus, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'mybatis-plus.mapper-locations' to java.lang.String[]
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:798)
	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:228)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1358)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1204)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:557)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:517)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:323)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:321)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:409)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateUsingFactoryMethod(AbstractAutowireCapableBeanFactory.java:1338)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1177)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:557)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:517)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:323)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:321)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:276)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1287)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1207)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireByType(AbstractAutowireCapableBeanFactory.java:1511)
	... 40 more
Caused by: org.springframework.boot.context.properties.ConfigurationPropertiesBindException: Error creating bean with name 'mybatis-plus-com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties': Could not bind properties to 'MybatisPlusProperties' : prefix=mybatis-plus, ignoreInvalidFields=false, ignoreUnknownFields=true; nested exception is org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'mybatis-plus.mapper-locations' to java.lang.String[]
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.bind(ConfigurationPropertiesBindingPostProcessor.java:110)
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.postProcessBeforeInitialization(ConfigurationPropertiesBindingPostProcessor.java:96)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:416)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1788)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:595)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:517)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:323)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:321)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:276)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1287)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1207)
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:885)
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:789)
	... 62 more
Caused by: org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'mybatis-plus.mapper-locations' to java.lang.String[]
	at org.springframework.boot.context.properties.bind.Binder.handleBindError(Binder.java:364)
	at org.springframework.boot.context.properties.bind.Binder.bind(Binder.java:324)
	at org.springframework.boot.context.properties.bind.Binder.lambda$bindDataObject$4(Binder.java:448)
	at org.springframework.boot.context.properties.bind.JavaBeanBinder.bind(JavaBeanBinder.java:90)
	at org.springframework.boot.context.properties.bind.JavaBeanBinder.bind(JavaBeanBinder.java:79)
	at org.springframework.boot.context.properties.bind.JavaBeanBinder.bind(JavaBeanBinder.java:56)
	at org.springframework.boot.context.properties.bind.Binder.lambda$bindDataObject$5(Binder.java:452)
	at org.springframework.boot.context.properties.bind.Binder$Context.withIncreasedDepth(Binder.java:572)
	at org.springframework.boot.context.properties.bind.Binder$Context.withDataObject(Binder.java:558)
	at org.springframework.boot.context.properties.bind.Binder$Context.access$400(Binder.java:513)
	at org.springframework.boot.context.properties.bind.Binder.bindDataObject(Binder.java:450)
	at org.springframework.boot.context.properties.bind.Binder.bindObject(Binder.java:391)
	at org.springframework.boot.context.properties.bind.Binder.bind(Binder.java:320)
	at org.springframework.boot.context.properties.bind.Binder.bind(Binder.java:308)
	at org.springframework.boot.context.properties.bind.Binder.bind(Binder.java:238)
	at org.springframework.boot.context.properties.bind.Binder.bind(Binder.java:225)
	at org.springframework.boot.context.properties.ConfigurationPropertiesBinder.bind(ConfigurationPropertiesBinder.java:89)
	at org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.bind(ConfigurationPropertiesBindingPostProcessor.java:107)
	... 76 more
Caused by: org.springframework.boot.context.properties.bind.UnboundConfigurationPropertiesException: The elements [mybatis-plus.mapper-locations[0].classpath] were left unbound.
	at org.springframework.boot.context.properties.bind.IndexedElementsBinder.assertNoUnboundChildren(IndexedElementsBinder.java:136)
	at org.springframework.boot.context.properties.bind.IndexedElementsBinder.bindIndexed(IndexedElementsBinder.java:113)
	at org.springframework.boot.context.properties.bind.IndexedElementsBinder.bindIndexed(IndexedElementsBinder.java:86)
	at org.springframework.boot.context.properties.bind.IndexedElementsBinder.bindIndexed(IndexedElementsBinder.java:71)
	at org.springframework.boot.context.properties.bind.ArrayBinder.bindAggregate(ArrayBinder.java:46)
	at org.springframework.boot.context.properties.bind.AggregateBinder.bind(AggregateBinder.java:56)
	at org.springframework.boot.context.properties.bind.Binder.lambda$bindAggregate$3(Binder.java:415)
	at org.springframework.boot.context.properties.bind.Binder$Context.withIncreasedDepth(Binder.java:572)
	at org.springframework.boot.context.properties.bind.Binder$Context.access$100(Binder.java:513)
	at org.springframework.boot.context.properties.bind.Binder.bindAggregate(Binder.java:415)
	at org.springframework.boot.context.properties.bind.Binder.bindObject(Binder.java:376)
	at org.springframework.boot.context.properties.bind.Binder.bind(Binder.java:320)
	... 92 more
```

原因是: 这个配置中冒号后面不需要空格!!
```yaml
- classpath*:mapper*/*.xml
```

# Invalid bound statement (not found)
配置没配对, 就容易出现这个问题, 不过我改xml已经很谨慎了.
https://www.cnblogs.com/liaojie970/p/8034525.html
https://www.jianshu.com/p/800fe918cc7a
https://blog.csdn.net/weixin_42204641/article/details/81155726
