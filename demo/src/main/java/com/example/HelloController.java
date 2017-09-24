package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/2 0002.
 */
@RestController
public class HelloController {
   @RequestMapping("/test")
    public  String test(){
        return "hello";
    }
}
