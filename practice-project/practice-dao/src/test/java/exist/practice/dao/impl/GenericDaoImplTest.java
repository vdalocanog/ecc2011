package exist.practice.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exist.practice.User;
import exist.practice.dao.GenericDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/practiceProject-test-config.xml" })
public class GenericDaoImplTest {

	private GenericDao<User> genericDao;

	@Autowired
	public void setGenericDAO(GenericDao<User> genericDao) {
		this.genericDao = genericDao;
	}

	@Test
	public void testAdd() {
		User user = new User();
		user.setUserName("test-username-1");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setMi('A');
		String date = "1990-05-19";
		user.setBirthDate(new DateTime(date));
		user.setEmailAddress("emailAddress");
		user.setContactNumber("contactNumber");
		assertTrue("User 1 added success", genericDao.add(user));
		assertTrue("Delete User 1:",genericDao.delete(1, User.class));
	}
	
	@Test
	public void testDelete(){
		User user = new User();
		user.setUserName("test-username-1");
		assertTrue("User 1 added:", genericDao.add(user));
		assertTrue("Delete User 1:",genericDao.delete(2, User.class));
		
	}
	
	@Test
	public void testFindAll(){
		User user = new User();
		user.setUserName("test-username-1");
		genericDao.add(user);
		user.setUserName("test-username-2");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setMi('A');
		String date = "1990-05-19";
		user.setBirthDate(new DateTime(date));
		user.setEmailAddress("emailAddress");
		user.setContactNumber("contactNumber");
		genericDao.add(user);
		assertEquals(genericDao.findAll("User").size(),2);
		assertTrue(genericDao.delete(3, User.class));
		assertTrue(genericDao.delete(4, User.class));
		assertFalse(genericDao.delete(3, User.class));
	}

	@Test
	public void testFindLike(){
		User user = new User();
		user.setUserName("test-username-2");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setMi('A');
		String date = "1990-05-19";
		user.setBirthDate(new DateTime(date));
		user.setEmailAddress("emailAddress");
		user.setContactNumber("contactNumber");
		genericDao.add(user);
		String id = String.valueOf(user.getUserId());
		
		List<User> res = (List<User>) genericDao.findLike("User", "userId", id);
		User t_user = (User) res.get(0);
		assertEquals(1,res.size());
		assertEquals(user.getUserName(),t_user.getUserName());
		
	}
	
}
