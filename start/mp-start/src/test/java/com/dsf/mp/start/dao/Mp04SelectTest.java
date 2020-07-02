package com.dsf.mp.start.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dsf.mp.start.StartApp;
import com.dsf.mp.start.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApp.class)
public class Mp04SelectTest {
    @Autowired
    UserMapper0401 userMapper;

    @Test
    public void selectMyCustomer0101() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.likeRight("name", "王")
            .and(q -> q.lt("age", 40).or().isNotNull("email"));
        List<User> list = userMapper.selectAll040101(query);
        list.forEach(System.out::println);
    }

    @Test
    public void selectMyCustomer0102() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.likeRight("name", "王")
                .and(q -> q.lt("age", 40).or().isNotNull("email"));
        List<User> list = userMapper.selectAll040102(query);
        list.forEach(System.out::println);
    }


}