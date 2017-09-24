package com.mongo.controller;

import com.mongo.dao.DemoInfoRepository;
import com.mongo.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.InfoProperties;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
@RestController
public class InfoController {
    @Autowired
    private DemoInfoRepository demoInfoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;



    @RequestMapping("/save")
    public String save(){
        Info info = new Info();
        info.setName("tom");
        info.setAge(20);
        demoInfoRepository.save(info);
        info = new Info();
        info.setAge(18);
        info.setName("jerry");
        demoInfoRepository.save(info);
        return "ok";
    }

    @RequestMapping("find2")
    public List<Info> find2(){
        Info info = new Info();
        info.setName("hailun");
        info.setAge(20);
        mongoTemplate.insert(info);
        return mongoTemplate.findAll(Info.class);
    }

    @RequestMapping("find")
    public List<Info> find(){
        return  demoInfoRepository.findAll();
    }

    @RequestMapping("findByName")
    public  Info findByName(){
        return  demoInfoRepository.findByName("tom");
    }

}
