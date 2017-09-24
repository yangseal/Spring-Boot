package com.example;

import com.example.Dao.UserDao;
import com.example.Domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private UserDao userDao;
	@Test
	public void contextLoads() {
		User user = null;
		try {
			user = userDao.findUserById(1);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
