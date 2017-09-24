package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
@Controller
public class HelloController {

    @RequestMapping(value="/")
    public String index(){
        return "index";
    }
    @RequestMapping(value="/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
