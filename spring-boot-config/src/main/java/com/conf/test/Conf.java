package com.conf.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
@RestController
public class Conf {
    //要开启@EnableConfigurationProperties({Enviroment.class})注解
    @Autowired
    private  Enviroment enviroment;
    @Autowired
    private  EmailProp emailProp;
    @RequestMapping("/enviroment")
    public  String enviroment(){
        return enviroment.toString();
    }
    @RequestMapping("/emailProp")
    public  String emailProp(){
        return emailProp.toString();
    }
}
