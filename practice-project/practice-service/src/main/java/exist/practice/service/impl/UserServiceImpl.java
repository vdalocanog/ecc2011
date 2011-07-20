package exist.practice.service.impl;

import java.util.List;

import exist.practice.User;
import exist.practice.dao.impl.GenericDaoImpl;
import exist.practice.service.UserService;

public class UserServiceImpl extends GenericDaoImpl<User> implements UserService{
	
	public boolean addUser(User object) {
		boolean res = this.add(object);
		return res;
	}
	
	public boolean updateUser(User object) {
		// TODO Auto-generated method stub
		boolean res = this.update(object);
		return res;
	}

	public boolean deleteUser(long id, Class<User> clazz) {
		// TODO Auto-generated method stub
		boolean res = this.delete(id, clazz);
		return res;
	}

	public List<User> findUser(String column, String value) {
		// TODO Auto-generated method stub
		List<User> res = this.findLike("User", column, value);
		//if(res.size() == 0) return null;
		return res;
	}

	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		List<User> res = this.findAll("User");
		return res;
	}

}
