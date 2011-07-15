package exist.practice.service;

import java.util.List;

import exist.practice.User;

public interface UserService {
	public List<User> findAll(String table);

	public boolean add(User object);

	public boolean delete(long id, Class<User> clazz);

	public List<User> findLike(String table, String column, String value);

}
