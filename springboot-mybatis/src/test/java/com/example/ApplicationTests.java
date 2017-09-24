package com.example;

import com.example.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.model.*;

/**
 * Created by Administrator on 2017/5/2 0002.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testUserMapper() throws Exception {
        userMapper.insert("AAA", 20);
    }
}
