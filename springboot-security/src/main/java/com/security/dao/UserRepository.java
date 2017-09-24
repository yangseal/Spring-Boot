package com.security.dao;

import com.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
