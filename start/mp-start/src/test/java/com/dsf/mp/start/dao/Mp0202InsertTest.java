package com.dsf.mp.start.dao;

import com.dsf.mp.start.StartApp;
import com.dsf.mp.start.entity.User0202;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest(classes= StartApp.class)
public class Mp0202InsertTest {
    @Autowired
    UserMapper0202 userMapper;

    @Test
    public void insert(){
        User0202 user = new User0202();
        user.setRealName("刘明强");
        user.setAge(31);
        user.setManagerId(1088248166370832385L);
        user.setCreateTime(LocalDateTime.now());
        int row = userMapper.insert(user);
        System.out.println("影响记录数："+row);
        System.out.println("自增id: "+user.getUserId());
    }

}