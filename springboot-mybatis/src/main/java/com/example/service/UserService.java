package com.example.service;

import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.*;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2 0002.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> getUsersList()
    {
       List<User>userList =  userMapper.findAll();
       if(userList!= null){
           return userList;
       }
       return  null;
    }
}
