package com.example.controller;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.model.*;

import java.util.List;

/**
 * Created by Administrator on 2017/5/2 0002.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUsersList")
    public String getUsersList(Model model)
    {
        List<User> userList = userService.getUsersList();
        model.addAttribute("userList", userList);
        return  "user";
    }
}
