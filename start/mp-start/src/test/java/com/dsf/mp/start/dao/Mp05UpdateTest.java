package com.dsf.mp.start.dao;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.update.impl.LambdaUpdateChainWrapper;
import com.dsf.mp.start.StartApp;
import com.dsf.mp.start.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApp.class)
public class Mp05UpdateTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void updateById() {
        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(25);
        user.setEmail("wtf"+System.currentTimeMillis()+"@baomidou.com");

        int rows = userMapper.updateById(user);
        System.out.println("受影响行数:" + rows);
    }

    @Test
    public void updateByWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "李艺伟").eq("age", 28);

        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(28);
        user.setEmail("lyw"+System.currentTimeMillis()+"@baomidou.com");

        int rows = userMapper.update(user, updateWrapper);
        System.out.println("受影响行数:" + rows);
    }

    /**
     * 从 updateByWrapper 拷贝过来, 区别只是多了个 whereUser
     */
    @Test
    public void updateByWrapper02() {
        User whereUser = new User();
        whereUser.setName("李艺伟");

        // 注意这里, 构造器里传的whereUser和后面updateWrapper设置的, 两个都会存在
        // 另外, whereUser 生成的 where 条件, 会看 User 里面的 TableField(condition=SQLCondition.LIKE)这种
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>(whereUser);
        updateWrapper.eq("name", "李艺伟").eq("age", 28);

        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(28);
        user.setEmail("lyw"+System.currentTimeMillis()+"@baomidou.com");

        int rows = userMapper.update(user, updateWrapper);
        System.out.println("受影响行数:" + rows);
    }


    /**
     * 从 updateByWrapper 拷贝过来,
     * 只更新指定字段(不去 new User 这个对象)
     */
    @Test
    public void updateTheColumnByWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "李艺伟")
                .eq("age", 28)
                .set("name", "李艺伟" + System.currentTimeMillis())
                .set("email", "lyw"+System.currentTimeMillis()+"@baomidou.com");

        int rows = userMapper.update(null, updateWrapper);
        System.out.println("受影响行数:" + rows);
    }

    /**
     * 从 updateByWrapper 拷贝过来,
     * 也有 Lambda 的 UpdateWrapper, 可以 防误写
     */
    @Test
    public void updateByLambdaUpdateWrapper() {
        LambdaUpdateWrapper<User> lambdaUpdate = Wrappers.<User>lambdaUpdate();
//        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
//        updateWrapper.eq("name", "李艺伟").eq("age", 28);
        // 注意: 仅仅是这里可以防误写这个区别
        lambdaUpdate.eq(User::getName, "李艺伟").eq(User::getAge, 28);

        User user = new User();
        user.setId(1088248166370832385L);
        user.setAge(28);
        user.setEmail("lyw"+System.currentTimeMillis()+"@baomidou.com");

        int rows = userMapper.update(user, lambdaUpdate);
        System.out.println("受影响行数:" + rows);
    }

    /**
     * 从 updateByLambdaUpdateWrapper 拷贝过来,
     * 也有 chain 的 Lambda Wrapper, 可以 防误写
     */
    @Test
    public void updateByLambdaUpdateChainWrapper() {
        boolean result = new LambdaUpdateChainWrapper<User>(userMapper)
                .eq(User::getName, "李艺伟")
                .eq(User::getAge, 28)
                .set(User::getName, "李艺伟" + System.currentTimeMillis())
                .set(User::getEmail, "lyw" + System.currentTimeMillis() + "@baomidou.com")
                .update();

        System.out.println("更新结果:" + result);
    }
}