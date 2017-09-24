package com.example.Controller;

import com.example.Dao.UserDao;
import com.example.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/findUserById")
    public User findUserById(@RequestParam(value="id") Integer id) {
        User user = null;
        try {
            user = userDao.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}