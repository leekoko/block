package com.leekoko.block.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.leekoko.block.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(6, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testWrapperSelect() {
        System.out.println(("----- selectAll method test ------"));
        User user = new User();
//        user.setId(1l);
        List<User> userList = userMapper.selectList(Wrappers.lambdaQuery(user));
        userList.forEach(System.out::println);
    }

    @Test
    @Transactional
    public void transactionTest(){
        User user = new User();
//        user.setId(6L);
//        user.setName("111");
        userMapper.insert(user);
        insertTwo();
    }

    @Transactional
    public void insertTwo() {
        User user = new User();
//        user.setId(7L);
//        user.setName("222");
        userMapper.insert(user);
    }
}