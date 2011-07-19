package exist.practice.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exist.practice.Org;
import exist.practice.User;
import exist.practice.dao.GenericDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/practiceProject-test-config.xml" })
public class GenericDaoImplTest {
	
	@Autowired
	private GenericDao genericDao;

	@SuppressWarnings("unchecked")
	@Test
	public void testAdd() {
		User user = new User();
		user.setUserName("test-username-1");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setMi("A");
		String date = "1990-05-19";
		/*user.setBirthDate(new DateTime(date));*/
		user.setBirthDate(date);
		user.setEmailAddress("emailAddress");
		user.setContactNumber("contactNumber");
		assertTrue("User 1 added", genericDao.add(user));
		assertTrue("Delete User 1:",genericDao.delete(1, User.class));
		
		Org org = new Org();
		org.setOrgName("org1");
		assertTrue("Org1 added",genericDao.add(org));
		assertTrue("Delete Org1",genericDao.delete(1, Org.class));
		
	}
	
	@Test
	public void testUpdate(){
		User user = new User();
		user.setUserName("test-username-2");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setMi("A");
		String date = "1990-05-19";
		/*user.setBirthDate(new DateTime(date));*/
		user.setBirthDate(date);
		user.setEmailAddress("emailAddress");
		user.setContactNumber("contactNumber");
		assertTrue("Added User2",genericDao.add(user));
		
		Org org = new Org();
		org.setOrgName("org2");
		assertTrue("Added Org2",genericDao.add(org));
		
		user = (User) genericDao.findLike("User", "userId", "2").get(0);
		assertEquals("Check userId for User2",2,user.getUserId());
		Set<Org> orgs = user.getOrgs();
		if(orgs == null){
			orgs = new HashSet<Org>();
		}
		orgs.add(org);
		user.setOrgs(orgs);
		assertTrue("Update User2's set of Orgs",genericDao.update(user));
		
		List<Org> orgList = genericDao.findLike("Org", "orgId", "2");
		org = orgList.get(0);
		
		assertEquals("Check org2 id",2,org.getOrgId());
		assertEquals("Check number of members in org2",1,org.getMembers().size());
		System.out.println(org.getOrgId()+"++++++++++++++++++++++++++++++");
		GenericDaoImpl<Org> test = new GenericDaoImpl<Org>();
		assertFalse("Delete Org2",test.delete(2, Org.class));
		//assertFalse("Delete Org2",genericDao.delete(2, Org.class));
		System.out.println("----------");
		assertTrue("Delete User2",genericDao.delete(2, User.class));
	}
	
	@Test
	public void testDelete(){
		User user = new User();
		user.setUserName("test-username-3");
		assertTrue("User 1 added", genericDao.add(user));
		assertTrue("Delete User 1:",genericDao.delete(3, User.class));
		assertFalse(genericDao.delete(3, User.class));
	}
	
	@Test
	public void testFindAll(){
		User user = new User();
		user.setUserName("test-username-1");
		genericDao.add(user);
		user.setUserName("test-username-2");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setMi("A");
		String date = "1990-05-19";
		/*user.setBirthDate(new DateTime(date));*/
		user.setBirthDate(date);
		user.setEmailAddress("emailAddress");
		user.setContactNumber("contactNumber");
		genericDao.add(user);
		
		assertEquals(genericDao.findAll("User").size(),2);
	}

	@Test
	public void testFindLike(){
		User user = new User();
		user.setUserName("test-username-4");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setMi("A");
		String date = "1990-05-19";
		/*user.setBirthDate(new DateTime(date));*/
		user.setBirthDate(date);
		user.setEmailAddress("emailAddress");
		user.setContactNumber("contactNumber");
	    genericDao.add(user);
		
		List<User> res = (List<User>) genericDao.findLike("User", "userId", "4");
		User t_user = (User) res.get(0);
		
		assertEquals(1,res.size());
		
	}
	
}
