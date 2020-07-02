package com.dsf.mp.start.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dsf.mp.start.StartApp;
import com.dsf.mp.start.entity.User;
import com.dsf.mp.start.vo.UserVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApp.class)
public class Mp04SelectTest {
    @Autowired
    UserMapper0401 userMapper;

    @Autowired
    UserMapper0402 userMapper0402;

    /**
     * 单表的查询, 自定义sql(注解)
     */
    @Test
    public void selectMyCustomer0101() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.likeRight("name", "王")
            .and(q -> q.lt("age", 40).or().isNotNull("email"));
        List<User> list = userMapper.selectAll040101(query);
        list.forEach(System.out::println);
    }

    /**
     * 单表的查询, 自定义sql(xml)
     */
    @Test
    public void selectMyCustomer0102() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.likeRight("name", "王")
                .and(q -> q.lt("age", 40).or().isNotNull("email"));
        List<User> list = userMapper.selectAll040102(query);
        list.forEach(System.out::println);
    }

    /**
     * 单表的分页查询, 是用自带方法实现
     */
    @Test
    public void selectMyCustomer0201() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.ge("age", 26);

        Page<User> userPage = new Page<>(1, 2);
        // 第三个参数为false, 表示不查询总的记录数, 默认是true的
        userPage = new Page<>(1, 2, false);

        IPage<User> userPageResult = userMapper.selectPage(userPage, query);
        System.out.println("selectPage总页数" + userPageResult.getPages());
        System.out.println("selectPage总记录数" + userPageResult.getTotal());
        userPageResult.getRecords().forEach(System.out::println);

        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(userPage, query);
        System.out.println("selectMapsPage总页数" + mapIPage.getPages());
        System.out.println("selectMapsPage总记录数" + mapIPage.getTotal());
        mapIPage.getRecords().forEach(System.out::println);
        mapIPage.getRecords().forEach(map -> {
            System.out.println("create_time:" + map.get("create_time"));
            System.out.println("name:" + map.get("name"));
            System.out.println("id:" + map.get("id"));
            System.out.println("age:" + map.get("age"));
            System.out.println("manager_id:" + map.get("manager_id"));
            System.out.println("email:" + map.get("email"));
        });
    }

    /**
     * 单表的分页查询, 是用自定义xml实现
     */
    @Test
    public void selectMyCustomer0202() {
        QueryWrapper<User> query = new QueryWrapper<>();
        query.ge("age", 26);

        Page<User> userPage = new Page<>(1, 2);

        IPage<User> userIPage = userMapper0402.selectUserPage0402(userPage, query);
        System.out.println("selectPage总页数" + userIPage.getPages());
        System.out.println("selectPage总记录数" + userIPage.getTotal());
        userIPage.getRecords().forEach(System.out::println);
    }

    /**
     * 自定义多表联查并分页
     *
     * ps: 本人认为，多表联查使用exists比使用join效率较高、通用性更强、sql语句更简单，
     * 虽然只查出单个主表的数据，但是业务层中可以根据需要，通过主表id再次查询出关联子表的对应页数据
     * 当然也可以在web端做异步访问查询，以防止一次查询出数据太多、耗时过长降低用户体验
     */
    @Test
    public void selectMyCustomer0202Self() {
        UserVo userVo = new UserVo();
        userVo.setAgeStart(25);
        userVo.setHobby("学");

        Page<User> page = new Page<> (1,2);
        userMapper0402.selectUserPage0402Self(page,userVo);

        System.out.println("总页数："+page.getPages());
        System.out.println("总记录数："+page.getTotal());
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
    }


}