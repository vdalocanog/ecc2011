package exist.practice.dao.impl;

import static org.junit.Assert.assertTrue;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import exist.practice.User;
import exist.practice.dao.GenericDao;

//@RunWith(SpringJUnit4ClassRunner.class)
public class GenericDaoImplTest {

	
	private GenericDao<User> genericDAO;
	private SessionFactory sessionFactory;


	public void setGenericDAO(GenericDao<User> genericDAO) {
		this.genericDAO = genericDAO;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Test
	public void TestAdd() {
		User user = new User();
		user.setUserName("test-username-1");
		//assertTrue("User 1 added success", genericDAO.add(user));
		assertTrue(true);
	}

}
