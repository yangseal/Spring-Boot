package com.mongo.dao;

import com.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
public interface UserRepository extends MongoRepository<User, Long> {
    User findByUsername(String username);
}
