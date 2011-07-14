package exist.practice.dao.impl;

import static org.junit.Assert.assertTrue;

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
		assertTrue("User 1 added success", genericDao.add(user));
		//assertTrue(true);
	}
	
	@Test
	public void testDelete(){
		User user = new User();
		user.setUserName("test-username-1");
		assertTrue("User 1 added:", genericDao.add(user));
		assertTrue("Delete User 1:",genericDao.delete(1, User.class));
		
	}

}
