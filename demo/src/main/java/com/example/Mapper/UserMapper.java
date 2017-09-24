package com.example.Mapper;

import com.example.Domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;


/**
 * Created by Administrator on 2017/5/2 0002.
 */

@Mapper
public interface UserMapper {
    User findUserById(Integer id);
}