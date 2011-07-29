package exist.practice.service;

import java.util.List;

import exist.practice.User;

public interface UserService {
	public List<User> findAllUser();

	public boolean addUser(User object);
	
	public boolean updateUser(User object);

	public boolean deleteUser(long id, Class<User> clazz);

	public List<User> findUser(String column, String value);
	
	public List<User> findUsers(String column, String value);

}
