package com.cache;

import com.cache.model.User;
import com.cache.model.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {
	@Autowired
	private UserRepository userRepository;
	/*@Before
	public void before() {
		userRepository.save(new User("AAA", 10));
	}*/
	@Test
	public void test() throws Exception {
		User user1 = userRepository.findByName("BBB");
		System.out.println("第一次查询：" + user1.getAge());
		User user2 = userRepository.findByName("BBB");
		System.out.println("第二次查询：" + user2.getAge());
	}
}
