package com.mongo.dao;

import com.mongo.model.Info;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
public interface DemoInfoRepository extends MongoRepository<Info, String> {
    Info findByName(String name);
}
