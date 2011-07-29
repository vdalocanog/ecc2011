package exist.practice.dao;

import java.util.List;

public interface GenericDao<T> {

	public List<T> findAll(String table);
	public boolean add(T object);
	public boolean update(T object);
	public boolean delete(long id, Class<T> clazz);
	public List<T> findLike(String table, String column, String value);
	public List<T> findContains(String table, String column, String value);
}
