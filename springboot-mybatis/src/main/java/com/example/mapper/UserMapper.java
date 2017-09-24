package com.example.mapper;

import org.apache.ibatis.annotations.*;
import com.example.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/2 0002.
 */
@Mapper
public interface UserMapper {
      @Results({
              @Result(property = "name", column = "f_name"),
              @Result(property = "age", column = "f_age"),
              @Result(property = "email1", column = "f_email")
       })
        @Select("SELECT f_name, f_age, f_email FROM t_user")
        List<User> findAll();

        @Insert("INSERT INTO t_user(f_name, f_age) VALUES(#{name}, #{age})")
        int insert(@Param("name") String name, @Param("age") Integer age);

        @Update("UPDATE t_user SET f_age=#{age} WHERE f_name=#{name}")
        void update(User user);

         @Delete("DELETE FROM t_user WHERE id =#{id}")
 	     void delete(Long id);

         @Insert("INSERT INTO t_user(f_name, f_age) VALUES(#{name}, #{age})")
         int insertByUser(User user);

          @Insert("INSERT INTO t_user(f_name, f_age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
          int insertByMap(Map<String, Object> map);
}
