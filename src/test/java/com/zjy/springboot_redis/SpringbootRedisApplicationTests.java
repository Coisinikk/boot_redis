package com.zjy.springboot_redis;

import com.zjy.springboot_redis.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {
	@Autowired
	private RedisTemplate redisTemplate;
	@Test
	void contextLoads() {
		redisTemplate.opsForValue().set("name","notebook");
		System.out.println(redisTemplate.opsForValue().get("name"));
	}
	@Test
	public void setStudent(){
		Student student = new Student();
		student.setId(001);
		student.setName("jack");
		student.setAge(23);
		redisTemplate.opsForValue().set("student",student);
		System.out.println(redisTemplate.opsForValue().get("student"));
	}
}
