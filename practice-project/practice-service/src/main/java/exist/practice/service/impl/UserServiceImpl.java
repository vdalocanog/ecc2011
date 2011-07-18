package exist.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import exist.practice.User;
import exist.practice.dao.GenericDao;
import exist.practice.dao.impl.GenericDaoImpl;
import exist.practice.service.UserService;

public class UserServiceImpl extends GenericDaoImpl<User> implements UserService{

	private GenericDao<User> genericDao;
	
	@Autowired
	public void setGenericDao(GenericDao<User> genericDao) {
		this.genericDao = genericDao;
	}

	public List<User> findAll(String table) {
		// TODO Auto-generated method stub
		List<User> result = this.findAll(table);
		return result;
	}

	public boolean add(User object) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName("Mark");
		user.setMi('G');
		boolean result = genericDao.add(user);//super.add(user);
		return result;
	}

	public boolean delete(long id, Class<User> clazz) {
		// TODO Auto-generated method stub
		boolean result = this.delete(id, clazz);
		return result;
	}

	public List<User> findLike(String table, String column, String value) {
		// TODO Auto-generated method stub
		List<User> result = this.findLike(table, column, value);
		return result;
	}

}
