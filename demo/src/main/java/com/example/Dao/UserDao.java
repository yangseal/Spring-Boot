package com.example.Dao;

import com.example.Domain.User;
import com.example.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    @Autowired
    private UserMapper userMapper;
    public User findUserById(Integer id) throws Exception {
        return userMapper.findUserById(id);
    }
}