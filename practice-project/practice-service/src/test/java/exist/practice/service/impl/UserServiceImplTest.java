package exist.practice.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exist.practice.User;
import exist.practice.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/practiceProject-test-config.xml" })
public class UserServiceImplTest {
	private UserService userService;
	
	@Autowired
	public void setUserServiceImpl(UserService userService) {
		this.userService = userService;
	}
	
	@Test
	public void TestAddUser(){
		User user = new User();
		user.setUserName("testService-username1");
		assertTrue("Test UserServiceImpl-Add",userService.addUser(user));
	}

}
